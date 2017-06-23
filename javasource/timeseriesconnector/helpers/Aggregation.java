package timeseriesconnector.helpers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import io.swagger.api.AggregationsApi;
import io.swagger.model.AggregationDto;

public class Aggregation {
	private static ILogNode _logNode = Core.getLogger("TimeSeries");
	
	
	public static List<IMendixObject> aggregateBetweenTimestamps(IMendixObject aggregationParameter, String assetID, String channelKey,
			Long startTime, Long endTime, String aggregationPeriod, String timeZone, String measurementType, IContext context) throws ApiException {
			_logNode.info("Starting aggregation of measurements");
		try {
			String timeZoneTuned = timeZone.replace("/", "%2F");
			List<IMendixObject> aggregationList;
			AggregationsApi aApi = createAggregationsApi();
			//source-interval is not required, so don't send it
			List<AggregationDto> aggregationDtoList = aApi.aggregateMeasurementsBetweenUsingGET(assetID, channelKey, startTime, endTime, aggregationPeriod, timeZoneTuned, measurementType, null);
			aggregationList = aggregationDtoToIMendixObject(aggregationDtoList, aggregationParameter, context);
			
			_logNode.info("aggregation done");
			return aggregationList;
		} catch (ApiException e) {
			_logNode.error("Aggregation resulted in an error");
			throw new ApiException("Something went wrong while executing your aggregate request:" + e);
		} 
		
	}


	private static List<IMendixObject> aggregationDtoToIMendixObject(List<AggregationDto> aggregationDtoList,
			IMendixObject aggregationParameter, IContext context) {
		
		List<IMendixObject> aggregationList = new ArrayList<IMendixObject>();
		for(AggregationDto aggregationDto : aggregationDtoList) {
			IMendixObject mo = Core.instantiate(context, aggregationParameter.getType());
			mo.setValue(context, "assetID",  aggregationDto.getAssetId());
			mo.setValue(context, "channelKey", aggregationDto.getChannelKey());
			mo.setValue(context,"count", aggregationDto.getCount());
			mo.setValue(context, "start", aggregationDto.getStart());
			mo.setValue(context, "end", aggregationDto.getEnd());
			Double doubleValue = aggregationDto.getValue();
			BigDecimal decimalValue = new BigDecimal(doubleValue);
			mo.setValue(context, "value",decimalValue);
			aggregationList.add(mo);
			
		}		
		return aggregationList;
	}


	private static AggregationsApi createAggregationsApi() throws ApiException {
		try {
			JacksonJsonProvider provider = new JacksonJsonProvider();
			List<JacksonJsonProvider> providers = new ArrayList<JacksonJsonProvider>();
			providers.add(provider);
			AggregationsApi aApi = JAXRSClientFactory.create(Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesBasePath").toString(), AggregationsApi.class, providers);
			org.apache.cxf.jaxrs.client.Client client = WebClient.client(aApi);
			String accessToken = Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesAccessKey").toString();
			client.header("X-Access-Token", accessToken );
			return aApi;
		} catch (Exception e) {
			throw new ApiException("Error while creating the API object ", e);
		}
	}
	
}
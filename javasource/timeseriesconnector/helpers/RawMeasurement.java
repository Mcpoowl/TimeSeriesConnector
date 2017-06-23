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

import io.swagger.api.MeasurementsApi;
import io.swagger.model.RawMeasurementDto;


public class RawMeasurement {
	private static ILogNode _logNode = Core.getLogger("TimeSeries");

	public static Boolean storeMeasurement(IContext context, List<IMendixObject> rawMeasurementList, Boolean retry,	Boolean batch) throws ApiValidationException, ApiException {
		try {
			_logNode.info("Storing measurement");
			if(rawMeasurementList.isEmpty()) {
			    throw new ApiValidationException("rawMeasurementList must contain at least one entry, but was empty");
			} 
			List<RawMeasurementDto> rawDtoList = new ArrayList<RawMeasurementDto>();
			for(IMendixObject measurement :rawMeasurementList) {
			RawMeasurementDto rawDto =	createRawMeasurementDto(context, measurement);
			rawDtoList.add(rawDto);
			}

			MeasurementsApi mApi = createMeasurementApi();
			mApi.createUsingPOST(rawDtoList, batch.toString(), retry.booleanValue());
			return true;
		} catch (Exception e) {
			throw new ApiException("Error while storing measurements", e);
		}

	}

	private static MeasurementsApi createMeasurementApi() throws ApiException {
	    try {
			JacksonJsonProvider provider = new JacksonJsonProvider();
			List<JacksonJsonProvider> providers = new ArrayList<JacksonJsonProvider>();
			providers.add(provider);
			MeasurementsApi MApi = JAXRSClientFactory.create(Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesBasePath").toString(), MeasurementsApi.class, providers);
			org.apache.cxf.jaxrs.client.Client client = WebClient.client(MApi);
			String accessToken = Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesAccessKey").toString();
			client.header("X-Access-Token", accessToken );
			return MApi;
		} catch (Exception e) {
			throw new ApiException("Error while creating the API object ", e);
		}
	}

	private static RawMeasurementDto createRawMeasurementDto(IContext context, IMendixObject measurement) throws ApiException {
		try {
			RawMeasurementDto rawDto = new RawMeasurementDto();
			rawDto.setAssetId(measurement.getMember(context, "assetID").getValue(context).toString());
			rawDto.setChannelKey(measurement.getMember(context, "channelKey").getValue(context).toString());
			rawDto.setDateTime(measurement.getMember(context, "dateTime").getValue(context).toString());
			rawDto.setType(measurement.getMember(context, "measurementType").getValue(context).toString());
			Double value = Double.parseDouble(measurement.getMember(context, "value").getValue(context).toString());
			rawDto.setValue(value);
			return rawDto;
		} catch (NumberFormatException e) {
			throw new ApiException("Error while creating measurementObject ", e);
		}
		

	}

	public static Boolean deleteMeasurements(String assetID, String channelKey) throws ApiException {
		try {
			MeasurementsApi mApi = createMeasurementApi();
			mApi.deleteMeasurementsUsingDELETE(assetID, channelKey);
			return true;
		} catch (ApiException e) {
			throw new ApiException("Error while deleting measurements", e);
		}
	}

	public static List<IMendixObject> searchMeasurementsByDate(String assetID, String channelKey,
			String measurementType, Long dateTime, Long limit, IMendixObject measurementParameter, IContext context) throws ApiException {
			try {
				MeasurementsApi mApi = createMeasurementApi();
				List<RawMeasurementDto> measurementDtoList = mApi.findMeasurementsBeforeUsingGET1(assetID, channelKey, measurementType, dateTime, limit.intValue());
				List<IMendixObject> mendixMeasurementList;
				mendixMeasurementList = MeasurementDtoToIMendixObjectList(measurementDtoList, measurementParameter, context);
		
				return mendixMeasurementList;
			} catch (ApiException e) {
				throw new ApiException("Error while searching for measurements", e);
			}

	}
	
	public static List<IMendixObject> searchUniqueMeasurement(String assetID, String channelKey,
			String measurementType, Long dateTime, IMendixObject measurementParameter, IContext context) throws ApiException {
			try {
				MeasurementsApi mApi = createMeasurementApi();
				//Add the single value to a list, so we can reuse existing functions
				List<RawMeasurementDto> measurementDtoList = new ArrayList<RawMeasurementDto>();
				RawMeasurementDto	measurementDtoObject = mApi.findMeasurementUsingGET1(assetID, channelKey, measurementType, dateTime);
				measurementDtoList.add(measurementDtoObject);
				List<IMendixObject> mendixMeasurementList;
				mendixMeasurementList = MeasurementDtoToIMendixObjectList(measurementDtoList, measurementParameter, context);
		
				return mendixMeasurementList;
			} catch (ApiException e) {
				throw new ApiException("Error while searching for measurements", e);
			}

	}
	
	public static List<IMendixObject> searchMeasurementsBetweenDates(String assetID, String channelKey,
			String measurementType, Long dateTimeStart, Long dateTimeEnd, IMendixObject measurementParameter, IContext context) throws ApiException {
			try {
				MeasurementsApi mApi = createMeasurementApi();
				List<RawMeasurementDto> measurementDtoList = mApi.findMeasurementsBetweenUsingGET1(assetID, channelKey, measurementType, dateTimeStart, dateTimeEnd);
				List<IMendixObject> mendixMeasurementList;
				mendixMeasurementList = MeasurementDtoToIMendixObjectList(measurementDtoList, measurementParameter, context);
		
				return mendixMeasurementList;
			} catch (ApiException e) {
				throw new ApiException("Error while searching for measurements", e);
			}
	
	}
	
	
	public static List<IMendixObject> searchMeasurementsFirst(String assetID, String channelKey,
			String measurementType, Long limit, IMendixObject measurementParameter, IContext context) throws ApiException {
			try {
				MeasurementsApi mApi = createMeasurementApi();
				List<RawMeasurementDto> measurementDtoList = mApi.findFirstMeasurementsUsingGET(assetID, channelKey, measurementType, limit.intValue());
				List<IMendixObject> mendixMeasurementList;
				mendixMeasurementList = MeasurementDtoToIMendixObjectList(measurementDtoList, measurementParameter, context);
		
				return mendixMeasurementList;
			} catch (ApiException e) {
				throw new ApiException("Error while searching for measurements", e);
			}
	
	}
	
	public static Long countMeasurements(String assetID, String channelKey,
			String measurementType, Long dateTimeStart, Long dateTimeEnd) throws ApiException {
			try {
				MeasurementsApi mApi = createMeasurementApi();
				Long measurementCount= mApi.countMeasurementsBetweenUsingGET1(assetID, channelKey, measurementType, dateTimeStart, dateTimeEnd);
		
				return measurementCount;
			} catch (ApiException e) {
				throw new ApiException("Error while searching for measurements", e);
			}
	
	}
	

	private static List<IMendixObject> MeasurementDtoToIMendixObjectList(List<RawMeasurementDto> measurementDtoList,IMendixObject measurementParameter, IContext context) {
	    List <IMendixObject> measurementList = new ArrayList<IMendixObject>();
	    for(RawMeasurementDto measurementDto : measurementDtoList) {
	    	
	    	IMendixObject mo = Core.instantiate(context, measurementParameter.getType());
	    	mo.setValue(context, "assetID", measurementDto.getAssetId());
	    	mo.setValue(context, "channelKey", measurementDto.getChannelKey());
	    	mo.setValue(context, "dateTime", measurementDto.getDateTime());
	    	mo.setValue(context, "measurementType", measurementDto.getType());
	    	Double doubleValue = measurementDto.getValue();
	    	String stringValue = doubleValue.toString();
	    	BigDecimal decimalValue = new BigDecimal(stringValue);
	    	mo.setValue(context, "value", decimalValue);
	    	measurementList.add(mo);  	
	    	
	    }
	    
	    return measurementList;

	}


}

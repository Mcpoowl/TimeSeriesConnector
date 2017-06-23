package timeseriesconnector.helpers;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotAuthorizedException;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.mendix.core.Core;
import com.mendix.core.objectmanagement.member.MendixObjectReference;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

import io.swagger.api.AssetsApi;
import io.swagger.model.AssetDto;
import io.swagger.model.ChannelDto;



public class AssetManagement {
	
    static ILogNode _logNode = Core.getLogger("TimeSeries");
    
    public static List<IMendixObject> getAssets(IMendixObject assetParameter, IMendixObject channelParameter, IContext context) throws ApiException {
    	_logNode.info("Retrieving assets");
    	
    	try {
			List<IMendixObject> assetList;
			AssetsApi aApi = createAssetsApi();
			List<AssetDto> assetDtoList = aApi.findAllUsingGET();
			assetList = AssetDtoToIMendixObjectList(assetDtoList, assetParameter, channelParameter, context);
	    	_logNode.info("Assets succesfully retrieved");
			return assetList;
		} catch (Exception e) {
	    	_logNode.error("Error retrieving assets");
			throw new ApiException("Error while retrieving assets",e);
		}
    	
    }
    
    public static String createAsset(String assetName, IContext context) throws ApiException {
        _logNode.info("Creating asset");
        AssetsApi aApi = createAssetsApi();
        String assetID = null;
        try {
			AssetDto aDto = createAssetDto();
			aDto.setName(assetName);
			aDto = aApi.addUsingPOST(aDto);
			assetID = aDto.getId();
			_logNode.info("Asset with id " + assetID + " succesfully created");
			System.out.println(aDto.getId());
	        return assetID;
			} catch (Exception e) {
				throw new ApiException("Error while creating asset", e);
			}
    }
    
    public static Boolean updateAsset(String assetName, String assetID, IContext context) throws ApiException {
        _logNode.info("Updating asset");
        AssetsApi aApi = createAssetsApi();
        try {
			AssetDto aDto = createAssetDto();
			aDto.setName(assetName);
			aDto.setId(assetID);
			aApi.updateUsingPUT(assetID, aDto);
			_logNode.info("Asset with id " + assetID + " succesfully updated");
	        return true;
			} catch (Exception e) {
				throw new ApiException("Error while updating asset", e);
			}
    }
    
    public static Boolean deleteAsset(String assetId) throws ApiException, NotAuthorizedException {
        _logNode.info("Deleting asset");
        AssetsApi aApi = createAssetsApi();
        try {
        	String assetIdForLog = assetId;
			aApi.deleteUsingDELETE(assetId);
			_logNode.info("Asset with id " + assetIdForLog + " succesfully deleted");
	        return true;
			} catch (Exception e) {
				throw new ApiException("Error while deleting asset", e);
			}
    }
    
    public static java.util.List<IMendixObject> searchAssetsByName(String searchName, IMendixObject assetObject, IMendixObject channelObject, IContext context) throws ApiException {
		_logNode.info("Searching assets by name");
		AssetsApi aApi = createAssetsApi(); 
		try {
			List <AssetDto> assetDtoList = aApi.findByNameStartsWithUsingGET(searchName);
			List<IMendixObject> mendixAssetList;
			mendixAssetList = AssetDtoToIMendixObjectList(assetDtoList, assetObject,channelObject, context);
			return mendixAssetList;			
		} catch (Exception e) {
			throw new ApiException("Error while searcing for asset with name " + searchName , e);
		}
    }
    
    
    public static IMendixObject searchAssetById(String assetID, IMendixObject assetObject, IContext context) throws ApiException {
		_logNode.info("Searching asset by ID");
		AssetsApi aApi = createAssetsApi(); 
		try {
			AssetDto aDto = aApi.findOneUsingGET(assetID);
			if (aDto != null) {
				IMendixObject mo = Core.instantiate(context, assetObject.getType());
				mo.setValue(context, "assetID", aDto.getId());
				mo.setValue(context, "name", aDto.getName());
				return mo;			
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new ApiException("Error while searcing for asset with ID " + assetID , e);
		}
    }
    private static AssetDto createAssetDto() throws ApiValidationException {
        AssetDto aDto = new AssetDto();
        return aDto;
    }
    
    private static ChannelDto createChannelDto(String channelKey, Long measurementInterval) throws ApiValidationException {
        if(channelKey == null || channelKey == "") {
        	throw new ApiValidationException("channelKey is a required field, but was empty");
        }
        ChannelDto cDto = new ChannelDto();
        cDto.setKey(channelKey);
        cDto.setMeasurementInterval(measurementInterval.intValue());
        return cDto;
    }
    
    private static AssetsApi createAssetsApi() {
	    JacksonJsonProvider provider = new JacksonJsonProvider();
	    List<JacksonJsonProvider> providers = new ArrayList<JacksonJsonProvider>();
	    providers.add(provider);
	    AssetsApi api = JAXRSClientFactory.create(Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesBasePath").toString(), AssetsApi.class, providers);
	    org.apache.cxf.jaxrs.client.Client client = WebClient.client(api);
        String accessToken = Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesAccessKey").toString();
        client.header("X-Access-Token", accessToken );
        return api;
    }       
    
    private static List <IMendixObject> AssetDtoToIMendixObjectList(List <AssetDto> assetDtoList, IMendixObject assetObject, IMendixObject channelObject, IContext context) {
	    List <IMendixObject> assetList = new ArrayList<IMendixObject>();
	    for(AssetDto aDto : assetDtoList) {
	    	IMendixObject mo = Core.instantiate(context, assetObject.getType());
	    	List<ChannelDto> channelList = aDto.getChannels();
	    	for(ChannelDto cDto : channelList) {
	    		IMendixObject channelobj = Core.instantiate(context, channelObject.getType());
	    		channelobj.setValue(context, "key", cDto.getKey());
	    		channelobj.setValue(context, "measurementInterval", cDto.getMeasurementInterval());
	    		List<? extends MendixObjectReference> refList = channelobj.getReferences(context);
	    		for(MendixObjectReference ref : refList) {
	    			if(ref.getName().contains("SearchChannel_SearchAsset")) {
	    	    		channelobj.setValue(context, ref.getName(), mo.getId());
	    			}
	    		}

	    	}
	    	mo.setValue(context, "name", aDto.getName());
	    	mo.setValue(context, "assetID", aDto.getId());
	    	assetList.add(mo);
    	}
    	return assetList;
    }

	public static boolean addChannel(String assetID, String channelKey, Long measurementInterval) throws ApiException {
		_logNode.info("Adding channel to specified asset");
		AssetsApi aApi = createAssetsApi();
		try {
			aApi.addChannelUsingPOST(assetID, createChannelDto(channelKey, measurementInterval));
			_logNode.info("Channel succesfully added to asset " + assetID);
			return true;
		} catch (Exception e) {
			throw new ApiException("Error while adding channel to asset " + assetID, e);
		}

	}

	public static Boolean deleteChannel(IContext context, String assetID, String channelKey) throws ApiValidationException, ApiException {
		_logNode.info("deleting channel from specified asset");
        if(assetID == null || assetID.length() == 0){
        	throw new ApiValidationException("assetID is a required field, but was empty");
        }
        if(channelKey == null || channelKey.length() == 0){
        	throw new ApiValidationException("channelKey is a required field, but was empty");
        }
		AssetsApi aApi = createAssetsApi();
		try {
			aApi.deleteChannelUsingDELETE(assetID, channelKey);
			_logNode.info("channel deleted from asset");
			return true;
		} catch (Exception e) {
			throw new ApiException("Error while deleting channel with key " + channelKey + " from asset "  + assetID, e);
		}
	}
}
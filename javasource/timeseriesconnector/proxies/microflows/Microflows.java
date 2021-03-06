// This file was generated by Mendix Modeler 6.0.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package timeseriesconnector.proxies.microflows;

import java.util.HashMap;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class Microflows
{
	// These are the microflows for the TimeSeriesConnector module
	public static timeseriesconnector.proxies.AssetSearchResult dS_GetAssetSearchResult_Single(IContext context, timeseriesconnector.proxies.Search _search)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Search", _search == null ? null : _search.getMendixObject());
			IMendixObject result = (IMendixObject)Core.execute(context, "TimeSeriesConnector.DS_GetAssetSearchResult_Single", params);
			return result == null ? null : timeseriesconnector.proxies.AssetSearchResult.initialize(context, result);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_AddChannel(IContext context, timeseriesconnector.proxies.Channel _channel)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Channel", _channel == null ? null : _channel.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_AddChannel", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_CreateAsset(IContext context, timeseriesconnector.proxies.Asset _asset)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Asset", _asset == null ? null : _asset.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_CreateAsset", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_DeleteAsset(IContext context, timeseriesconnector.proxies.Asset _asset)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Asset", _asset == null ? null : _asset.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_DeleteAsset", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_DeleteChannel(IContext context, timeseriesconnector.proxies.Channel _channel)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Channel", _channel == null ? null : _channel.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_DeleteChannel", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_DeleteMeasurements(IContext context, timeseriesconnector.proxies.RawMeasurement _rawMeasurement)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RawMeasurement", _rawMeasurement == null ? null : _rawMeasurement.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_DeleteMeasurements", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SearchAsset_Open(IContext context)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			Core.execute(context, "TimeSeriesConnector.IVK_SearchAsset_Open", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SearchAsset_Search(IContext context, timeseriesconnector.proxies.Search _search)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Search", _search == null ? null : _search.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_SearchAsset_Search", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SearchMeasurements(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_SearchMeasurements", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_SearchMeasurements_Open(IContext context)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			Core.execute(context, "TimeSeriesConnector.IVK_SearchMeasurements_Open", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void iVK_StoreMeasurement(IContext context, timeseriesconnector.proxies.RawMeasurement _rawMeasurement)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("RawMeasurement", _rawMeasurement == null ? null : _rawMeasurement.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.IVK_StoreMeasurement", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sUB_DeleteMeasurements(IContext context, String _assetID, String _channelKey)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("assetID", _assetID);
			params.put("channelKey", _channelKey);
			Core.execute(context, "TimeSeriesConnector.SUB_DeleteMeasurements", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sUB_SearchMeasurements_BetweenDates(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.SUB_SearchMeasurements_BetweenDates", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static Long sUB_SearchMeasurements_Count(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			return (Long)Core.execute(context, "TimeSeriesConnector.SUB_SearchMeasurements_Count", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sUB_SearchMeasurements_First(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.SUB_SearchMeasurements_First", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sUB_SearchMeasurements_MaxDate(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.SUB_SearchMeasurements_MaxDate", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sUB_SearchMeasurements_Unique(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.SUB_SearchMeasurements_Unique", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static void sUB_UpdateAsset(IContext context, timeseriesconnector.proxies.Asset _asset)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("Asset", _asset == null ? null : _asset.getMendixObject());
			Core.execute(context, "TimeSeriesConnector.SUB_UpdateAsset", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sUB_ValidateSearch_BetweenDate(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			return (Boolean)Core.execute(context, "TimeSeriesConnector.SUB_ValidateSearch_BetweenDate", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sUB_ValidateSearch_Count(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			return (Boolean)Core.execute(context, "TimeSeriesConnector.SUB_ValidateSearch_Count", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sUB_ValidateSearch_First(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			return (Boolean)Core.execute(context, "TimeSeriesConnector.SUB_ValidateSearch_First", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sUB_ValidateSearch_MaxDate(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			return (Boolean)Core.execute(context, "TimeSeriesConnector.SUB_ValidateSearch_MaxDate", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
	public static boolean sUB_ValidateSearch_Unique(IContext context, timeseriesconnector.proxies.MeasurementSearch _measurementSearch)
	{
		try
		{
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("MeasurementSearch", _measurementSearch == null ? null : _measurementSearch.getMendixObject());
			return (Boolean)Core.execute(context, "TimeSeriesConnector.SUB_ValidateSearch_Unique", params);
		}
		catch (CoreException e)
		{
			throw new MendixRuntimeException(e);
		}
	}
}
// This file was generated by Mendix Modeler 6.0.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package timeseriesconnector.proxies.constants;

import com.mendix.core.Core;

public class Constants
{
	// These are the constants for the TimeSeriesConnector module

	/**
	* Dateformat for the REST calls
	*/
	public static String getDateformat()
	{
		return (String)Core.getConfiguration().getConstantValue("TimeSeriesConnector.Dateformat");
	}

	/**
	* The key you received after registering for an account at
	* 
	* http://connector.timeseries.nl
	*/
	public static String getTimeSeriesAccessKey()
	{
		return (String)Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesAccessKey");
	}

	/**
	* The basePath where the service resides
	*/
	public static String getTimeSeriesBasePath()
	{
		return (String)Core.getConfiguration().getConstantValue("TimeSeriesConnector.TimeSeriesBasePath");
	}
}
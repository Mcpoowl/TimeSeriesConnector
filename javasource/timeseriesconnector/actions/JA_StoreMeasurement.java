// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package timeseriesconnector.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import timeseriesconnector.helpers.RawMeasurement;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Store measurements. A single or an array of measurements
 * 
 * Parameters
 * 
 * List of RawMeasurement containing
 * -AssetID
 * -ChannelKey
 * -DateTime
 * -Type
 * -Value
 * 
 * Retry --> whether to retry in case of failue
 * batch --> whether to process the measurements in batches
 */
public class JA_StoreMeasurement extends CustomJavaAction<Boolean>
{
	private java.util.List<IMendixObject> RawMeasurementList;
	private Boolean retry;
	private Boolean batch;

	public JA_StoreMeasurement(IContext context, java.util.List<IMendixObject> RawMeasurementList, Boolean retry, Boolean batch)
	{
		super(context);
		this.RawMeasurementList = RawMeasurementList;
		this.retry = retry;
		this.batch = batch;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		return RawMeasurement.storeMeasurement(this.getContext(), RawMeasurementList, retry, batch );
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "JA_StoreMeasurement";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

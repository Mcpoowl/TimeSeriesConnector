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

public class JA_SearchMeasurementsUnique extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private String assetID;
	private String channelKey;
	private String measurementType;
	private Long dateTime;
	private IMendixObject measurementParameter;

	public JA_SearchMeasurementsUnique(IContext context, String assetID, String channelKey, String measurementType, Long dateTime, IMendixObject measurementParameter)
	{
		super(context);
		this.assetID = assetID;
		this.channelKey = channelKey;
		this.measurementType = measurementType;
		this.dateTime = dateTime;
		this.measurementParameter = measurementParameter;
	}

	@Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		return RawMeasurement.searchUniqueMeasurement(assetID, channelKey, measurementType, dateTime, measurementParameter, this.getContext());
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "JA_SearchMeasurementsUnique";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
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
import timeseriesconnector.helpers.AssetManagement;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class JA_GetAllAssets extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private IMendixObject asset;
	private IMendixObject channel;

	public JA_GetAllAssets(IContext context, IMendixObject asset, IMendixObject channel)
	{
		super(context);
		this.asset = asset;
		this.channel = channel;
	}

	@Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		return AssetManagement.getAssets(asset, channel, this.getContext());
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "JA_GetAllAssets";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

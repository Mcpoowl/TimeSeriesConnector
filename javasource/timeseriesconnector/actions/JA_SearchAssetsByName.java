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

/**
 * This Java action searches for assets with names starting with the supplied String. An asset can have multiple Channels associated. To show these, we use the SearchChannel_SearchAsset association. Make sure this association exists between your ChannelTypeParameter and your AssetTypeParameter
 */
public class JA_SearchAssetsByName extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private String searchName;
	private IMendixObject AssetSearchResultParameter1;
	private IMendixObject ChannelParameter1;

	public JA_SearchAssetsByName(IContext context, String searchName, IMendixObject AssetSearchResultParameter1, IMendixObject ChannelParameter1)
	{
		super(context);
		this.searchName = searchName;
		this.AssetSearchResultParameter1 = AssetSearchResultParameter1;
		this.ChannelParameter1 = ChannelParameter1;
	}

	@Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		// BEGIN USER CODE
		return AssetManagement.searchAssetsByName(searchName, AssetSearchResultParameter1,ChannelParameter1, this.getContext());
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "JA_SearchAssetsByName";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

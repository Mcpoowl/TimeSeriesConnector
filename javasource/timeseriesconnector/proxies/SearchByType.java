// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package timeseriesconnector.proxies;

public enum SearchByType
{
	_ID(new String[][] { new String[] { "en_US", "ID" } }),
	_Name(new String[][] { new String[] { "en_US", "Name" } });

	private java.util.Map<String,String> captions;

	private SearchByType(String[][] captionStrings)
	{
		this.captions = new java.util.HashMap<String,String>();
		for (String[] captionString : captionStrings)
			captions.put(captionString[0], captionString[1]);
	}

	public String getCaption(String languageCode)
	{
		if (captions.containsKey(languageCode))
			return captions.get(languageCode);
		return captions.get("en_US");
	}

	public String getCaption()
	{
		return captions.get("en_US");
	}
}

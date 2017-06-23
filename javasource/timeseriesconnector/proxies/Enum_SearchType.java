// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package timeseriesconnector.proxies;

public enum Enum_SearchType
{
	MaxDate(new String[][] { new String[] { "en_US", "Max date" } }),
	BetweenDates(new String[][] { new String[] { "en_US", "Between dates" } }),
	FindFirst(new String[][] { new String[] { "en_US", "Find First" } }),
	FindUnique(new String[][] { new String[] { "en_US", "Find Unique" } }),
	Count(new String[][] { new String[] { "en_US", "Count" } });

	private java.util.Map<String,String> captions;

	private Enum_SearchType(String[][] captionStrings)
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

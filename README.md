# TimeSeriesConnector
Mendix TimeSeries Connector

# Typical Usage Scenario 
Do you want to process billions of records in a split second? Do you want to gain insight into complex and vast amounts of data? Check out the TimeSeries Analytics platform combined with the Mendix TimeSeries Connector! Learn how to supercharge your Mendix applications with the TimeSeries Analytics platform using the TimeSeries Connector!

Features and limitations

Uses APIs to connect to the TimeSeries Analytics platform

Asset Management
Storing of measurements
Retrieval of measurements by specific parameters
 

__The API is split in multiple ways__:

__Asset Management__; for all API calls related to assets and their channels
__Measurements__; for all API calls related to actual meausrements, be it storing them, or retrieving them
__Aggregation__; Calls to aggregate your measurements 
Every call requires authentication based on an X-Access-Token. A token will be sent to your email when registering.

For examples on how to use the different calls, there are some examples included when downloading the connector in your Mendix project

The TimeSeriesConnector uses the CommunityCommons’ DateTimeToLong function in the examples. Make sure to import that module as well to get rid of any errors you might have when importing the connector

# Dependencies
* Mendix 6.6.0 and up
* CommunityCommons

# Installation
* Download the TimeSeries Connector from the Appstore
* Download the CommunityCommons from the Appstore
* Read the documentation to configure the connector, which can be found at [TimeSeries Connector Documenation](http://connector.timeseries.nl/documentation.html)
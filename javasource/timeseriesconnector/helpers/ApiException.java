package timeseriesconnector.helpers;

import com.mendix.core.Core;

public class ApiException extends Exception {
	
	public ApiException () {
		
	}
	public ApiException(String message) {
		super(message);
	}
	public ApiException(Throwable cause) {
		super(cause);
	}
	public ApiException(String message, Throwable cause) {
		super(message, cause);
		Core.getLogger("TimeSeries").error(message, cause);
	}

}

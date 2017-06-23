package timeseriesconnector.helpers;

import com.mendix.core.Core;

public class ApiValidationException extends Exception {

	public ApiValidationException() {
		// TODO Auto-generated constructor stub
	}

	public ApiValidationException(String arg0) {
		super(arg0);
		Core.getLogger("TimeSeries").error("Validation error: " + arg0);
	}

	public ApiValidationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ApiValidationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ApiValidationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}

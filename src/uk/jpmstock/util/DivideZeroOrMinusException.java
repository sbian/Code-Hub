package uk.jpmstock.util;

/**
 * Class for raising an exception when a divided value in a division is less or equal zero.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class DivideZeroOrMinusException extends Exception {

	/** Warning message for an error raised */
	private static final String ERROR = "Value must not be a zero or minus.";
	
	/**
	 * Default Constructor.
	 */
	public DivideZeroOrMinusException() {
		super(ERROR);
	}

	public DivideZeroOrMinusException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DivideZeroOrMinusException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DivideZeroOrMinusException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DivideZeroOrMinusException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

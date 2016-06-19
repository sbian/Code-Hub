package uk.jpmstock.util;

/**
 * Class for raising an exception when a collection has no trade record.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class NoTradeException extends Exception {

	/** Warning message for an error. */
	private static final String ERROR = "No trade record.";
	
	/**
	 * Default Constructor.
	 */
	public NoTradeException() {
		super(ERROR);
	}

	public NoTradeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoTradeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NoTradeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoTradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

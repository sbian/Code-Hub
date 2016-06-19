package uk.jpmstock.util;

/**
 * Class for raising an exception when an object does not exist.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class NotExistStockException extends Exception {

	/** Warning message for an error when an object does not exist. */
	private static final String ERROR = "The stock does not exist.";
	public NotExistStockException() {
		super(ERROR);
	}

	public NotExistStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotExistStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NotExistStockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotExistStockException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

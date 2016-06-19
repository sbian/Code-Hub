package uk.jpmstock.util;

/**
 * Class for raising an exception when an object is not valid. 
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class NotValidStockException extends Exception {

	/** Warning message for an error  */
	private static final String ERROR = "Not a valid stock.";
	
	/**
	 * Default Constructor
	 */
	public NotValidStockException() {
		super(ERROR);
	}
	
	public NotValidStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NotValidStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NotValidStockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotValidStockException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

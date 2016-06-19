package uk.jpmstock.util;

/**
 * Class for raising an exception when a duplicated object exists.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class DuplicateStockException extends Exception {

	/** Warning message for an error */
	private static final String ERROR = "Stock has been existed.";
	
	/**
	 * Default Constructor.
	 */
	public DuplicateStockException() {
		super(ERROR);
	}

	public DuplicateStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DuplicateStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateStockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DuplicateStockException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

package uk.jpmstock.persistence;

/**
 * Class for dealing type, just Buy or Sell two properties.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class BuySellType {
	
	/** static char value for BuY */
	public static final char BUY = 'b';
	
	/** static char value for Sell */
	public static final char SELL = 's';
	
	/** instance variable for deal type */
	private char type;
	
	/**
	 * Default Constructor
	 */
	public BuySellType(){
		
	}
	
	/**
	 * Constructor with deal type.
	 * @param type
	 */
	public BuySellType(char type){
		this.type = type;
	}	

	
	/** Getters and Setters */
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

}

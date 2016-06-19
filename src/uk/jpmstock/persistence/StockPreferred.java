package uk.jpmstock.persistence;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class for Preferred Stock. 
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class StockPreferred extends Stock {
	
	/** Fixed dividend. */
	protected BigDecimal fixedDivident;
	
	/**
	 * Default Constructor
	 */
	public StockPreferred() {
		super();		
	}
	
	/**
	 * Constructor with stock symbol name.
	 * @param symbolName
	 */
	public StockPreferred(String symbolName){
		super(symbolName);
	}
	
	/**
	 * Constructor with full parameters.
	 * @param symbolName
	 * @param price
	 * @param weightedPrice
	 * @param tradeRecords
	 * @param parValue
	 * @param dividend
	 */
	public StockPreferred(String symbolName, BigDecimal price, BigDecimal weightedPrice, List<TradeRecord> tradeRecords, BigDecimal parValue, BigDecimal fixedDivident) {		
		super(symbolName, price, weightedPrice, tradeRecords, parValue);
		this.fixedDivident = fixedDivident;
	}	

	/** Getter and Setters for fixedDivident */
	
	public BigDecimal getFixedDivident() {
		return fixedDivident;
	}

	public void setFixedDivident(BigDecimal fixedDivident) {
		this.fixedDivident = fixedDivident;
	}
	
	

}

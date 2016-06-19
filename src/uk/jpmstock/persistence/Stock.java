package uk.jpmstock.persistence;

import java.math.BigDecimal;
import java.util.List;

/**
 * An Abstract Class for stock. The dividend needs subclass to add. 
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public abstract class Stock {
	
	/** Stock symbol name. */
	protected String symbolName;
	
	/** Stock price. */
	protected BigDecimal price;	
	
	/** Stock weighted price which is defined by both deal price and quantity */
	protected BigDecimal weightedPrice;
	
	/** Used in Dividend Yield calculation. */
	protected BigDecimal parValue;
	
	/** Collection of Trade Record for this stock. */
	protected List<TradeRecord> tradeRecords;	
	
	
	/**
	 * Default Constructor
	 */
	public Stock() {
		
	}
	
	/**
	 * Constructor with symbol name.
	 * @param symbolName
	 */
	public Stock(String symbolName){
		this.symbolName = symbolName;
	}

	/**
	 * Constructor with full property values.
	 * @param symbolName
	 * @param price
	 * @param weightedPrice
	 * @param tradeRecords
	 * @param parValue
	 */
	public Stock(String symbolName, BigDecimal price, BigDecimal weightedPrice,	List<TradeRecord> tradeRecords, BigDecimal parValue) {		
		this.symbolName = symbolName;
		this.price = price;		
		this.weightedPrice = weightedPrice;
		this.tradeRecords = tradeRecords;
		this.parValue = parValue;
	}
	
	
	/** Getters and Setters for the class */

	public String getSymbolName() {
		return symbolName;
	}

	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getWeightedPrice() {
		return weightedPrice;
	}

	public void setWeightedPrice(BigDecimal weightedPrice) {
		this.weightedPrice = weightedPrice;
	}

	public List<TradeRecord> getTradeRecords() {
		return tradeRecords;
	}

	public void setTradeRecords(List<TradeRecord> tradeRecords) {
		this.tradeRecords = tradeRecords;
	}

	public BigDecimal getParValue() {
		return parValue;
	}

	public void setParValue(BigDecimal parValue) {
		this.parValue = parValue;
	}
	
	

}

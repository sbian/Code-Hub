package uk.jpmstock.persistence;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class for Common Stock.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class StockCommon extends Stock{
	
	/** Stock dividend */
	protected BigDecimal dividend;
	
	/**
	 * Default Constructor
	 */
	public StockCommon() {
		super();		
	}
	
	/**
	 * Constructor with stock symbol name.
	 * @param symbolName
	 */
	public StockCommon(String symbolName){
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
	public StockCommon(String symbolName, BigDecimal price, BigDecimal weightedPrice, List<TradeRecord> tradeRecords, BigDecimal parValue, BigDecimal dividend) {		
		super(symbolName, price, weightedPrice, tradeRecords, parValue);
		this.dividend = dividend;
	}	

	/** Getter and Setter */
	
	public BigDecimal getDividend() {
		return dividend;
	}

	public void setDividend(BigDecimal dividend) {
		this.dividend = dividend;
	}
	
	

}

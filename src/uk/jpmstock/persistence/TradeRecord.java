package uk.jpmstock.persistence;

import java.math.BigDecimal;

/**
 * Class for Trade Record. 
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class TradeRecord {

	/** Trading stock symbol name */
	private String symbolName;
	
	/** Deal price */	
	private BigDecimal dealPrice;
	
	/** Date and time to deal */
	private long timeStamp;
	
	/** Deal quantity */
	private long quantity;
	
	/** Sell or buy */
	private BuySellType dealType;
	

	/**
	 * Constructor with full properties
	 * @param symbolName
	 * @param dealPrice
	 * @param timeStamp
	 * @param quantity
	 * @param dealType
	 */
	public TradeRecord(String symbolName, BigDecimal dealPrice, long timeStamp, long quantity, BuySellType dealType) {
		this.symbolName = symbolName;
		this.dealPrice = dealPrice;
		this.timeStamp = timeStamp;
		this.quantity = quantity;
		this.dealType = dealType;
	}

	/** Getters and Setters */

	public String getSymbolName() {
		return symbolName;
	}


	public void setSymbolName(String symbolName) {
		this.symbolName = symbolName;
	}


	public BigDecimal getDealPrice() {
		return dealPrice;
	}


	public void setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}


	public long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public BuySellType getDealType() {
		return dealType;
	}


	public void setDealType(BuySellType dealType) {
		this.dealType = dealType;
	}

}

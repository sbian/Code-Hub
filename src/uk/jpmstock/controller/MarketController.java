package uk.jpmstock.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uk.jpmstock.persistence.BuySellType;
import uk.jpmstock.persistence.Stock;
import uk.jpmstock.persistence.TradeRecord;
import uk.jpmstock.util.DivideZeroOrMinusException;
import uk.jpmstock.util.DuplicateStockException;
import uk.jpmstock.util.NoTradeException;
import uk.jpmstock.util.NotExistStockException;

/**
 * Class for providing service to Stock Marketing related calculations and values return.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class MarketController {

	/** Collection of all stocks with keys from their symbol names. */
	private Map<String, Stock> stockCollection;

	
	/**
	 * Default Constructor.
	 */
	public MarketController() {

		stockCollection = new HashMap<String, Stock>();
	}

	/**
	 * To add a stock object to the collection.
	 * @param stock
	 * @throws DuplicateStockException
	 */
	public void addStock(Stock stock) throws DuplicateStockException {

		if (stockCollection.containsKey(stock))
			throw new DuplicateStockException();

		stockCollection.put(stock.getSymbolName(), stock);
	}

	/**
	 * To delete a stock object from the collection.
	 * @param stock
	 * @throws NotExistStockException
	 */
	public void removeStock(Stock stock) throws NotExistStockException {

		if (!stockCollection.containsKey(stock))
			throw new NotExistStockException();

		stockCollection.remove(stock);
	}

	/**
	 * To register a trade to a related stock based on an trade record object. 
	 * @param tradeRecord
	 * @throws NotExistStockException
	 */
	public void registerTradeRecord(TradeRecord tradeRecord) throws NotExistStockException {

		String symbolName = tradeRecord.getSymbolName();
		if (!stockCollection.containsKey(symbolName))
			throw new NotExistStockException();

		Stock stock = stockCollection.get(symbolName);
		stock.getTradeRecords().add(tradeRecord);
	}

	/**
	 * To register a trade to a related stock based on full properties of a trade.
	 * @param symbolName
	 * @param dealPrice
	 * @param timeStamp
	 * @param quantity
	 * @param dealType
	 * @throws NotExistStockException
	 */
	public void registerTradeRecord(String symbolName, BigDecimal dealPrice, long timeStamp, long quantity, char dealType) throws NotExistStockException {
		
		BuySellType buySellType = new BuySellType(dealType);
		TradeRecord tradeRecord = new TradeRecord(symbolName, dealPrice, timeStamp, quantity, buySellType);		
		Stock stock = stockCollection.get(symbolName);
		stock.getTradeRecords().add(tradeRecord);
	}
	
	
	/**
	 * To calculate an index based on whole stocks' volume weighted price.
	 * @return
	 */
	public BigDecimal getAllShareIndex() {
		
		int counter = 0;
		Set<String> keys = stockCollection.keySet();
		BigDecimal productOfWeightedPrice = new BigDecimal("1");
		for(String key : keys){			
			Stock stock = (Stock)stockCollection.get(key);
			productOfWeightedPrice = productOfWeightedPrice.multiply(stock.getWeightedPrice());
			counter++;
		}
		
		if(counter == 0) counter++;
		
		return new BigDecimal(Math.pow(productOfWeightedPrice.doubleValue(), 1.0 / counter)).setScale(0, BigDecimal.ROUND_HALF_EVEN);		
	}
	
	
	/**
	 * To calculate volume weighted price of a stock.
	 * @param symbolName
	 * @param minutes
	 * @return
	 * @throws NotExistStockException
	 * @throws NoTradeException
	 * @throws DivideZeroOrMinusException
	 */
	public BigDecimal getVolumeWeightedPrice(String symbolName, int minutes) throws NotExistStockException, NoTradeException, DivideZeroOrMinusException{
		
		List<TradeRecord> tradeRecords = getTradeRecordByTime (symbolName, minutes);
		Map<String, Stock> collection = this.getStockCollection();
		Stock stock = collection.get(symbolName);

		// if no trade, a stock's volume weighted price is assigned by its normal price
		if(tradeRecords.isEmpty()) {			
			stock = collection.get(symbolName);
			return stock.getPrice();
		}else{
			long totalQuantity = 0;
			BigDecimal totalWeightedPrice = new BigDecimal("0");
			for(TradeRecord tr : tradeRecords){
				totalQuantity += tr.getQuantity();
				totalWeightedPrice.add(new BigDecimal(((BigDecimal)tr.getDealPrice()).doubleValue() * tr.getQuantity()));
			}
			
			if(totalQuantity == 0) throw new DivideZeroOrMinusException();
			
			return (totalWeightedPrice.divide(new BigDecimal(totalQuantity))).setScale(2,  BigDecimal.ROUND_HALF_EVEN);
		}		
	}
	
	
	/**
	 * To collect trades of a stock within a valid time period, such as within 15 minutes.
	 * @param symbolName
	 * @param minutes
	 * @return
	 * @throws NotExistStockException
	 * @throws NoTradeException
	 */
	private List<TradeRecord> getTradeRecordByTime(String symbolName, int minutes) throws NotExistStockException, NoTradeException{
		
		Map<String, Stock> collection = this.getStockCollection();
		Stock stock = collection.get(symbolName);
		if(stock == null) throw new NotExistStockException();
		
		List<TradeRecord> tradeRecords = stock.getTradeRecords();
		if(tradeRecords.isEmpty()) throw new NoTradeException();
		
		List<TradeRecord> qualifiedTradeRecords = new ArrayList<TradeRecord>();
		Date now = new Date();
		long nowTimeStamp = now.getTime();
		long earlyTimeStamp = nowTimeStamp - minutes * 60 * 1000;
		
		for(TradeRecord tr : tradeRecords){
			if(tr.getTimeStamp() >= earlyTimeStamp) qualifiedTradeRecords.add(tr);
		}
		
		return qualifiedTradeRecords;
	}
	
	
	/** Getters and Setters */

	public Map<String, Stock> getStockCollection() {
		return stockCollection;
	}

	public void setStockCollection(Map<String, Stock> stockCollection) {
		this.stockCollection = stockCollection;
	}

}

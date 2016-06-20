package test.uk.jpmstock.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import uk.jpmstock.controller.MarketController;
import uk.jpmstock.persistence.BuySellType;
import uk.jpmstock.persistence.Stock;
import uk.jpmstock.persistence.StockCommon;
import uk.jpmstock.persistence.TradeRecord;
import uk.jpmstock.util.DivideZeroOrMinusException;
import uk.jpmstock.util.DuplicateStockException;
import uk.jpmstock.util.NoTradeException;
import uk.jpmstock.util.NotExistStockException;

/**
 * Test class for testing MarketController
 * 
 * @author Shun Bian
 * @since 20/06/2016
 *
 */

public class MarketControllerTest {

	BuySellType bst = new BuySellType(BuySellType.BUY);	
	TradeRecord tr = new TradeRecord("POP", new BigDecimal("30.65"), (new Date()).getTime(), 445639L, bst);
	ArrayList<TradeRecord> list = new ArrayList<TradeRecord>();	
	Stock c_stock1 = new StockCommon("POP", new BigDecimal("30.65"), new BigDecimal("30.65"), list, new BigDecimal("100"), new BigDecimal("8"));		
	Stock c_stock2 = new StockCommon("ALE", new BigDecimal("20.46"), new BigDecimal("20.45"), list, new BigDecimal("60"), new BigDecimal("23"));		
	MarketController marketController = new MarketController();	
	

	@Test
	public void testAddStock() throws DuplicateStockException {
		marketController.addStock(c_stock1);
		BigDecimal expected_parValue = new BigDecimal("100").setScale(2, BigDecimal.ROUND_HALF_EVEN);
		BigDecimal actual_parValue =  ((Stock)(marketController.getStockCollection().get("POP"))).getParValue().setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		assertEquals(expected_parValue, actual_parValue); 
	}

	@Test
	public void testRemoveStock() throws DuplicateStockException, NotExistStockException {
		
		marketController.clearStockCollection();
		marketController.addStock(c_stock2);
			
		assertFalse(marketController.getStockCollection().isEmpty());	
		
		marketController.removeStock(c_stock2);
		
		assertTrue(marketController.getStockCollection().isEmpty());	
	}

	@Test
	public void testRegisterTradeRecordTradeRecord() throws NotExistStockException, DuplicateStockException {
		marketController.addStock(c_stock1);
		int pre_size = c_stock1.getTradeRecords().size();
		marketController.registerTradeRecord(tr);
		Stock c_s = marketController.getStockCollection().get("POP");
		int post_size = c_s.getTradeRecords().size();
		
		assertTrue((post_size - pre_size) == 1);
	}	

	@Test
	public void testRegisterTradeRecordStringBigDecimalLongLongChar() throws NotExistStockException, DuplicateStockException {
		
		marketController.addStock(c_stock1);
		
		marketController.registerTradeRecord("POP", new BigDecimal("30.65"), (new Date()).getTime(), 445639L, 'b');
		
		Stock c_s = marketController.getStockCollection().get("POP");
		long dealQuntity = ((TradeRecord)c_s.getTradeRecords().get(0)).getQuantity();
		
		assertTrue(dealQuntity == 445639);
	}

	@Test
	public void testGetAllShareIndex() throws DuplicateStockException {
		marketController.addStock(c_stock1);
		marketController.addStock(c_stock2);
		BigDecimal index =  marketController.getAllShareIndex();
			
		assertEquals(index, new BigDecimal("25"));
		
	}

	@Test
	public void testGetVolumeWeightedPrice() throws DuplicateStockException, NotExistStockException, NoTradeException, DivideZeroOrMinusException {
		marketController.addStock(c_stock1);
		BigDecimal expected = marketController.getVolumeWeightedPrice("POP", 5);
		
		assertEquals(new BigDecimal("30.65"), expected.setScale(2, BigDecimal.ROUND_HALF_EVEN));
		
		marketController.registerTradeRecord("POP", new BigDecimal("30.65"), (new Date()).getTime(), 439L, 'b');
		marketController.registerTradeRecord("POP", new BigDecimal("31.65"), (new Date()).getTime(), 435L, 's');
		marketController.registerTradeRecord("POP", new BigDecimal("32.45"), (new Date()).getTime(), 459L, 'b');
		marketController.registerTradeRecord("POP", new BigDecimal("36.80"), (new Date()).getTime(), 435L, 's');
		
		expected = marketController.getVolumeWeightedPrice("POP", 5);		
		
		assertEquals(expected, new BigDecimal("32.88"));
		
	}
	
	@Test
	public void clearStockCollection(){
		
		marketController.clearStockCollection();
		
		assertTrue(marketController.getStockCollection().isEmpty());
	}
	

	@Test
	public void testGetStockCollection() {
		
	}

	@Test
	public void testSetStockCollection() {
		
	}

}

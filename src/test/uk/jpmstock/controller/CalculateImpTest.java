package test.uk.jpmstock.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import uk.jpmstock.controller.CalculateImp;
import uk.jpmstock.persistence.BuySellType;
import uk.jpmstock.persistence.Stock;
import uk.jpmstock.persistence.StockCommon;
import uk.jpmstock.persistence.TradeRecord;
import uk.jpmstock.util.DivideZeroOrMinusException;
import uk.jpmstock.util.NotValidStockException;

/**
 * Class for test CalculateImp class with JUnit.
 * 
 * @author Shun Bian
 * @since 20/06/2016
 */

public class CalculateImpTest {

	BuySellType bst = new BuySellType(BuySellType.BUY);	
	TradeRecord tr = new TradeRecord("POP", new BigDecimal("30.65"), (new Date()).getTime(), 445639L, bst);
	ArrayList<TradeRecord> list = new ArrayList<TradeRecord>();	
	Stock c_stock = new StockCommon("POP", new BigDecimal("30.65"), new BigDecimal("30.65"), list, new BigDecimal("100"), new BigDecimal("8"));		
		
		
	@Test
	public void testGetDividentYield() throws NotValidStockException, DivideZeroOrMinusException {
		list.add(tr);
		BigDecimal dividentYield = CalculateImp.getDividentYield(c_stock, new BigDecimal("35.65")).setScale(2,  BigDecimal.ROUND_HALF_EVEN);
		BigDecimal expected = new BigDecimal(8.0/35.65).setScale(2,  BigDecimal.ROUND_HALF_EVEN);
		
		assertEquals(expected, dividentYield);
	}
	
	@Test
	public void testGetPERatio() throws NotValidStockException, DivideZeroOrMinusException {
		list.add(tr);
		BigDecimal dividentYield = CalculateImp.getPERatio(c_stock, new BigDecimal("35.65")).setScale(2,  BigDecimal.ROUND_HALF_EVEN);
		BigDecimal expected = new BigDecimal(35.65/8).setScale(2,  BigDecimal.ROUND_HALF_EVEN);
		
		assertEquals(expected, dividentYield);
	}

}

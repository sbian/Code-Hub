package uk.jpmstock.controller;

import java.math.BigDecimal;

import uk.jpmstock.persistence.Stock;
import uk.jpmstock.persistence.StockCommon;
import uk.jpmstock.persistence.StockPreferred;
import uk.jpmstock.util.DivideZeroOrMinusException;
import uk.jpmstock.util.NotValidStockException;

/**
 * Class for implementation of calculations about Dividend Yield and PE Ratio.
 * 
 * @author Shun Bian
 * @since 19/06/2016
 *
 */

public class CalculateImp {

	/**
	 * To get dividend yield value. The formula is:  Dividend / Price.
	 * @param stock
	 * @param price
	 * @return
	 * @throws NotValidStockException
	 */
	public static BigDecimal getDividentYield(Stock stock, BigDecimal price) throws NotValidStockException, DivideZeroOrMinusException{	

		// ensure no zero or minus price is used in calculation
		checkDivideValue(price);
		
		BigDecimal result;
		if (stock instanceof StockCommon) {
			double dividentYield = ((StockCommon) stock).getDividend().doubleValue() / price.doubleValue();
			result = (new BigDecimal(dividentYield)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else if (stock instanceof StockPreferred) {
			double dividentYield = ((StockPreferred) stock).getFixedDivident().doubleValue()
					* ((StockPreferred) stock).getParValue().doubleValue() / price.doubleValue();
			result = (new BigDecimal(dividentYield)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else {
			throw new NotValidStockException();
		}

		return result;
	}

	
	/**
	 * To get PE Ration. The formula is: Price / Dividend
	 * @param stock
	 * @param price
	 * @return
	 * @throws NotValidStockException
	 * @throws DivideZeroOrMinusException
	 */
	public static BigDecimal getPERatio(Stock stock, BigDecimal price) throws NotValidStockException, DivideZeroOrMinusException {		
		
		// ensure no zero or minus price is used in calculation
		checkDivideValue(((StockCommon) stock).getDividend());
		
		BigDecimal result;
		if (stock instanceof StockCommon) {
			checkDivideValue(((StockCommon) stock).getDividend());
			double peRatio = price.doubleValue() / ((StockCommon) stock).getDividend().doubleValue();
			result = (new BigDecimal(peRatio)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else if (stock instanceof StockPreferred) {
			checkDivideValue(((StockCommon) stock).getDividend());
			double peRatio = price.doubleValue() / ((StockPreferred) stock).getFixedDivident().doubleValue();
			result = (new BigDecimal(peRatio)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else {
			throw new NotValidStockException();
		}

		return result;
	}

	
	/**
	 * A Generic method for checking divide value is not zero or minus. The possible type include BigDecimal, Long or Integer.
	 * @param t
	 * @throws DivideZeroOrMinusException
	 */
	private static <T> void checkDivideValue(T t) throws DivideZeroOrMinusException {
		if (t instanceof BigDecimal) {
			if (((BigDecimal) t).compareTo(BigDecimal.ZERO) <= 0)
				throw new DivideZeroOrMinusException();
		} else if (t instanceof Double) {
			if ((Double) t <= 0) 
				throw new DivideZeroOrMinusException();		
		} else if (t instanceof Integer){
			if((Integer)t <= 0)
				throw new DivideZeroOrMinusException();
		}
	}	
}

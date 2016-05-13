package com.jpmorgan.stocks.service;

import java.math.BigDecimal;
import java.util.Date;

public class SuperSimpleStockService implements StockService {

	public SuperSimpleStockService() {		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getDividendYield(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException {
		//TODO ImplementMe
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getPERatio(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException {
		//TODO ImplementMe
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void recordTrade(String stockSymbol, Date timestamp, int shareQuantity, String tradeType, BigDecimal price) throws UnknownTradeTypeException, UnknownStockSymbolException {
		//TODO ImplementMe
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getVolumeWeightedStockPrice(final String stockSymbol) throws UnknownStockSymbolException {
		//TODO ImplimentMe
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getAllShareIndex() {
		//TODO ImplimentMe
	}

}

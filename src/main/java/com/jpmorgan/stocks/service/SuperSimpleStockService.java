package com.jpmorgan.stocks.service;

import com.jpmorgan.stocks.entity.StockEntityManager;
import com.jpmorgan.stocks.model.stock.Stock;
import com.jpmorgan.stocks.model.stock.UnknownStockSymbolException;

import java.math.BigDecimal;
import java.util.Date;

public class SuperSimpleStockService implements StockService {

	private final StockEntityManager stockManager;

	public SuperSimpleStockService(final StockEntityManager entityManager) {
		this.stockManager = entityManager;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getDividendYield(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException {
		final Stock stock = this.stockManager.getStock(stockSymbol);
		return stock.getDividendYield(price);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getPERatio(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException {
		final Stock stock = this.stockManager.getStock(stockSymbol);
        return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void recordTrade(String stockSymbol, Date timestamp, int shareQuantity, String tradeType, BigDecimal price) throws UnknownStockSymbolException {
		//TODO ImplementMe
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getVolumeWeightedStockPrice(final String stockSymbol) throws UnknownStockSymbolException {
		//TODO ImplementMe
        return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal getAllShareIndex() {
        return null;
		//TODO ImplementMe
	}

}

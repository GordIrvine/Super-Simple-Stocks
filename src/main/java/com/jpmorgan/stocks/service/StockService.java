package com.jpmorgan.stocks.service;

import com.jpmorgan.stocks.model.stock.UnknownStockSymbolException;

import java.math.BigDecimal;
import java.util.Date;

interface StockService {

	/**
	 * Calculates the dividend yield for any given stock based on the stock price
	 * 
	 * @param stockSymbol The text representation of a stock type thyat the yield is to be calculated for.
	 * @param price The price of the stock that the dividend yield is to be calculated against.
	 * @return The dividend yield.
	 * @throws UnknownStockSymbolException If an unknown stock symbol is passed into the method.
	 */
	BigDecimal getDividendYield(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException;

	/**
	 * Calculates the P/E ratio for any given stock based on the stock price.
	 * 
	 * @param stockSymbol The text representation of a stock type that the P/E ratio is to be calculated for.
	 * @param price The price of the stock that the P/E ratio is to be calculated against.
	 * @return The PE ratio.
	 * @throws UnknownStockSymbolException If an unknown stock symbol is passed into the method.
	 */
	BigDecimal getPERatio(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException;
	
	/**
	 * Records a new Trade for the given stock symbol and the specific trade details provided
	 * 
	 * @param stockSymbol The text representation of a stock type that is being traded.
	 * @param timestamp The timestamp of the trade.
	 * @param shareQuantity Number of shares to be traded.
	 * @param tradeType The type of trade to be performed.
	 * @param price The price the share is to be traded at.
	 * @throws UnknownStockSymbolException If an unknown stock symbol is passed into the method.
	 */
	void recordTrade(final String stockSymbol, final Date timestamp, final int shareQuantity, final String tradeType, final BigDecimal price) throws  UnknownStockSymbolException;
	
	/**
	 * Calculates the volume weighted stock price on any stocks of a specific type that have been performed in the last 15 minutes.
	 * 
	 * @param stockSymbol The text representation of a stock type that the stock price is being calculated.
	 * @return The volume weighted stock price.
	 * @throws UnknownStockSymbolException If an unknown stock symbol is passed into the method.
	 */
	BigDecimal getVolumeWeightedStockPrice(final String stockSymbol) throws UnknownStockSymbolException;
	
	/**
	 * Calculates the GBCE all share index.
	 * 
	 * @return The GBCE all share index.
	 */
	BigDecimal getGBCEAllShareIndex();
}

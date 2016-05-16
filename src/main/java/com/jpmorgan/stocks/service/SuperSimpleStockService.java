package com.jpmorgan.stocks.service;

import com.jpmorgan.stocks.entity.StockEntityManager;
import com.jpmorgan.stocks.model.stock.Stock;
import com.jpmorgan.stocks.model.stock.UnknownStockSymbolException;
import com.jpmorgan.stocks.model.trade.Trade;
import com.jpmorgan.stocks.model.trade.TradeType;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class SuperSimpleStockService implements StockService {

	private final StockEntityManager stockManager;

	SuperSimpleStockService(final StockEntityManager entityManager) {
		this.stockManager = entityManager;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getDividendYield(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException {
		final Stock stock = this.stockManager.getStock(stockSymbol);
		return stock.getDividendYield(price);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getPERatio(final String stockSymbol, final BigDecimal price) throws UnknownStockSymbolException {
		final Stock stock = this.stockManager.getStock(stockSymbol);
        return stock.getPERatio(price);
	}

	/**
	 * {@inheritDoc}
	 */
	public void recordTrade(String stockSymbol, Date timestamp, int shareQuantity, String tradeType, BigDecimal price) throws UnknownStockSymbolException {
		final Stock stock = this.stockManager.getStock(stockSymbol);
		final Trade trade = new Trade(timestamp, shareQuantity, TradeType.valueOf(tradeType), price);
		stock.recordTrade(trade);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getVolumeWeightedStockPrice(final String stockSymbol) throws UnknownStockSymbolException {
		final Stock stock = this.stockManager.getStock(stockSymbol);
		return stock.getVolumeWeightedStockPriceOfPast15Minutes();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public BigDecimal getGBCEAllShareIndex() {
        List<Stock> stocks = this.stockManager.getStocks();
		List<BigDecimal> weightedPrices = new ArrayList<BigDecimal>();
		for(Stock stock : stocks) {
			BigDecimal weightedPrice = stock.getVolumeWeightedStockPriceForAllTrades();
			if(weightedPrice.compareTo(BigDecimal.ZERO) != 0) {
				weightedPrices.add(weightedPrice);
			}
		}
		if(weightedPrices.size() > 0) {
			return getGeometricMean(weightedPrices);
		}
		return BigDecimal.ZERO;
	}

	private BigDecimal getGeometricMean(List<BigDecimal> weightedPrices) {
		final double[] prices = new double[weightedPrices.size()];
		for(int i = 0; i < weightedPrices.size(); i++) {
			prices[i] = weightedPrices.get(i).doubleValue();
		}
		final GeometricMean mean = new GeometricMean();
		return BigDecimal.valueOf(mean.evaluate(prices));
	}

}

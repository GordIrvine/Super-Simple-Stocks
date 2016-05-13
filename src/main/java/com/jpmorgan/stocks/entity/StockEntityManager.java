package com.jpmorgan.stocks.entity;

import com.jpmorgan.stocks.model.stock.Stock;
import com.jpmorgan.stocks.model.stock.UnknownStockSymbolException;

import java.util.List;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public interface StockEntityManager {

    /**
     * Retrieves the Stock matching the stock symbol provided.
     *
     * @param stockSymbol The symbol of the required Stock.
     * @return The matching Stock.
     * @throws UnknownStockSymbolException If no matching Stock is found based on the stock symbol provided.
     */
    Stock getStock(final String stockSymbol) throws UnknownStockSymbolException;

    /**
     * Retrieves all currently recorded Stocks.
     *
     * @return The a list of all Stock objects.
     */
    List<Stock> getStocks();
}

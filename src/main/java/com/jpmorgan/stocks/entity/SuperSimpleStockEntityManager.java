package com.jpmorgan.stocks.entity;

import com.jpmorgan.stocks.model.stock.Stock;
import com.jpmorgan.stocks.model.stock.UnknownStockSymbolException;

import java.util.List;

/**
 * Created by IRVINEG on 13/05/2016.
 */
class SuperSimpleStockEntityManager implements StockEntityManager {

    private final List<Stock> stocks;

    SuperSimpleStockEntityManager(final List<Stock> stocks) {
        this.stocks = stocks;
    }

    public Stock getStock(String stockSymbol) throws UnknownStockSymbolException {
        for (Stock stock : stocks) {
            if(stock.isStockSymbol(stockSymbol)) {
                return stock;
            }
        }
        throw new UnknownStockSymbolException(stockSymbol);
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}

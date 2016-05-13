package com.jpmorgan.stocks.model.stock;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public class UnknownStockSymbolException extends Exception {


    public UnknownStockSymbolException(String stockSymbol) {
        super("Stock for ${stockSymbol} does not exist.");
    }
}

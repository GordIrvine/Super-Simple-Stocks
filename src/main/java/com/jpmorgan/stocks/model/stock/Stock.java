package com.jpmorgan.stocks.model.stock;

import java.math.BigDecimal;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public interface Stock {

    BigDecimal getDividendYield(final BigDecimal price);

    BigDecimal getPERatio(final BigDecimal price);

    boolean isStockSymbol(final String stockSymbol);
}

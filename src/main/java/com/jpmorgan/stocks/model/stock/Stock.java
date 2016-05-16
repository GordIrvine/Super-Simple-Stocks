package com.jpmorgan.stocks.model.stock;

import com.jpmorgan.stocks.model.trade.Trade;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public interface Stock {

    BigDecimal getDividendYield(final BigDecimal price);

    BigDecimal getPERatio(final BigDecimal price);

    boolean isStockSymbol(final String stockSymbol);

    void recordTrade(Trade trade);

    List<Trade> getTrades();

    BigDecimal getVolumeWeightedStockPriceOfPast15Minutes();
}

package com.jpmorgan.stocks.model.stock;

import com.jpmorgan.stocks.model.trade.Trade;
import sun.util.resources.cldr.ar.CalendarData_ar_BH;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public abstract class AbstractStock implements Stock {

    private static final String DIVIDE_BY_ZERO_EXCEPTION_MESSAGE = "Divisor must not be equal to 0";
    private static final String DIVIDE_BY_NULL_EXCEPTION_MESSAGE = "Divisor cannot be null";
    private final String stockSymbol;
    private final BigDecimal lastDividend;
    private final BigDecimal parValue;

    private final List<Trade> trades = new ArrayList<Trade>();

    public AbstractStock(final String stockSymbol, final BigDecimal lastDividend, final BigDecimal parValue) {
        this.stockSymbol = stockSymbol;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }

    BigDecimal getLastDividend() {
        return lastDividend;
    }

    BigDecimal getParValue() {
        return parValue;
    }

    public List<Trade> getTrades() { return this.trades; }


    public final boolean isStockSymbol(final String stockSymbol) {
        return this.stockSymbol.equals(stockSymbol);
    }


    public final BigDecimal getPERatio(final BigDecimal price) {
        validateDivisor(price);
        return price.divide(this.getDividendYield(price));
    }

    public void recordTrade(Trade trade) {
        this.trades.add(trade);
    }

    public BigDecimal getVolumeWeightedStockPriceOfPast15Minutes() {
        List<Trade> recentTrades = getRecentTrades();
        BigDecimal accumulatedSharePrice = BigDecimal.ZERO;
        int totalShareQuantity = 0;
        for (Trade trade : recentTrades) {
            accumulatedSharePrice = accumulatedSharePrice.add(trade.getTotalTradedPrice());
            totalShareQuantity += trade.getShareQuantity();
        }
        if(totalShareQuantity > 0) {
            accumulatedSharePrice = accumulatedSharePrice.divide(BigDecimal.valueOf(totalShareQuantity));
            return accumulatedSharePrice;
        }
        return BigDecimal.ZERO;
    }

    final void validateDivisor(final BigDecimal value) {
        if(value == null) {
            throw new IllegalArgumentException(DIVIDE_BY_NULL_EXCEPTION_MESSAGE);
        }
        if(value.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(DIVIDE_BY_ZERO_EXCEPTION_MESSAGE);
        }
    }

    private List<Trade> getRecentTrades() {
        List<Trade> trades = new ArrayList<Trade>();
        Calendar recentTimestamp = Calendar.getInstance();
        recentTimestamp.add(Calendar.MINUTE, -15);
        for(Trade trade : this.trades) {
            if(trade.getTradeTimestamp().after(recentTimestamp.getTime())) {
                trades.add(trade);
            }
        }
        return trades;
    }
}

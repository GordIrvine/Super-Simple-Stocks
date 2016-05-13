package com.jpmorgan.stocks.model.stock;

import java.math.BigDecimal;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public abstract class AbstractStock implements Stock {

    private static final String DIVIDE_BY_ZERO_EXCEPTION_MESSAGE = "Divisor must not be equal to 0";
    private static final String DIVIDE_BY_NULL_EXCEPTION_MESSAGE = "Divisor cannot be null";
    private final String stockSymbol;
    private final BigDecimal lastDividend;
    private final BigDecimal parValue;

    public AbstractStock(final String stockSymbol, final BigDecimal lastDividend, final BigDecimal parValue) {
        this.stockSymbol = stockSymbol;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }

    protected BigDecimal getLastDividend() {
        return lastDividend;
    }

    protected BigDecimal getParValue() {
        return parValue;
    }

    @Override
    public final boolean isStockSymbol(final String stockSymbol) {
        return this.stockSymbol.equals(stockSymbol);
    }

    protected final void validateDivisor(final BigDecimal value) {
        if(value.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException(DIVIDE_BY_ZERO_EXCEPTION_MESSAGE);
        }
        if(value == null) {
            throw new IllegalArgumentException(DIVIDE_BY_NULL_EXCEPTION_MESSAGE);
        }
    }
}

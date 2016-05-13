package com.jpmorgan.stocks.model.stock;

import java.math.BigDecimal;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public class CommonStock extends AbstractStock {

    public CommonStock(final String stockSymbol, final BigDecimal lastDividend, final BigDecimal parValue) {
        super(stockSymbol, lastDividend, parValue);
    }

    @Override
    public BigDecimal getDividendYield(final BigDecimal price) {
        validateDivisor(price);
        return this.getLastDividend().divide(price);
    }
}

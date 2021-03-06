package com.jpmorgan.stocks.model.stock;

import java.math.BigDecimal;

/**
 * Created by IRVINEG on 13/05/2016.
 */
class CommonStock extends AbstractStock {

    CommonStock(final String stockSymbol, final BigDecimal lastDividend, final BigDecimal parValue) {
        super(stockSymbol, lastDividend, parValue);
    }

    public BigDecimal getDividendYield(final BigDecimal price) {
        validateDivisor(price);
        return this.getLastDividend().divide(price, BigDecimal.ROUND_DOWN);
    }
}

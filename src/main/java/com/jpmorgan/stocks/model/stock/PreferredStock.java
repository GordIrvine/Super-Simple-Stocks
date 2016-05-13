package com.jpmorgan.stocks.model.stock;

import java.math.BigDecimal;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public class PreferredStock extends AbstractStock {

    private final BigDecimal fixedDividend;

    public PreferredStock(final String stockSymbol, final BigDecimal lastDividend, final BigDecimal parValue, final BigDecimal fixedDividend) {
        super(stockSymbol, lastDividend, parValue);
        this.fixedDividend = fixedDividend;
    }


    @Override
    public BigDecimal getDividendYield(BigDecimal price) {
        validateDivisor(price);
        return (this.fixedDividend.multiply(this.getParValue()).divide(price));
    }
}

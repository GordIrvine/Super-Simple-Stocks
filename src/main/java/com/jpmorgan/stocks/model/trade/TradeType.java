package com.jpmorgan.stocks.model.trade;

import java.math.BigDecimal;

/**
 * Created by IRVINEG on 16/05/2016.
 */
public enum TradeType {

    BUY (BigDecimal.ONE),
    SELL(new BigDecimal(-1));

    private final BigDecimal tradeTypeModifier;

    TradeType(BigDecimal tradeTypeModifier) {
        this.tradeTypeModifier = tradeTypeModifier;
    }

    public BigDecimal getTradeTypeModifier() {
        return tradeTypeModifier;
    }
}

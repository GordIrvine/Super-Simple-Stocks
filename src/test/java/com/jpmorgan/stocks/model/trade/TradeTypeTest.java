package com.jpmorgan.stocks.model.trade;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by IRVINEG on 16/05/2016.
 */
public class TradeTypeTest {
    @Test
    public void getTradeTypeModifier_BUY_Returns_Positive_One() {
        assertEquals("Trade type modifier does not match expected value", BigDecimal.ONE, TradeType.BUY.getTradeTypeModifier());
    }

    @Test
    public void getTradeTypeModifier_SELL_Returns_Negative_One() {
        assertEquals("Trade type modifier does not match expected value", BigDecimal.ONE.negate(), TradeType.SELL.getTradeTypeModifier());
    }

}
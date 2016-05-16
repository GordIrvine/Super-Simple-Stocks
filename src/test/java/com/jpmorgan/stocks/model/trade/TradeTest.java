package com.jpmorgan.stocks.model.trade;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by IRVINEG on 16/05/2016.
 */
public class TradeTest {


    @Test
    public void getTradedPrice_TradeType_Buy_Quantity_10_Traded_Price_5_Returns_Positive_5() {
        BigDecimal price = new BigDecimal(5);
        Trade trade = new Trade(Calendar.getInstance().getTime(), 10, TradeType.BUY, price);
        assertEquals("expected traded price does not match actual", price, trade.getTradedPrice());
    }

    @Test
    public void getTradedPrice_TradeType_Sell_Quantity_10_Traded_Price_5_Returns_Negative_5() {
        BigDecimal price = new BigDecimal(5);
        Trade trade = new Trade(Calendar.getInstance().getTime(), 10, TradeType.SELL, price);
        assertEquals("expected traded price does not match actual", price.negate(), trade.getTradedPrice());
    }

    @Test
    public void getShareQuantity_ShareQuantity_10_Returns_10() {
        Trade trade = new Trade(Calendar.getInstance().getTime(), 10, TradeType.BUY, BigDecimal.TEN);
        assertEquals("expected Share Quantity does not match actual", 10, trade.getShareQuantity());
    }

    @Test
    public void getTradeType_TradeType_BUY_Returns_BUY() {
        Trade trade = new Trade(Calendar.getInstance().getTime(), 10, TradeType.BUY, BigDecimal.TEN);
        assertEquals("expected Trade Type does not match actual", TradeType.BUY, trade.getTradeType());
    }

    @Test
    public void getTradeTimestamp_TimeStamp_Equals_Current_Time() {
        Date timestamp = Calendar.getInstance().getTime();
        Trade trade = new Trade(timestamp, 10, TradeType.BUY, BigDecimal.TEN);
        assertEquals("expected Trade Time does not match actual", timestamp, trade.getTradeTimestamp());
    }

}
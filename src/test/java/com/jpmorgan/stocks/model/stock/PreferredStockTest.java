package com.jpmorgan.stocks.model.stock;

import com.jpmorgan.stocks.model.trade.Trade;
import com.jpmorgan.stocks.model.trade.TradeType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by IRVINEG on 15/05/2016.
 */
public class PreferredStockTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void getDividendYield_Par_Value_10_fixed_Dividend_10_Price_10_Returns_Correct_Yield() {
        BigDecimal expectedYield = BigDecimal.TEN;
        Stock stock = new PreferredStock("TEA", BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
        assertEquals("Calculated Dividend yield does not match expected", expectedYield, stock.getDividendYield(BigDecimal.TEN));
    }

    @Test
    public void getDividendYield_Price_Zero_Throws_Illegal_Argument() {
        Stock stock = new PreferredStock("TEA", BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
        exception.expect(IllegalArgumentException.class);
        stock.getDividendYield(BigDecimal.ZERO);

    }

    @Test
    public void getDividendYield_Price_Null_Throws_Illegal_Argument() {
        Stock stock = new PreferredStock("TEA", BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
        exception.expect(IllegalArgumentException.class);
        stock.getDividendYield(null);
    }

    @Test
    public void getPERatio_Dividend_Yield_20_Price_5_Returns_Correct_Yield() {
        BigDecimal expectedRatio = new BigDecimal(0.25);
        BigDecimal price = new BigDecimal(5);
        Stock stock = new PreferredStock("TEA", BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
        assertEquals("Calculated PE Ratio does not match expected", expectedRatio, stock.getPERatio(price));
    }

    @Test
    public void getPERatio_Price_Zero_Throws_Illegal_Argument() {
        Stock stock = new PreferredStock("TEA", BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN);
        exception.expect(IllegalArgumentException.class);
        stock.getPERatio(BigDecimal.ZERO);

    }

    @Test
    public void getPERatio_Price_Null_Throws_Illegal_Argument() {
        Stock stock = new PreferredStock("TEA", BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN);
        exception.expect(IllegalArgumentException.class);
        stock.getPERatio(null);
    }

    @Test
    public void recordTrade_BUY_10_TEA_Stocks_Trade_Added_To_Trade_List() {
        Date timestamp = Calendar.getInstance().getTime();
        Stock stock = new PreferredStock("TEA", BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN);
        Trade trade = new Trade(timestamp, 10, TradeType.BUY, BigDecimal.TEN);
        stock.recordTrade(trade);
        assertEquals("Stored trade does not match expected Trade", trade, stock.getTrades().get(0));
    }

    @Test
    public void getVolumeWeightedStockPriceOfPast15Minutes_Two_Trades_2_Quantity_Gives_Correct_Price() {
        BigDecimal expectedPrice = new BigDecimal(7.5);
        Stock stock = new PreferredStock("TEA", BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.TEN);
        Trade trade1 = new Trade(Calendar.getInstance().getTime(), 2, TradeType.BUY, BigDecimal.TEN);
        Trade trade2 = new Trade(Calendar.getInstance().getTime(), 2, TradeType.BUY, new BigDecimal(5));
        stock.recordTrade(trade1);
        stock.recordTrade(trade2);
        assertEquals("Expected Weighted Stock Price does not match actual", expectedPrice, stock.getVolumeWeightedStockPriceOfPast15Minutes());
    }
}
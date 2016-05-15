package com.jpmorgan.stocks.model.stock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by IRVINEG on 15/05/2016.
 */
public class CommonStockTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void getDividendYield_Last_Dividend_10_Price_10_Returns_Correct_Yield() {
        BigDecimal expectedYield = BigDecimal.ONE;
        Stock stock = new CommonStock("TEA", BigDecimal.TEN, BigDecimal.ZERO);
        assertEquals("Calculated Dividend yield does not match expected", expectedYield, stock.getDividendYield(BigDecimal.TEN));
    }

    @Test
    public void getDividendYield_Price_Zero_Throws_Illegal_Argument() {
        Stock stock = new CommonStock("TEA", BigDecimal.TEN, BigDecimal.ZERO);
        exception.expect(IllegalArgumentException.class);
        stock.getDividendYield(BigDecimal.ZERO);

    }

    @Test
    public void getDividendYield_Price_Null_Throws_Illegal_Argument() {
        Stock stock = new CommonStock("TEA", BigDecimal.TEN, BigDecimal.ZERO);
        exception.expect(IllegalArgumentException.class);
        stock.getDividendYield(null);
    }

}
package com.jpmorgan.stocks.model.stock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

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

}
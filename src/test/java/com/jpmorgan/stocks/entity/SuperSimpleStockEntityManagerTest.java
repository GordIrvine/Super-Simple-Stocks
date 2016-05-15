package com.jpmorgan.stocks.entity;

import com.jpmorgan.stocks.model.stock.Stock;
import com.jpmorgan.stocks.model.stock.UnknownStockSymbolException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by IRVINEG on 13/05/2016.
 */
public class SuperSimpleStockEntityManagerTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getStock_TEAStockExists_ReturnsTEAStock() {
        final Stock stock = mock(Stock.class);
        when(stock.isStockSymbol("TEA")).thenReturn(true);
        final List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(stock);
        final StockEntityManager entityManager = new SuperSimpleStockEntityManager(stocks);
        try {
            final Stock retrievedStock = entityManager.getStock("TEA");
            assertEquals("", stock, retrievedStock);
        } catch (UnknownStockSymbolException e) {
            fail("Stock 'TEA' not found.");
        }
    }

    @Test
    public void getStock_TEAStockDoesNotExist_ThrowsStockSymbolNotRecognisedException() throws UnknownStockSymbolException {
        final Stock stock = mock(Stock.class);
        when(stock.isStockSymbol("TEA")).thenReturn(false);
        final List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(stock);
        final StockEntityManager entityManager = new SuperSimpleStockEntityManager(stocks);
        exception.expect(UnknownStockSymbolException.class);
        entityManager.getStock("TEA");
    }

}
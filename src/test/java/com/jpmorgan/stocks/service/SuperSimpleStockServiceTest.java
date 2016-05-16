package com.jpmorgan.stocks.service;

import com.jpmorgan.stocks.entity.StockEntityManager;
import com.jpmorgan.stocks.model.stock.Stock;
import com.jpmorgan.stocks.model.stock.UnknownStockSymbolException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by IRVINEG on 16/05/2016.
 */
public class SuperSimpleStockServiceTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getDividendYield_StockRecognised_ReturnsStockDividendYield() throws UnknownStockSymbolException {
        Stock stock = mock(Stock.class);
        StockEntityManager entityManager = mock(StockEntityManager.class);
        when(entityManager.getStock("TEA")).thenReturn(stock);
        when(stock.getDividendYield(BigDecimal.ONE)).thenReturn(BigDecimal.TEN);
        StockService service = new SuperSimpleStockService(entityManager);
        BigDecimal dividendYield = service.getDividendYield("TEA", BigDecimal.ONE);
        assertEquals("Unexpected dividend yield.", BigDecimal.TEN, dividendYield);
    }

    @Test
    public void getPERatio_StockRecognised_ReturnsStockPERatio() throws UnknownStockSymbolException {
        Stock stock = mock(Stock.class);
        StockEntityManager entityManager = mock(StockEntityManager.class);
        when(entityManager.getStock("TEA")).thenReturn(stock);
        when(stock.getPERatio(BigDecimal.ONE)).thenReturn(BigDecimal.TEN);
        StockService service = new SuperSimpleStockService(entityManager);
        BigDecimal peRatio = service.getPERatio("TEA", BigDecimal.ONE);
        assertEquals("Unexpected dividend yield.", BigDecimal.TEN, peRatio);
    }

    @Test
    public void getVolumeWeightedStockPrice_StockRecognised_ReturnsStockVolumeWeightedStockPrice() throws UnknownStockSymbolException {
        Stock stock = mock(Stock.class);
        when(stock.getVolumeWeightedStockPriceOfPast15Minutes()).thenReturn(BigDecimal.ZERO);
        StockEntityManager entityManager = mock(StockEntityManager.class);
        when(entityManager.getStock("TEA")).thenReturn(stock);
        StockService service = new SuperSimpleStockService(entityManager);
        BigDecimal price = service.getVolumeWeightedStockPrice("TEA");
        assertTrue("Price incorrect. expected 0, got " + price, price.compareTo(BigDecimal.ZERO) == 0);
    }

    @Test
    public void getAllShareIndex_NoStocks_ReturnsZero() {
        StockEntityManager entityManager = mock(StockEntityManager.class);
        when(entityManager.getStocks()).thenReturn(new ArrayList<Stock>());
        StockService service = new SuperSimpleStockService(entityManager);
        BigDecimal index = service.getGBCEAllShareIndex();
        assertTrue("All share index incorrect. expected 0, got " + index, index.compareTo(BigDecimal.ZERO) == 0);
    }


    @Test
    public void getAllShareIndex_TwoStocksWithPrice4_ReturnsFour() {
        StockEntityManager entityManager = mock(StockEntityManager.class);
        Stock stock1 = mock(Stock.class);
        when(stock1.getVolumeWeightedStockPriceForAllTrades()).thenReturn(BigDecimal.valueOf(4));
        Stock stock2 = mock(Stock.class);
        when(stock2.getVolumeWeightedStockPriceForAllTrades()).thenReturn(BigDecimal.valueOf(4));
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        stocks.add(stock1);
        stocks.add(stock2);
        when(entityManager.getStocks()).thenReturn(stocks);
        StockService service = new SuperSimpleStockService(entityManager);
        BigDecimal index = service.getGBCEAllShareIndex();
        assertTrue("All share index incorrect. expected 4, got " + index, index.compareTo(BigDecimal.valueOf(4)) == 0);
    }


    @Test
    public void getAllShareIndex_TwoStocksWithPrices2And8_ReturnsFour() {
        StockEntityManager entityManager = mock(StockEntityManager.class);
        Stock stock1 = mock(Stock.class);
        when(stock1.getVolumeWeightedStockPriceForAllTrades()).thenReturn(BigDecimal.valueOf(2));
        Stock stock2 = mock(Stock.class);
        when(stock2.getVolumeWeightedStockPriceForAllTrades()).thenReturn(BigDecimal.valueOf(8));
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        stocks.add(stock1);
        stocks.add(stock2);
        when(entityManager.getStocks()).thenReturn(stocks);
        StockService service = new SuperSimpleStockService(entityManager);
        BigDecimal index = service.getGBCEAllShareIndex();
        assertTrue("All share index incorrect. expected 4, got " + index, index.compareTo(BigDecimal.valueOf(4)) == 0);
    }

    @Test
    public void getAllShareIndex_OneStockWithPrice4_ReturnsFour() {
        StockEntityManager entityManager = mock(StockEntityManager.class);
        Stock stock1 = mock(Stock.class);
        when(stock1.getVolumeWeightedStockPriceForAllTrades()).thenReturn(BigDecimal.valueOf(4));
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        stocks.add(stock1);
        when(entityManager.getStocks()).thenReturn(stocks);
        StockService service = new SuperSimpleStockService(entityManager);
        BigDecimal index = service.getGBCEAllShareIndex();
        assertTrue("All share index incorrect. expected 4, got " + index, index.compareTo(BigDecimal.valueOf(4)) == 0);
    }


}
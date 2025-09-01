package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;

public class CandleTest {

    @Test
    public void testCriacaoCandle() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        
        Assert.assertEquals(10.0, candle.getAbertura(), 0.001);
        Assert.assertEquals(15.0, candle.getFechamento(), 0.001);
        Assert.assertEquals(8.0, candle.getMinimo(), 0.001);
        Assert.assertEquals(20.0, candle.getMaximo(), 0.001);
        Assert.assertEquals(1000.0, candle.getVolume(), 0.001);
    }

    @Test
    public void testCandleAlta() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        
        Assert.assertTrue(candle.isAlta());
        Assert.assertFalse(candle.isBaixa());
    }

    @Test
    public void testCandleBaixa() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(15.0, 10.0, 8.0, 20.0, 1000.0, data);
        
        Assert.assertTrue(candle.isBaixa());
        Assert.assertFalse(candle.isAlta());
    }
}
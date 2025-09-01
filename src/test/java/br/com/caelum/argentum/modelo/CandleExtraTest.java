package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;

public class CandleExtraTest {

    @Test
    public void testCandleNeutro() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(10.0, 10.0, 8.0, 12.0, 1000.0, data);
        
        Assert.assertFalse(candle.isAlta());
        Assert.assertFalse(candle.isBaixa());
    }

    @Test
    public void testCandleComValoresExtremos() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(0.0, 100.0, 0.0, 100.0, 0.0, data);
        
        Assert.assertEquals(0.0, candle.getAbertura(), 0.001);
        Assert.assertEquals(100.0, candle.getFechamento(), 0.001);
        Assert.assertEquals(0.0, candle.getMinimo(), 0.001);
        Assert.assertEquals(100.0, candle.getMaximo(), 0.001);
        Assert.assertEquals(0.0, candle.getVolume(), 0.001);
        Assert.assertTrue(candle.isAlta());
    }

    @Test
    public void testGetData() {
        Calendar data = Calendar.getInstance();
        data.set(2023, Calendar.JANUARY, 15);
        
        Candle candle = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        
        Calendar dataRetornada = candle.getData();
        Assert.assertEquals(data.getTimeInMillis(), dataRetornada.getTimeInMillis());
    }
}
package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import org.junit.Assert;

public class CandlestickFactoryTest {

    @Test
    public void testConstroiCandleParaData() {
        Calendar data = Calendar.getInstance();
        Negociacao n1 = new Negociacao(10.0, 100, data);
        Negociacao n2 = new Negociacao(15.0, 200, data);
        Negociacao n3 = new Negociacao(5.0, 50, data);
        
        List<Negociacao> negocios = Arrays.asList(n1, n2, n3);
        
        CandlestickFactory factory = new CandlestickFactory();
        Candle candle = factory.constroiCandleParaData(data, negocios);
        
        Assert.assertEquals(10.0, candle.getAbertura(), 0.001);
        Assert.assertEquals(5.0, candle.getFechamento(), 0.001);
        Assert.assertEquals(5.0, candle.getMinimo(), 0.001);
        Assert.assertEquals(15.0, candle.getMaximo(), 0.001);
        Assert.assertEquals(4250.0, candle.getVolume(), 0.001);
    }

    @Test
    public void testConstroiCandleListaVazia() {
        Calendar data = Calendar.getInstance();
        CandlestickFactory factory = new CandlestickFactory();
        Candle candle = factory.constroiCandleParaData(data, Arrays.asList());
        
        Assert.assertEquals(0.0, candle.getAbertura(), 0.001);
        Assert.assertEquals(0.0, candle.getFechamento(), 0.001);
    }

    @Test
    public void testConstroiCandles() {
        Calendar data1 = Calendar.getInstance();
        Calendar data2 = Calendar.getInstance();
        data2.add(Calendar.DAY_OF_MONTH, 1);
        
        Negociacao n1 = new Negociacao(10.0, 100, data1);
        Negociacao n2 = new Negociacao(15.0, 200, data2);
        
        List<Negociacao> negocios = Arrays.asList(n1, n2);
        
        CandlestickFactory factory = new CandlestickFactory();
        List<Candle> candles = factory.constroiCandles(negocios);
        
        Assert.assertEquals(2, candles.size());
    }
}
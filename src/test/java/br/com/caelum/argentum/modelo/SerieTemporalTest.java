package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;

public class SerieTemporalTest {

    @Test
    public void testSerieTemporal() {
        Calendar data = Calendar.getInstance();
        Candle candle1 = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        Candle candle2 = new Candle(15.0, 12.0, 10.0, 18.0, 800.0, data);
        
        SerieTemporal serie = new SerieTemporal(Arrays.asList(candle1, candle2));
        
        Assert.assertEquals(candle1, serie.getCandle(0));
        Assert.assertEquals(candle2, serie.getCandle(1));
        Assert.assertEquals(1, serie.getUltimaPosicao());
    }
}
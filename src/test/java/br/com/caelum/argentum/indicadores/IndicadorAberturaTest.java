package br.com.caelum.argentum.indicadores;

import java.util.Arrays;
import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorAberturaTest {

    @Test
    public void testCalculaAbertura() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        SerieTemporal serie = new SerieTemporal(Arrays.asList(candle));
        
        IndicadorAbertura indicador = new IndicadorAbertura();
        double resultado = indicador.calcula(0, serie);
        
        Assert.assertEquals(10.0, resultado, 0.001);
    }

    @Test
    public void testToString() {
        IndicadorAbertura indicador = new IndicadorAbertura();
        Assert.assertEquals("Abertura", indicador.toString());
    }
}
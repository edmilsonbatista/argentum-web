package br.com.caelum.argentum.indicadores;

import java.util.Arrays;
import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorFechamentoTest {

    @Test
    public void testCalculaFechamento() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        SerieTemporal serie = new SerieTemporal(Arrays.asList(candle));
        
        IndicadorFechamento indicador = new IndicadorFechamento();
        double resultado = indicador.calcula(0, serie);
        
        Assert.assertEquals(15.0, resultado, 0.001);
    }

    @Test
    public void testToString() {
        IndicadorFechamento indicador = new IndicadorFechamento();
        Assert.assertEquals("Fechamento", indicador.toString());
    }
}
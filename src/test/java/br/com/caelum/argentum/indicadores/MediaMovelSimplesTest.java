package br.com.caelum.argentum.indicadores;

import java.util.Arrays;
import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimplesTest {

    @Test
    public void testCalculaMediaMovel() {
        Calendar data = Calendar.getInstance();
        Candle c1 = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        Candle c2 = new Candle(12.0, 18.0, 10.0, 22.0, 1200.0, data);
        Candle c3 = new Candle(15.0, 20.0, 12.0, 25.0, 1500.0, data);
        
        SerieTemporal serie = new SerieTemporal(Arrays.asList(c1, c2, c3));
        
        IndicadorAbertura indicadorAbertura = new IndicadorAbertura();
        MediaMovelSimples mms = new MediaMovelSimples(indicadorAbertura);
        
        double resultado = mms.calcula(2, serie);
        double esperado = (15.0 + 12.0 + 10.0) / 3;
        
        Assert.assertEquals(esperado, resultado, 0.001);
    }

    @Test
    public void testToString() {
        IndicadorAbertura indicadorAbertura = new IndicadorAbertura();
        MediaMovelSimples mms = new MediaMovelSimples(indicadorAbertura);
        
        Assert.assertEquals("MMS Abertura", mms.toString());
    }
}
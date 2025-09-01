package br.com.caelum.argentum.grafico;

import java.util.Arrays;
import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.argentum.indicadores.IndicadorAbertura;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorModeloGraficoTest {

    @Test
    public void testCriacaoGeradorModeloGrafico() {
        Calendar data = Calendar.getInstance();
        Candle candle = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        SerieTemporal serie = new SerieTemporal(Arrays.asList(candle));
        
        GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 0, 0);
        
        Assert.assertNotNull(gerador.getModeloGrafico());
    }

    @Test
    public void testPlotaMediaMovelSimples() {
        Calendar data = Calendar.getInstance();
        Candle c1 = new Candle(10.0, 15.0, 8.0, 20.0, 1000.0, data);
        Candle c2 = new Candle(12.0, 18.0, 10.0, 22.0, 1200.0, data);
        
        SerieTemporal serie = new SerieTemporal(Arrays.asList(c1, c2));
        GeradorModeloGrafico gerador = new GeradorModeloGrafico(serie, 0, 1);
        
        IndicadorAbertura indicador = new IndicadorAbertura();
        gerador.plotaMediaMovelSimples(indicador);
        
        Assert.assertNotNull(gerador.getModeloGrafico());
    }
}
package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.modelo.Candle;
import java.util.Calendar;

public class MediaMovelExponencialSimpleTest {
    
    private MediaMovelExponencial ema;
    private SerieTemporal serie;
    
    @Before
    public void setUp() {
        ema = new MediaMovelExponencial(0.2);
        serie = new SerieTemporal();
        
        Calendar data = Calendar.getInstance();
        data.set(2023, Calendar.JANUARY, 10);
        
        serie.adiciona(new Candle(40.0, 42.0, 39.0, 41.0, 1000.0, data));
        
        data.add(Calendar.DAY_OF_MONTH, 1);
        serie.adiciona(new Candle(41.0, 43.0, 40.0, 42.0, 1100.0, data));
    }
    
    @Test
    public void deveCalcularEMAParaPrimeiraPosicao() {
        double resultado = ema.calcula(0, serie);
        assertEquals(41.0, resultado, 0.0001);
    }
    
    @Test
    public void deveCalcularEMAParaSegundaPosicao() {
        double resultado = ema.calcula(1, serie);
        // EMA = (42.0 * 0.2) + (41.0 * 0.8) = 8.4 + 32.8 = 41.2
        assertEquals(41.2, resultado, 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarFatorSuavizacaoInvalido() {
        new MediaMovelExponencial(0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCalcularParaPosicaoInvalida() {
        ema.calcula(10, serie);
    }
    
    @Test
    public void deveRetornarFatorSuavizacaoCorreto() {
        assertEquals(0.2, ema.getFatorSuavizacao(), 0.0001);
    }
}
package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.modelo.Candle;
import java.util.Calendar;

public class MediaMovelExponencialTest {
    
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
        
        data.add(Calendar.DAY_OF_MONTH, 1);
        serie.adiciona(new Candle(42.0, 44.0, 41.0, 43.0, 1200.0, data));
    }
    
    @Test
    public void deveCalcularEMAParaPrimeiraPosicao() {
        double resultado = ema.calcula(0, serie);
        assertEquals(42.0, resultado, 0.0001);
    }
    
    @Test
    public void deveCalcularEMAParaSegundaPosicao() {
        double resultado = ema.calcula(1, serie);
        assertEquals(42.2, resultado, 0.0001);
    }
    
    @Test
    public void deveCalcularEMAParaTerceiraPosicao() {
        double resultado = ema.calcula(2, serie);
        assertEquals(42.56, resultado, 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarFatorSuavizacaoZero() {
        new MediaMovelExponencial(0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarFatorSuavizacaoNegativo() {
        new MediaMovelExponencial(-0.1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarFatorSuavizacaoMaiorQueUm() {
        new MediaMovelExponencial(1.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCalcularParaPosicaoNegativa() {
        ema.calcula(-1, serie);
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
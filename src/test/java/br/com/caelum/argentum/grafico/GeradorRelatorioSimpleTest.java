package br.com.caelum.argentum.grafico;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.modelo.Candle;
import java.util.Calendar;

public class GeradorRelatorioSimpleTest {
    
    private GeradorRelatorio gerador;
    private SerieTemporal serie;
    
    @Before
    public void setUp() {
        serie = new SerieTemporal();
        
        Calendar data = Calendar.getInstance();
        data.set(2023, Calendar.JANUARY, 10);
        
        // Candle simples: abertura, máximo, mínimo, fechamento, volume, data
        serie.adiciona(new Candle(40.0, 45.0, 38.0, 42.0, 1000.0, data));
        
        gerador = new GeradorRelatorio(serie);
    }
    
    @Test
    public void deveGerarResumoParaUmCandle() {
        String resumo = gerador.gerarResumo();
        
        assertTrue(resumo.contains("Total de candles: 1"));
        assertTrue(resumo.contains("Maior alta:"));
        assertTrue(resumo.contains("Menor baixa:"));
    }
    
    @Test
    public void deveEncontrarMaiorAltaParaUmCandle() {
        double maiorAlta = gerador.encontrarMaiorAlta();
        assertEquals(45.0, maiorAlta, 0.0001);
    }
    
    @Test
    public void deveEncontrarMenorBaixaParaUmCandle() {
        double menorBaixa = gerador.encontrarMenorBaixa();
        assertEquals(38.0, menorBaixa, 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarSerieNula() {
        new GeradorRelatorio(null);
    }
}
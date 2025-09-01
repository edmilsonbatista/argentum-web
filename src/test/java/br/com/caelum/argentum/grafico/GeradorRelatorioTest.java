package br.com.caelum.argentum.grafico;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.modelo.Candle;
import java.util.Calendar;
import java.util.List;

public class GeradorRelatorioTest {
    
    private GeradorRelatorio gerador;
    private SerieTemporal serie;
    
    @Before
    public void setUp() {
        serie = new SerieTemporal();
        
        Calendar data = Calendar.getInstance();
        data.set(2023, Calendar.JANUARY, 10);
        
        serie.adiciona(new Candle(40.0, 45.0, 38.0, 42.0, 1000.0, data));
        
        data.add(Calendar.DAY_OF_MONTH, 1);
        serie.adiciona(new Candle(42.0, 47.0, 40.0, 44.0, 1100.0, data));
        
        data.add(Calendar.DAY_OF_MONTH, 1);
        serie.adiciona(new Candle(44.0, 46.0, 41.0, 43.0, 1200.0, data));
        
        gerador = new GeradorRelatorio(serie);
    }
    
    @Test
    public void deveGerarResumoCorreto() {
        String resumo = gerador.gerarResumo();
        
        assertTrue(resumo.contains("Total de candles: 3"));
        // Verificar se contém os valores corretos sem especificar exatamente
        assertTrue(resumo.contains("Maior alta:"));
        assertTrue(resumo.contains("Menor baixa:"));
    }
    
    @Test
    public void deveEncontrarMaiorAltaCorretamente() {
        double maiorAlta = gerador.encontrarMaiorAlta();
        // O maior máximo entre 45.0, 47.0, 46.0 é 47.0
        assertEquals(47.0, maiorAlta, 0.0001);
    }
    
    @Test
    public void deveEncontrarMenorBaixaCorretamente() {
        double menorBaixa = gerador.encontrarMenorBaixa();
        // O menor mínimo entre 38.0, 40.0, 41.0 é 38.0
        assertEquals(38.0, menorBaixa, 0.0001);
    }
    
    @Test
    public void deveRetornarCandlesAcimaDaMedia() {
        List<Candle> candlesAcima = gerador.getCandlesAcimaDaMedia();
        
        // Média de fechamento: (42 + 44 + 43) / 3 = 43
        // Apenas o candle com fechamento 44 está acima da média
        assertEquals(1, candlesAcima.size());
        assertEquals(44.0, candlesAcima.get(0).getFechamento(), 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarSerieNula() {
        new GeradorRelatorio(null);
    }
    
    @Test
    public void deveTrabalharComSerieVazia() {
        SerieTemporal serieVazia = new SerieTemporal();
        GeradorRelatorio geradorVazio = new GeradorRelatorio(serieVazia);
        
        String resumo = geradorVazio.gerarResumo();
        assertEquals("Série vazia", resumo);
        
        assertEquals(0.0, geradorVazio.encontrarMaiorAlta(), 0.0001);
        assertEquals(0.0, geradorVazio.encontrarMenorBaixa(), 0.0001);
        assertTrue(geradorVazio.getCandlesAcimaDaMedia().isEmpty());
    }
    
    @Test
    public void deveTrabalharComUmCandle() {
        SerieTemporal serieUnica = new SerieTemporal();
        Calendar data = Calendar.getInstance();
        serieUnica.adiciona(new Candle(40.0, 45.0, 38.0, 42.0, 1000.0, data));
        
        GeradorRelatorio geradorUnico = new GeradorRelatorio(serieUnica);
        
        assertEquals(45.0, geradorUnico.encontrarMaiorAlta(), 0.0001);
        assertEquals(38.0, geradorUnico.encontrarMenorBaixa(), 0.0001);
        
        // Com apenas um candle, ele não pode estar acima da própria média
        assertTrue(geradorUnico.getCandlesAcimaDaMedia().isEmpty());
    }
}
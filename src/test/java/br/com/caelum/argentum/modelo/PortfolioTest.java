package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Calendar;

public class PortfolioTest {
    
    private Portfolio portfolio;
    private Negociacao negociacao1;
    private Negociacao negociacao2;
    
    @Before
    public void setUp() {
        portfolio = new Portfolio(new BigDecimal("1000.00"));
        
        Calendar data1 = Calendar.getInstance();
        data1.set(2023, Calendar.JANUARY, 10);
        negociacao1 = new Negociacao(40.5, 100, data1);
        
        Calendar data2 = Calendar.getInstance();
        data2.set(2023, Calendar.JANUARY, 11);
        negociacao2 = new Negociacao(41.0, 150, data2);
    }
    
    @Test
    public void deveCalcularValorTotalComSaldoInicial() {
        BigDecimal valorEsperado = new BigDecimal("1000.00");
        assertEquals(valorEsperado, portfolio.calcularValorTotal());
    }
    
    @Test
    public void deveAdicionarNegociacaoCorretamente() {
        portfolio.adicionarNegociacao(negociacao1);
        assertEquals(1, portfolio.getTotalNegociacoes());
        assertTrue(portfolio.getNegociacoes().contains(negociacao1));
    }
    
    @Test
    public void deveCalcularValorTotalComNegociacoes() {
        portfolio.adicionarNegociacao(negociacao1);
        portfolio.adicionarNegociacao(negociacao2);
        
        BigDecimal valorEsperado = new BigDecimal("1000.00")
            .add(negociacao1.getVolume())
            .add(negociacao2.getVolume());
        
        assertEquals(valorEsperado, portfolio.calcularValorTotal());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAdicionarNegociacaoNula() {
        portfolio.adicionarNegociacao(null);
    }
    
    @Test
    public void deveRetornarCopiaListaNegociacoes() {
        portfolio.adicionarNegociacao(negociacao1);
        
        assertEquals(1, portfolio.getNegociacoes().size());
        
        // Modificar a lista retornada não deve afetar o portfolio
        portfolio.getNegociacoes().clear();
        assertEquals(1, portfolio.getTotalNegociacoes());
    }
    
    @Test
    public void deveRetornarSaldoInicialCorreto() {
        BigDecimal saldoEsperado = new BigDecimal("1000.00");
        assertEquals(saldoEsperado, portfolio.getSaldoInicial());
    }
}
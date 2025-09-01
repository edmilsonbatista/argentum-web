package br.com.caelum.argentum.utils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.argentum.modelo.Negociacao;

public class CalculadoraEstatisticaTest {

    @Test
    public void testCalculaMedia() {
        Calendar data = Calendar.getInstance();
        Negociacao n1 = new Negociacao(10.0, 100, data);
        Negociacao n2 = new Negociacao(20.0, 200, data);
        Negociacao n3 = new Negociacao(30.0, 300, data);
        
        CalculadoraEstatistica calc = new CalculadoraEstatistica();
        double media = calc.calculaMedia(Arrays.asList(n1, n2, n3));
        
        Assert.assertEquals(20.0, media, 0.001);
    }

    @Test
    public void testCalculaMediaListaVazia() {
        CalculadoraEstatistica calc = new CalculadoraEstatistica();
        double media = calc.calculaMedia(Collections.emptyList());
        
        Assert.assertEquals(0.0, media, 0.001);
    }

    @Test
    public void testCalculaMaximo() {
        Calendar data = Calendar.getInstance();
        Negociacao n1 = new Negociacao(10.0, 100, data);
        Negociacao n2 = new Negociacao(30.0, 200, data);
        Negociacao n3 = new Negociacao(20.0, 300, data);
        
        CalculadoraEstatistica calc = new CalculadoraEstatistica();
        double maximo = calc.calculaMaximo(Arrays.asList(n1, n2, n3));
        
        Assert.assertEquals(30.0, maximo, 0.001);
    }

    @Test
    public void testCalculaMinimo() {
        Calendar data = Calendar.getInstance();
        Negociacao n1 = new Negociacao(10.0, 100, data);
        Negociacao n2 = new Negociacao(30.0, 200, data);
        Negociacao n3 = new Negociacao(5.0, 300, data);
        
        CalculadoraEstatistica calc = new CalculadoraEstatistica();
        double minimo = calc.calculaMinimo(Arrays.asList(n1, n2, n3));
        
        Assert.assertEquals(5.0, minimo, 0.001);
    }

    @Test
    public void testCalculaMaximoListaVazia() {
        CalculadoraEstatistica calc = new CalculadoraEstatistica();
        double maximo = calc.calculaMaximo(null);
        
        Assert.assertEquals(0.0, maximo, 0.001);
    }
}
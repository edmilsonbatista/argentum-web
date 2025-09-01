package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;

public class NegociacaoExtraTest {

    @Test
    public void testNegociacaoComValoresZero() {
        Calendar data = Calendar.getInstance();
        Negociacao negociacao = new Negociacao(0.0, 0, data);
        
        Assert.assertEquals(0.0, negociacao.getPreco(), 0.001);
        Assert.assertEquals(0, negociacao.getQuantidade());
        Assert.assertEquals(0.0, negociacao.getVolume(), 0.001);
    }

    @Test
    public void testNegociacaoComValoresNegativos() {
        Calendar data = Calendar.getInstance();
        Negociacao negociacao = new Negociacao(-10.0, -100, data);
        
        Assert.assertEquals(-10.0, negociacao.getPreco(), 0.001);
        Assert.assertEquals(-100, negociacao.getQuantidade());
        Assert.assertEquals(1000.0, negociacao.getVolume(), 0.001);
    }

    @Test
    public void testMesmoDiaComDatasDiferentes() {
        Calendar data1 = Calendar.getInstance();
        data1.set(2023, Calendar.JANUARY, 15, 10, 30, 0);
        
        Calendar data2 = Calendar.getInstance();
        data2.set(2023, Calendar.JANUARY, 15, 15, 45, 30);
        
        Negociacao negociacao = new Negociacao(10.0, 100, data1);
        Assert.assertTrue(negociacao.isMesmoDia(data2));
    }

    @Test
    public void testDatasDiferentes() {
        Calendar data1 = Calendar.getInstance();
        data1.set(2023, Calendar.JANUARY, 15);
        
        Calendar data2 = Calendar.getInstance();
        data2.set(2023, Calendar.JANUARY, 16);
        
        Negociacao negociacao = new Negociacao(10.0, 100, data1);
        Assert.assertFalse(negociacao.isMesmoDia(data2));
    }
}
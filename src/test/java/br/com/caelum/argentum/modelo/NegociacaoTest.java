package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;

public class NegociacaoTest {

    @Test
    public void testCriacaoNegociacao() {
        Calendar data = Calendar.getInstance();
        Negociacao negociacao = new Negociacao(10.0, 100, data);
        
        Assert.assertEquals(10.0, negociacao.getPreco(), 0.001);
        Assert.assertEquals(100, negociacao.getQuantidade());
        Assert.assertEquals(data.getTimeInMillis(), negociacao.getData().getTimeInMillis());
    }

    @Test
    public void testVolume() {
        Calendar data = Calendar.getInstance();
        Negociacao negociacao = new Negociacao(5.0, 200, data);
        
        Assert.assertEquals(1000.0, negociacao.getVolume(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDataNula() {
        new Negociacao(10.0, 100, null);
    }

    @Test
    public void testMesmoDia() {
        Calendar data1 = Calendar.getInstance();
        Calendar data2 = Calendar.getInstance();
        
        Negociacao negociacao = new Negociacao(10.0, 100, data1);
        
        Assert.assertTrue(negociacao.isMesmoDia(data2));
    }
}
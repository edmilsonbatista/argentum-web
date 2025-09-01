package br.com.caelum.argentum.utils;

import java.util.Calendar;
import org.junit.Test;
import org.junit.Assert;
import br.com.caelum.argentum.modelo.Negociacao;

public class ValidadorNegociacaoTest {

    @Test
    public void testNegociacaoValida() {
        Calendar data = Calendar.getInstance();
        Negociacao negociacao = new Negociacao(10.0, 100, data);
        
        ValidadorNegociacao validador = new ValidadorNegociacao();
        Assert.assertTrue(validador.isValida(negociacao));
    }

    @Test
    public void testNegociacaoNula() {
        ValidadorNegociacao validador = new ValidadorNegociacao();
        Assert.assertFalse(validador.isValida(null));
    }

    @Test
    public void testPrecoValido() {
        ValidadorNegociacao validador = new ValidadorNegociacao();
        Assert.assertTrue(validador.isPrecoValido(100.0));
        Assert.assertFalse(validador.isPrecoValido(0.0));
        Assert.assertFalse(validador.isPrecoValido(-10.0));
        Assert.assertFalse(validador.isPrecoValido(20000.0));
    }

    @Test
    public void testQuantidadeValida() {
        ValidadorNegociacao validador = new ValidadorNegociacao();
        Assert.assertTrue(validador.isQuantidadeValida(100));
        Assert.assertFalse(validador.isQuantidadeValida(0));
        Assert.assertFalse(validador.isQuantidadeValida(-10));
        Assert.assertFalse(validador.isQuantidadeValida(2000000));
    }

    @Test
    public void testVolumeSignificativo() {
        Calendar data = Calendar.getInstance();
        Negociacao n1 = new Negociacao(10.0, 200, data); // volume = 2000
        Negociacao n2 = new Negociacao(5.0, 100, data);  // volume = 500
        
        ValidadorNegociacao validador = new ValidadorNegociacao();
        Assert.assertTrue(validador.isVolumeSignificativo(n1));
        Assert.assertFalse(validador.isVolumeSignificativo(n2));
        Assert.assertFalse(validador.isVolumeSignificativo(null));
    }
}
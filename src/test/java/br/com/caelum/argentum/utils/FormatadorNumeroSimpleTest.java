package br.com.caelum.argentum.utils;

import static org.junit.Assert.*;
import org.junit.Test;

public class FormatadorNumeroSimpleTest {
    
    @Test
    public void deveArredondarCorretamente() {
        double resultado = FormatadorNumero.arredondar(1.23456, 2);
        assertEquals(1.23, resultado, 0.0001);
    }
    
    @Test
    public void deveValidarNumeroCorreto() {
        assertTrue(FormatadorNumero.isNumeroValido("123.45"));
        assertFalse(FormatadorNumero.isNumeroValido("abc"));
    }
    
    @Test
    public void deveFazerParseDeNumeroValido() {
        assertEquals(123.45, FormatadorNumero.parseDouble("123.45"), 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveFazerParseDeNumeroInvalido() {
        FormatadorNumero.parseDouble("abc");
    }
}
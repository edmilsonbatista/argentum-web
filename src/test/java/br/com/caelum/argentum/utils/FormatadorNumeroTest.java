package br.com.caelum.argentum.utils;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Locale;

public class FormatadorNumeroTest {
    
    @Test
    public void deveFormatarMoedaCorretamente() {
        String resultado = FormatadorNumero.formatarMoeda(1234.56);
        assertNotNull(resultado);
        assertTrue(resultado.contains("1"));
        assertTrue(resultado.contains("234"));
        assertTrue(resultado.contains("56"));
    }
    
    @Test
    public void deveFormatarMoedaComLocaleEspecifico() {
        String resultado = FormatadorNumero.formatarMoeda(1234.56, Locale.US);
        assertTrue(resultado.contains("$"));
        assertTrue(resultado.contains("1,234.56"));
    }
    
    @Test
    public void deveFormatarDecimalCorretamente() {
        String resultado = FormatadorNumero.formatarDecimal(1234.567);
        // Aceita tanto formato brasileiro (1.234,57) quanto americano (1,234.57)
        assertTrue(resultado.contains("1") && resultado.contains("234") && resultado.contains("57"));
    }
    
    @Test
    public void deveFormatarPercentualCorretamente() {
        String resultado = FormatadorNumero.formatarPercentual(0.1234);
        // Aceita tanto formato brasileiro (12,34%) quanto americano (12.34%)
        assertTrue(resultado.contains("12") && resultado.contains("34") && resultado.contains("%"));
    }
    
    @Test
    public void deveArredondarCorretamente() {
        double resultado = FormatadorNumero.arredondar(1.23456, 2);
        assertEquals(1.23, resultado, 0.0001);
        
        resultado = FormatadorNumero.arredondar(1.23456, 3);
        assertEquals(1.235, resultado, 0.0001);
        
        resultado = FormatadorNumero.arredondar(1.23456, 0);
        assertEquals(1.0, resultado, 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveArredondarComCasasDecimaisNegativas() {
        FormatadorNumero.arredondar(1.23, -1);
    }
    
    @Test
    public void deveValidarNumeroCorreto() {
        assertTrue(FormatadorNumero.isNumeroValido("123.45"));
        assertTrue(FormatadorNumero.isNumeroValido("123"));
        assertTrue(FormatadorNumero.isNumeroValido("-123.45"));
        assertTrue(FormatadorNumero.isNumeroValido("0"));
        assertTrue(FormatadorNumero.isNumeroValido("0.0"));
    }
    
    @Test
    public void naoDeveValidarNumeroIncorreto() {
        assertFalse(FormatadorNumero.isNumeroValido(null));
        assertFalse(FormatadorNumero.isNumeroValido(""));
        assertFalse(FormatadorNumero.isNumeroValido("   "));
        assertFalse(FormatadorNumero.isNumeroValido("abc"));
        assertFalse(FormatadorNumero.isNumeroValido("12.34.56"));
        assertFalse(FormatadorNumero.isNumeroValido("12,34"));
    }
    
    @Test
    public void deveFazerParseDeNumeroValido() {
        assertEquals(123.45, FormatadorNumero.parseDouble("123.45"), 0.0001);
        assertEquals(-123.45, FormatadorNumero.parseDouble("-123.45"), 0.0001);
        assertEquals(0.0, FormatadorNumero.parseDouble("0"), 0.0001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveFazerParseDeNumeroInvalido() {
        FormatadorNumero.parseDouble("abc");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveFazerParseDeNumeroNulo() {
        FormatadorNumero.parseDouble(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void naoDeveFazerParseDeNumeroVazio() {
        FormatadorNumero.parseDouble("");
    }
}
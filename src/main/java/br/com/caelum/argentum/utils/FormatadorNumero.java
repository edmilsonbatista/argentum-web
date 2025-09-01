package br.com.caelum.argentum.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorNumero {
    
    private static final DecimalFormat FORMATO_PADRAO = new DecimalFormat("#,##0.00");
    private static final DecimalFormat FORMATO_PERCENTUAL = new DecimalFormat("#,##0.00%");
    
    public static String formatarMoeda(double valor) {
        return formatarMoeda(valor, Locale.getDefault());
    }
    
    public static String formatarMoeda(double valor, Locale locale) {
        NumberFormat formato = NumberFormat.getCurrencyInstance(locale);
        return formato.format(valor);
    }
    
    public static String formatarDecimal(double valor) {
        return FORMATO_PADRAO.format(valor);
    }
    
    public static String formatarPercentual(double valor) {
        return FORMATO_PERCENTUAL.format(valor);
    }
    
    public static double arredondar(double valor, int casasDecimais) {
        if (casasDecimais < 0) {
            throw new IllegalArgumentException("Número de casas decimais não pode ser negativo");
        }
        
        double multiplicador = Math.pow(10, casasDecimais);
        return Math.round(valor * multiplicador) / multiplicador;
    }
    
    public static boolean isNumeroValido(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            return false;
        }
        
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static double parseDouble(String numero) {
        if (!isNumeroValido(numero)) {
            throw new IllegalArgumentException("Número inválido: " + numero);
        }
        
        return Double.parseDouble(numero);
    }
}
package br.com.caelum.argentum.grafico;

import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.modelo.Candle;
import java.util.List;
import java.util.ArrayList;

public class GeradorRelatorio {
    
    private SerieTemporal serie;
    
    public GeradorRelatorio(SerieTemporal serie) {
        if (serie == null) {
            throw new IllegalArgumentException("Série temporal não pode ser nula");
        }
        this.serie = serie;
    }
    
    public String gerarResumo() {
        if (serie.getTotal() == 0) {
            return "Série vazia";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("Relatório da Série Temporal\n");
        sb.append("Total de candles: ").append(serie.getTotal()).append("\n");
        sb.append("Maior alta: ").append(encontrarMaiorAlta()).append("\n");
        sb.append("Menor baixa: ").append(encontrarMenorBaixa()).append("\n");
        
        return sb.toString();
    }
    
    public double encontrarMaiorAlta() {
        if (serie.getTotal() == 0) {
            return 0.0;
        }
        
        double maiorAlta = serie.getCandle(0).getMaximo();
        for (int i = 1; i < serie.getTotal(); i++) {
            double alta = serie.getCandle(i).getMaximo();
            if (alta > maiorAlta) {
                maiorAlta = alta;
            }
        }
        return maiorAlta;
    }
    
    public double encontrarMenorBaixa() {
        if (serie.getTotal() == 0) {
            return 0.0;
        }
        
        double menorBaixa = serie.getCandle(0).getMinimo();
        for (int i = 1; i < serie.getTotal(); i++) {
            double baixa = serie.getCandle(i).getMinimo();
            if (baixa < menorBaixa) {
                menorBaixa = baixa;
            }
        }
        return menorBaixa;
    }
    
    public List<Candle> getCandlesAcimaDaMedia() {
        List<Candle> resultado = new ArrayList<>();
        double media = calcularMediaFechamento();
        
        for (int i = 0; i < serie.getTotal(); i++) {
            Candle candle = serie.getCandle(i);
            if (candle.getFechamento() > media) {
                resultado.add(candle);
            }
        }
        
        return resultado;
    }
    
    private double calcularMediaFechamento() {
        if (serie.getTotal() == 0) {
            return 0.0;
        }
        
        double soma = 0.0;
        for (int i = 0; i < serie.getTotal(); i++) {
            soma += serie.getCandle(i).getFechamento();
        }
        
        return soma / serie.getTotal();
    }
}
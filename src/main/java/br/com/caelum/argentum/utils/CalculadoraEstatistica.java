package br.com.caelum.argentum.utils;

import java.util.List;
import br.com.caelum.argentum.modelo.Negociacao;

public class CalculadoraEstatistica {

    public double calculaMedia(List<Negociacao> negociacoes) {
        if (negociacoes == null || negociacoes.isEmpty()) {
            return 0.0;
        }
        
        double soma = 0.0;
        for (Negociacao negociacao : negociacoes) {
            soma += negociacao.getPreco();
        }
        return soma / negociacoes.size();
    }

    public double calculaMaximo(List<Negociacao> negociacoes) {
        if (negociacoes == null || negociacoes.isEmpty()) {
            return 0.0;
        }
        
        double maximo = Double.MIN_VALUE;
        for (Negociacao negociacao : negociacoes) {
            if (negociacao.getPreco() > maximo) {
                maximo = negociacao.getPreco();
            }
        }
        return maximo;
    }

    public double calculaMinimo(List<Negociacao> negociacoes) {
        if (negociacoes == null || negociacoes.isEmpty()) {
            return 0.0;
        }
        
        double minimo = Double.MAX_VALUE;
        for (Negociacao negociacao : negociacoes) {
            if (negociacao.getPreco() < minimo) {
                minimo = negociacao.getPreco();
            }
        }
        return minimo;
    }
}
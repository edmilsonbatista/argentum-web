package br.com.caelum.argentum.utils;

import br.com.caelum.argentum.modelo.Negociacao;

public class ValidadorNegociacao {

    public boolean isValida(Negociacao negociacao) {
        if (negociacao == null) {
            return false;
        }
        
        return negociacao.getPreco() > 0 && 
               negociacao.getQuantidade() > 0 && 
               negociacao.getData() != null;
    }

    public boolean isPrecoValido(double preco) {
        return preco > 0 && preco <= 10000;
    }

    public boolean isQuantidadeValida(int quantidade) {
        return quantidade > 0 && quantidade <= 1000000;
    }

    public boolean isVolumeSignificativo(Negociacao negociacao) {
        if (negociacao == null) {
            return false;
        }
        return negociacao.getVolume() >= 1000;
    }
}
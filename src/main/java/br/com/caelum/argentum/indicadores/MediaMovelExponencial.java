package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelExponencial implements Indicador {
    
    private double fatorSuavizacao;
    
    public MediaMovelExponencial(double fatorSuavizacao) {
        if (fatorSuavizacao <= 0 || fatorSuavizacao >= 1) {
            throw new IllegalArgumentException("Fator de suavização deve estar entre 0 e 1");
        }
        this.fatorSuavizacao = fatorSuavizacao;
    }
    
    @Override
    public double calcula(int posicao, SerieTemporal serie) {
        if (posicao < 0 || posicao >= serie.getTotal()) {
            throw new IllegalArgumentException("Posição inválida");
        }
        
        if (posicao == 0) {
            return serie.getCandle(0).getFechamento();
        }
        
        double emaAnterior = calcula(posicao - 1, serie);
        double precoAtual = serie.getCandle(posicao).getFechamento();
        
        return (precoAtual * fatorSuavizacao) + (emaAnterior * (1 - fatorSuavizacao));
    }
    
    public double getFatorSuavizacao() {
        return fatorSuavizacao;
    }
}
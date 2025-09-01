package br.com.caelum.argentum.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    
    private List<Negociacao> negociacoes;
    private BigDecimal saldoInicial;
    
    public Portfolio(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
        this.negociacoes = new ArrayList<>();
    }
    
    public void adicionarNegociacao(Negociacao negociacao) {
        if (negociacao == null) {
            throw new IllegalArgumentException("Negociação não pode ser nula");
        }
        this.negociacoes.add(negociacao);
    }
    
    public BigDecimal calcularValorTotal() {
        BigDecimal total = saldoInicial;
        for (Negociacao negociacao : negociacoes) {
            total = total.add(negociacao.getVolume());
        }
        return total;
    }
    
    public int getTotalNegociacoes() {
        return negociacoes.size();
    }
    
    public List<Negociacao> getNegociacoes() {
        return new ArrayList<>(negociacoes);
    }
    
    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }
}
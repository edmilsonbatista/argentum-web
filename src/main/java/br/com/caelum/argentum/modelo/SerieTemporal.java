package br.com.caelum.argentum.modelo;

import java.util.List;
import java.util.ArrayList;

public class SerieTemporal {

	private final List<Candle> candles;
	
	public SerieTemporal(List<Candle> candles) {
		this.candles = candles;
	}
	
	public SerieTemporal() {
		this.candles = new ArrayList<>();
	}
	
	public Candle getCandle(int i) {
		return this.candles.get(i);
	}
	
	public int getUltimaPosicao(){
		return this.candles.size()-1;
	}
	
	public int getTotal() {
		return this.candles.size();
	}
	
	public void adiciona(Candle candle) {
		this.candles.add(candle);
	}
}

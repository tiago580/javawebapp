package br.com.trsystems.base.indicadores;

public enum IndicadorSimNao {
	NAO(0), SIM(1);
	private int value;

	IndicadorSimNao(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}

package dev.anthhyo.moedas;

import dev.anthhyo.interfaces.IMoeda;

public abstract class Moeda implements IMoeda {

	protected final double valor;

	protected Moeda(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}

}

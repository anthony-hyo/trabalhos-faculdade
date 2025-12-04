package dev.anthhyo.moedas;

import dev.anthhyo.interfaces.IMoeda;

public abstract class Moeda implements IMoeda {
	
	protected double valor = 0f;

	@Override
	public void info() {
		throw new UnsupportedOperationException("Método não implementado");
	}

	@Override
	public void converter() {
		throw new UnsupportedOperationException("Método não implementado");
	}

}

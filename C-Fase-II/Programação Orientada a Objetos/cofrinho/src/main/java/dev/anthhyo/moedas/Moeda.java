package dev.anthhyo.moedas;

import dev.anthhyo.interfaces.IMoeda;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Moeda implements IMoeda {

	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

	protected final int id;
	protected final double valor;

	protected Moeda(double valor) {
		this.id = ATOMIC_INTEGER.incrementAndGet();
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "#%d - %s | valor=%s".formatted(id, this.getClass().getSimpleName(), valor);
	}

}

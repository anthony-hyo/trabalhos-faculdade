package dev.anthhyo.moedas;

import dev.anthhyo.interfaces.IMoeda;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Moeda implements IMoeda {

	//Gerador de IDs únicos para cada moeda criada.
	private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

	//Identificador único da moeda.
	protected final int id;

	//Valor da moeda.
	protected final double valor;

	/**
	 * Cada moeda possui um ID único para permitir
	 * remoção precisa mesmo com valores duplicados
	 */
	protected Moeda(double valor) {
		this.id = ATOMIC_INTEGER.incrementAndGet(); // Gera ID único incremental
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

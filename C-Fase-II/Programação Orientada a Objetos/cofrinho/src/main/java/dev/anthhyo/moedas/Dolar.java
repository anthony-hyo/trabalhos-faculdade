package dev.anthhyo.moedas;

import dev.anthhyo.cofrinho.Cofrinho;
import dev.anthhyo.enums.Moedas;
import dev.anthhyo.utilidades.ConsoleIO;

public class Dolar extends Moeda {

	public Dolar(double valor) {
		super(valor);
	}

	@Override
	public void info() {
		ConsoleIO.printOpcao("Dólar (USD)", "$%s".formatted(valor));
	}

	@Override
	public double converter() {
		return Cofrinho.cotacao.get(Moedas.DOLAR) * valor;
	}

}

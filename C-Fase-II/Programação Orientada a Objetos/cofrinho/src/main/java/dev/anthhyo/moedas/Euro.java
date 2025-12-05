package dev.anthhyo.moedas;

import dev.anthhyo.cofrinho.Cofrinho;
import dev.anthhyo.enums.Moedas;
import dev.anthhyo.utilidades.ConsoleIO;

public class Euro extends Moeda {

	public Euro(double valor) {
		super(valor);
	}

	@Override
	public void info() {
		ConsoleIO.printOpcao("Euro (EUR)", "€%s".formatted(valor));
	}

	@Override
	public double converter() {
		return Cofrinho.cotacao.get(Moedas.EURO) * valor;
	}

}

package dev.anthhyo.moedas;

import dev.anthhyo.cofrinho.Cofrinho;
import dev.anthhyo.enums.Moedas;
import dev.anthhyo.utilidades.ConsoleIO;

public class Real extends Moeda {

	public Real(double valor) {
		super(valor);
	}

	@Override
	public void info() {
		ConsoleIO.printOpcao("Real (BRL)", "R$%s".formatted(valor));
	}

	@Override
	public double converter() {
		return Cofrinho.cotacao.get(Moedas.REAL) * valor;
	}

}

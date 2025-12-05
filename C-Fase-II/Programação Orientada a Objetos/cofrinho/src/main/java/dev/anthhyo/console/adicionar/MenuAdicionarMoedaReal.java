package dev.anthhyo.console.adicionar;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Real;
import dev.anthhyo.utilidades.ConsoleIO;

@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Real (BRL)",
	informacao = "Adicionando em Real (BRL)"
)
public class MenuAdicionarMoedaReal extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		double valor = new ConsoleIO().getDouble("Entre com o valor:", "Valor é invalido! digite apenas numeros.");

		Main.COFRINHO.adicionar(new Real(valor));

		ConsoleIO.printSucesso("Real (BRL) adicionado com sucesso!");
	}

}

package dev.anthhyo.console.adicionar;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Euro;
import dev.anthhyo.utilidades.ConsoleIO;

@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Euro (EUR)",
	informacao = "Adicionando em Euro (EUR)"
)
public class MenuAdicionarMoedaEuro extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		double valor = Main.CONSOLE.getDouble("Entre com o valor:", "Valor é invalido! digite apenas numeros.");

		Main.COFRINHO.adicionar(new Euro(valor));

		ConsoleIO.printSucesso("Euro (EUR) adicionado com sucesso!");
	}

}

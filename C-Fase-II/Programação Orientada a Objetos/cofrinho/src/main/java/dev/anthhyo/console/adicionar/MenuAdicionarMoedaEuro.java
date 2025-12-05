package dev.anthhyo.console.adicionar;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Euro;
import dev.anthhyo.utilidades.ConsoleIO;

/**
 * Menu para adicionar moedas em {@link Euro} (EUR) ao cofrinho
 */
@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Euro (EUR)",
	informacao = "Adicionando em Euro (EUR)"
)
public class MenuAdicionarMoedaEuro extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		// Exibe cabeçalho padrão
		printBase();

		// Pega o valor digitado pelo usuário
		double valor = Main.CONSOLE.getDouble("Entre com o valor:", "Valor é invalido! digite apenas numeros.");

		// Cria nova instância de Dólar e adiciona no cofrinho
		Main.COFRINHO.adicionar(new Euro(valor));

		ConsoleIO.printSucesso("Euro (EUR) adicionado com sucesso!");
	}

}

package dev.anthhyo.console.adicionar;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Real;
import dev.anthhyo.utilidades.ConsoleIO;

/**
 * Menu para adicionar moedas em {@link Real} (BRL) ao cofrinho
 */
@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Real (BRL)",
	informacao = "Adicionando em Real (BRL)"
)
public class MenuAdicionarMoedaReal extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		// Exibe cabeçalho padrão
		printBase();

		// Pega o valor digitado pelo usuário
		double valor = Main.CONSOLE.getDouble("Entre com o valor:", "Valor é invalido! digite apenas numeros.");

		// Cria nova instância de Dólar e adiciona no cofrinho
		Main.COFRINHO.adicionar(new Real(valor));

		ConsoleIO.printSucesso("Real (BRL) adicionado com sucesso!");
	}

}

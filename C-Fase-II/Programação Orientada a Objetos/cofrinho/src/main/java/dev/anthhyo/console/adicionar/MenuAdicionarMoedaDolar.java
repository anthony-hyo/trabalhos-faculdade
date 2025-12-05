package dev.anthhyo.console.adicionar;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Dolar;
import dev.anthhyo.utilidades.ConsoleIO;

/**
 * Menu para adicionar moedas em {@link Dolar} (USD) ao cofrinho
 */
@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Dólar (USD)",
	informacao = "Adicionando em Dólar (USD)"
)
public class MenuAdicionarMoedaDolar extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		// Exibe cabeçalho padrão
		printBase();

		// Pega o valor digitado pelo usuário
		double valor = MenuAdicionarMoedaReal.getValor();

		// Cria nova instância de Dólar e adiciona no cofrinho
		Main.COFRINHO.adicionar(new Dolar(valor));

		ConsoleIO.printSucesso("Dólar (USD) adicionado com sucesso!");
	}

}

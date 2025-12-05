package dev.anthhyo.console.listar;

import dev.anthhyo.Main;

/**
 * Menu para listar todas as moedas do cofrinho
 */
@dev.anthhyo.annotation.Menu(
	titulo = "Listar Moedas",
	informacao = "Listando moedas"
)
public class MenuListarMoeda extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		// Exibe cabeçalho padrão
		printBase();

		// Chama listagem do Cofrinho
		// Cada moeda sabe como se apresentar (info())
		Main.COFRINHO.listagemMoedas();
	}

}

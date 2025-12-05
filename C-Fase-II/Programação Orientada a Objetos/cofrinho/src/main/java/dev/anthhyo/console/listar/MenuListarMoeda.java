package dev.anthhyo.console.listar;

import dev.anthhyo.Main;

@dev.anthhyo.annotation.Menu(
	titulo = "Listar Moedas",
	informacao = "Listando moedas"
)
public class MenuListarMoeda extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		// Chama listagem do Cofrinho
		// Cada moeda sabe como se apresentar (info())
		Main.COFRINHO.listagemMoedas();
	}

}

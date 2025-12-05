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

		Main.COFRINHO.listagemMoedas();
	}

}

package dev.anthhyo.console.listar;

import dev.anthhyo.console.Menu;

@dev.anthhyo.annotation.Menu(
	informacao = "Listando moedas"
)
public class MenuListarMoeda extends Menu {

	@Override
	public void print() {
		System.out.println("Listando moedas");
	}

}

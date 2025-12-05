package dev.anthhyo.console.total;

import dev.anthhyo.console.Menu;

@dev.anthhyo.annotation.Menu(
	informacao = "Total de moedas em real"
)
public class MenuTotalEmReal extends Menu {

	@Override
	public void print() {
		System.out.println("Total de moedas em real");
	}

}

package dev.anthhyo.console;

import dev.anthhyo.interfaces.IMenu;

@dev.anthhyo.annotation.Menu(
	titulo = "Sair",
	informacao = "Sair"
)
public class MenuSair implements IMenu {

	@Override
	public void print() {
		System.exit(0);
	}

}

package dev.anthhyo.console.remover;

import dev.anthhyo.Main;

@dev.anthhyo.annotation.Menu(
	titulo = "Remover todas as moedas",
	informacao = "Removendo todas as moedas adicionadas"
)
public class MenuRemoverTodasMoedas extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		// Remove todas as moedas do cofrinho
		Main.COFRINHO.getListaMoedas().clear();
	}

}

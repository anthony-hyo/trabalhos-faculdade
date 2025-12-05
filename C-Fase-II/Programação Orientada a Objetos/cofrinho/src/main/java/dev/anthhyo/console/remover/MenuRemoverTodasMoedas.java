package dev.anthhyo.console.remover;

import dev.anthhyo.Main;

/**
 * Menu para remover todas as moedas do cofrinho
 */
@dev.anthhyo.annotation.Menu(
	titulo = "Remover todas as moedas",
	informacao = "Removendo todas as moedas adicionadas"
)
public class MenuRemoverTodasMoedas extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		// Exibe cabeçalho padrão
		printBase();

		// Remove todas as moedas do cofrinho
		Main.COFRINHO.getListaMoedas().clear();
	}

}

package dev.anthhyo.console.remover;

import dev.anthhyo.annotation.MenuOpcao;

/**
 * Exibe menu com opções para selecinar uma moeda
 * para ser removida do cofrinho
 */
@dev.anthhyo.annotation.Menu(
	titulo = "Remover Moeda",
	informacao = "Escolha a moeda desejada",
	opcoes = {
		@MenuOpcao(
			id = 1,
			cls = MenuRemoverMoedaReal.class
		),
		@MenuOpcao(
			id = 2,
			cls = MenuRemoverMoedaDolar.class
		),
		@MenuOpcao(
			id = 3,
			cls = MenuRemoverMoedaEuro.class
		),
		@MenuOpcao(
			id = 4,
			cls = MenuRemoverTodasMoedas.class
		),
	}
)
public class MenuRemoverMoeda extends dev.anthhyo.console.Menu {

}

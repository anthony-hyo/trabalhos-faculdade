package dev.anthhyo.console.remover;

import dev.anthhyo.annotation.MenuOpcao;

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
	}
)
public class MenuRemoverMoeda extends dev.anthhyo.console.Menu {

}

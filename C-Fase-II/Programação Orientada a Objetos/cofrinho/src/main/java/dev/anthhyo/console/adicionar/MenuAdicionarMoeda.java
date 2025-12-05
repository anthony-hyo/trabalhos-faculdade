package dev.anthhyo.console.adicionar;

import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.console.Menu;

@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Moeda",
	informacao = "Escolha a moeda desejada",
	opcoes = {
		@MenuOpcao(
			id = 1,
			cls = MenuAdicionarMoedaReal.class
		),
		@MenuOpcao(
			id = 2,
			cls = MenuAdicionarMoedaDolar.class
		),
		@MenuOpcao(
			id = 3,
			cls = MenuAdicionarMoedaEuro.class
		),
	}
)
public class MenuAdicionarMoeda extends Menu {

}

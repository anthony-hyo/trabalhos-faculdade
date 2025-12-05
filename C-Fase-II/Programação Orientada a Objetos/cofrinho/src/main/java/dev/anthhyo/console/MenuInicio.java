package dev.anthhyo.console;

import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.console.adicionar.MenuAdicionarMoeda;
import dev.anthhyo.console.listar.MenuListarMoeda;
import dev.anthhyo.console.remover.MenuRemoverMoeda;
import dev.anthhyo.console.total.MenuTotalEmReal;

@dev.anthhyo.annotation.Menu(
	header = "Cofrinho",
	titulo = "titulo",
	informacao = "Inicio",
	opcoes = {
		@MenuOpcao(
			id = 1,
			cls = MenuAdicionarMoeda.class
		),
		@MenuOpcao(
			id = 2,
			cls = MenuRemoverMoeda.class
		),
		@MenuOpcao(
			id = 3,
			cls = MenuListarMoeda.class
		),
		@MenuOpcao(
			id = 4,
			cls = MenuTotalEmReal.class
		),
		@MenuOpcao(
			id = 5,
			cls = MenuTotalEmReal.class
		)
	}
)
public class MenuInicio extends Menu {

}

package dev.anthhyo.console;

import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.console.adicionar.MenuAdicionarMoeda;
import dev.anthhyo.console.listar.MenuListarMoeda;
import dev.anthhyo.console.remover.MenuRemoverMoeda;
import dev.anthhyo.console.total.MenuTotalEmReal;
import dev.anthhyo.utilidades.ConsoleIO;

@dev.anthhyo.annotation.Menu(
	header = "Cofrinho",
	informacao = "Inicio",
	opcoes = {
		@MenuOpcao(
			id = MenuInicio.ADICIONAR_MOEDA,
			descricao = "Adicionar Moeda",
			cls = MenuAdicionarMoeda.class
		),
		@MenuOpcao(
			id = MenuInicio.REMOVER_MOEDA,
			descricao = "Remover Moeda",
			cls = MenuRemoverMoeda.class
		),
		@MenuOpcao(
			id = MenuInicio.LISTAR_MOEDAS,
			descricao = "Listar Moedas",
			cls = MenuListarMoeda.class
		),
		@MenuOpcao(
			id = MenuInicio.TOTAL,
			descricao = "Calcular total convertido para Real",
			cls = MenuTotalEmReal.class
		),
		@MenuOpcao(
			id = MenuInicio.SAIR,
			descricao = "Sair",
			cls = MenuTotalEmReal.class
		)
	}
)
public class MenuInicio extends Menu {

	public static final int ADICIONAR_MOEDA = 1;
	public static final int REMOVER_MOEDA = 2;
	public static final int LISTAR_MOEDAS = 3;
	public static final int TOTAL = 4;
	public static final int SAIR = 5;

}

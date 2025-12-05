package dev.anthhyo.console.remover;

import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.console.Menu;
import dev.anthhyo.console.total.MenuTotalEmReal;

@dev.anthhyo.annotation.Menu(
	informacao = "Escolha a moeda desejada",
	opcoes = {
		@MenuOpcao(
			id = MenuRemoverMoeda.REMOVER_BRL,
			descricao = "Remover Real (BRL)",
			cls = MenuTotalEmReal.class
		),
		@MenuOpcao(
			id = MenuRemoverMoeda.REMOVER_USD,
			descricao = "Remover Dolar (USD)",
			cls = MenuTotalEmReal.class
		),
		@MenuOpcao(
			id = MenuRemoverMoeda.REMOVER_EUR,
			descricao = "Remover Euro (EUR)",
			cls = MenuTotalEmReal.class
		),
	}
)
public class MenuRemoverMoeda extends Menu {

	public static final int REMOVER_BRL = 1;

	public static final int REMOVER_USD = 2;

	public static final int REMOVER_EUR = 3;

}

package dev.anthhyo.console.adicionar;

import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.console.Menu;
import dev.anthhyo.console.total.MenuTotalEmReal;

@dev.anthhyo.annotation.Menu(
	titulo = "Listar Moedas",
	informacao = "Escolha a moeda desejada",
	opcoes = {
		@MenuOpcao(
			id = MenuAdicionarMoeda.ADICIONAR_BRL,
			descricao = "Adicionar Real (BRL)",
			cls = MenuTotalEmReal.class
		),
		@MenuOpcao(
			id = MenuAdicionarMoeda.ADICIONAR_USD,
			descricao = "Adicionar Dolar (USD)",
			cls = MenuTotalEmReal.class
		),
		@MenuOpcao(
			id = MenuAdicionarMoeda.ADICIONAR_EUR,
			descricao = "Adicionar Euro (EUR)",
			cls = MenuTotalEmReal.class
		),
	}
)
public class MenuAdicionarMoeda extends Menu {

	public static final int ADICIONAR_BRL = 1;

	public static final int ADICIONAR_USD = 2;

	public static final int ADICIONAR_EUR = 3;

}

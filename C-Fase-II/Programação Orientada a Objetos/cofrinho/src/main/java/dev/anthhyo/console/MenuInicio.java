package dev.anthhyo.console;

import dev.anthhyo.annotation.MenuOpcao;

@dev.anthhyo.annotation.Menu(
	header = "Cofrinho",
	titulo = "Inicio",
	opcoes = {
		@MenuOpcao(
			id = MenuInicio.ADICIONAR_MOEDA,
			descricao = "Adicionar Moeda"
		),
		@MenuOpcao(
			id = MenuInicio.REMOVER_MOEDA,
			descricao = "Remover Moeda"
		),
		@MenuOpcao(
			id = MenuInicio.LISTAR_MOEDAS,
			descricao = "Listar Moedas"
		),
		@MenuOpcao(
			id = MenuInicio.TOTAL,
			descricao = "Calcular total convertido para Real"
		),
		@MenuOpcao(
			id = MenuInicio.SAIR,
			descricao = "Sair"
		)
	}
)
public class MenuInicio extends Menu {

	public static final int ADICIONAR_MOEDA = 1;
	public static final int REMOVER_MOEDA = 2;
	public static final int LISTAR_MOEDAS = 3;
	public static final int TOTAL = 4;
	public static final int SAIR = 5;

	@Override
	public void opcaoSelecionada(int opcao) {
		switch (opcao) {
			case ADICIONAR_MOEDA -> {
				new MenuAdicionarMoeda()
					.opcao(1, MenuAdicionarMoeda.class)
					.print();
			}
			case REMOVER_MOEDA -> {

			}
			case LISTAR_MOEDAS -> {

			}
			case TOTAL -> {

			}
			case SAIR -> {

			}
		}
	}

}

package dev.anthhyo.console;

import dev.anthhyo.annotation.MenuOpcao;

@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Moeda",
	opcoes = {
		@MenuOpcao(
			id = 2,
			descricao = "Remover Moeda"
		),
		@MenuOpcao(
			id = 3,
			descricao = "Listar Moedas"
		),
	}
)
public class MenuAdicionarMoeda extends Menu {

	@Override
	public void opcaoSelecionada(int opcao) {
		System.out.println(">>>>>>>>>>> " + opcao);
	}

}

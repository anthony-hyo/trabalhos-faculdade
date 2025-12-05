package dev.anthhyo.interfaces;

public interface IMenu {
	
	void opcaoSelecionada(int opcao);

	IMenu opcao(int id, Class<? extends IMenu> c);
	
	void print();
	
}

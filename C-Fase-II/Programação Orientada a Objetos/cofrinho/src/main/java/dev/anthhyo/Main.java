package dev.anthhyo;

import dev.anthhyo.console.MenuAdicionarMoeda;
import dev.anthhyo.console.MenuInicio;
import dev.anthhyo.utilidades.ConsoleIO;

public class Main {

	private static final ConsoleIO CONSOLE_IO = new ConsoleIO();

	public static void main(String[] args) {
		new MenuInicio()
			.opcao(1, MenuAdicionarMoeda.class)
			.print();
		
		/*System.out.println("1 - Adicionar Moeda");
		System.out.println("1 - Remover Moeda");
		System.out.println("1 - Listar Moedas");
		System.out.println("1 - Calcular total convertido para Real");
		System.out.println("1 - Sair");*/
	}

}
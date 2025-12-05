package dev.anthhyo;

import dev.anthhyo.cofrinho.Cofrinho;
import dev.anthhyo.console.MenuInicio;
import dev.anthhyo.utilidades.ConsoleIO;

public class Main {

	public static final Cofrinho COFRINHO = new Cofrinho();

	public static final ConsoleIO CONSOLE = new ConsoleIO();

	public static void main(String[] args) {
		while (true) new MenuInicio().print();
	}

}
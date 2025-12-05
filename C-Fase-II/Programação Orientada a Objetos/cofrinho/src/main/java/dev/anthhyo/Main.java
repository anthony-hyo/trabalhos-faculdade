package dev.anthhyo;

import dev.anthhyo.cofrinho.Cofrinho;
import dev.anthhyo.console.MenuInicio;

public class Main {

	public static final Cofrinho cofrinho = new Cofrinho();

	public static void main(String[] args) {
		while (true) new MenuInicio().print();
	}

}
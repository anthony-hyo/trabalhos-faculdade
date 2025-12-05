package dev.anthhyo.cofrinho;

import dev.anthhyo.enums.Moedas;
import dev.anthhyo.moedas.Moeda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cofrinho {

	public static final HashMap<Moedas, Double> cotacao = new HashMap<>() {
		{
			put(Moedas.DOLAR, 5.31d);
			put(Moedas.EURO, 6.19d);
			put(Moedas.REAL, 1d);
		}
	};

	private final List<Moeda> listaMoedas = new ArrayList<>();

	public void adicionar(Moeda moeda) {
		listaMoedas.add(moeda);
	}

	public void remover(Moeda moeda) {
		listaMoedas.remove(moeda);
	}

	public void listagemMoedas() {

	}

	public void totalConvertido() {

	}

}

package dev.anthhyo.cofrinho;

import dev.anthhyo.enums.Moedas;
import dev.anthhyo.interfaces.IMoeda;
import dev.anthhyo.moedas.Moeda;
import dev.anthhyo.utilidades.ConsoleIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cofrinho {

	//Lista das moedas com suas cotaões para BRL
	public static final Map<Moedas, Double> cotacao = Map.of(
		Moedas.DOLAR, 5.31d,
		Moedas.EURO, 6.19d,
		Moedas.REAL, 1.0d
	);

	private final List<Moeda> listaMoedas = new ArrayList<>();

	public List<Moeda> getListaMoedas() {
		return listaMoedas;
	}

	public void adicionar(Moeda moeda) {
		listaMoedas.add(moeda);
	}

	public boolean remover(Moeda moeda) {
		return listaMoedas.remove(moeda);
	}

	/**
	 * chama info() de cada tipo de moeda e exibe
	 * para o usuário
	 */
	public void listagemMoedas() {
		if (listaMoedas.isEmpty()) {
			ConsoleIO.printOpcaoInvalida("Cofrinho Vazio!");
		}

		listaMoedas.forEach(IMoeda::info);
	}

	/**
	 * chama converter() de cada tipo de moeda e
	 * soma o resultado de cada moeda
	 */
	public double totalConvertido() {
		return listaMoedas
			.stream()
			.mapToDouble(IMoeda::converter) //cada moeda converte seu valor para BRL
			.sum();
	}

}

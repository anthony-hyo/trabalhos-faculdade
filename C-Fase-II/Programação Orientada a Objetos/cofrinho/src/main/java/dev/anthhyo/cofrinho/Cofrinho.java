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
		Moedas.DOLAR, 5.31d,  // 1 USD = 5.31 BRL
		Moedas.EURO, 6.19d,   // 1 EUR = 6.19 BRL  
		Moedas.REAL, 1.0d     // 1 BRL = 1.0 BRL
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
	 * Exibe informações de todas as moedas do cofrinho.
	 * <p>
	 * Chama info() de cada tipo de moeda e exibe para o usuário
	 */
	public void listagemMoedas() {
		// Verifica se o cofrinho está vazio antes de listar
		if (listaMoedas.isEmpty()) {
			ConsoleIO.printOpcaoInvalida("Cofrinho Vazio!");
		}

		listaMoedas.forEach(IMoeda::info);
	}

	/**
	 * Calcula o total de todas as moedas convertido para Real (BRL).
	 * Chama converter() de cada tipo de moeda e soma o resultado de cada moeda
	 *
	 * @return valor total das moedas convertido para Real
	 */
	public double totalConvertido() {
		return listaMoedas
			.stream()
			.mapToDouble(IMoeda::converter) // Converte cada moeda para double (BRL)
			.sum(); // Soma todos os valores convertidos
	}

}

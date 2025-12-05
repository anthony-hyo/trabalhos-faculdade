package dev.anthhyo.console.remover;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Dolar;
import dev.anthhyo.moedas.Moeda;
import dev.anthhyo.utilidades.ConsoleIO;

import java.util.HashMap;

@dev.anthhyo.annotation.Menu(
	titulo = "Remover Dólar (USD)",
	informacao = "Removendo moeda em Dólar (USD)"
)
public class MenuRemoverMoedaDolar extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		HashMap<Integer, Moeda> moedas = new HashMap<>();

		int i = 1;

		for (Moeda moeda : Main.COFRINHO.getListaMoedas().stream().filter(moeda -> moeda instanceof Dolar).toList()) {
			moedas.put(i, moeda);

			ConsoleIO.printOpcao(i, String.valueOf(moeda.getValor()));

			i++;
		}

		int valor = Main.CONSOLE.getInt("Escolha a moeda que deseja remover:", "Moeda inválida! Digite apenas números.");

		if (moedas.containsKey(valor)) {
			if (Main.COFRINHO.remover(moedas.get(valor))) {
				ConsoleIO.printSucesso("Dólar removido com sucesso!");
			}
		} else {
			ConsoleIO.printOpcaoInvalida("Nenhuma moeda com esse valor encontrada.");
		}
	}

}

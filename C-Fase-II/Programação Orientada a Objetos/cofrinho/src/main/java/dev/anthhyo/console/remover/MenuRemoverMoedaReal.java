package dev.anthhyo.console.remover;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Moeda;
import dev.anthhyo.moedas.Real;
import dev.anthhyo.utilidades.ConsoleIO;

import java.util.Optional;

@dev.anthhyo.annotation.Menu(
	titulo = "Remover Real (BRL)",
	informacao = "Removendo moeda em Real (BRL)"
)
public class MenuRemoverMoedaReal extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		for (Moeda moeda : Main.COFRINHO.getListaMoedas().stream().filter(moeda -> moeda instanceof Real).toList()) {
			ConsoleIO.printOpcao(moeda.getId(), String.valueOf(moeda.getValor()));
		}

		int valor = Main.CONSOLE.getInt("Escolha a moeda que deseja remover:", "Moeda inválida! Digite apenas números.");

		Optional<Moeda> moedaOptional = Main.COFRINHO.getListaMoedas().stream().filter(moeda -> moeda.getId() == valor).findFirst();

		if (moedaOptional.isPresent()) {
			if (Main.COFRINHO.remover(moedaOptional.get())) {
				ConsoleIO.printSucesso("Real removido com sucesso!");
			}
		} else {
			ConsoleIO.printOpcaoInvalida("Nenhuma moeda com esse ID encontrada.");
		}
	}

}

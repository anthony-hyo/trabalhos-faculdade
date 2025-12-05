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

		// Filtra apenas moedas do tipo usando stream e exibe para o usuário
		for (Moeda moeda : Main.COFRINHO.getListaMoedas().stream().filter(moeda -> moeda instanceof Real).toList()) {
			ConsoleIO.printOpcao(moeda.getId(), String.valueOf(moeda.getValor()));
		}

		int valor = Main.CONSOLE.getInt("Escolha a moeda que deseja remover:", "Moeda inválida! Digite apenas números.");

		// Procura a moeda pelo ID informado usando Optional para evitar null pointer
		Optional<Moeda> moedaOptional = Main.COFRINHO.getListaMoedas().stream().filter(moeda -> moeda.getId() == valor).findFirst();

		// Remove a moeda caso exista
		if (moedaOptional.isPresent()) {
			if (Main.COFRINHO.remover(moedaOptional.get())) {
				ConsoleIO.printSucesso("Real removido com sucesso!");
			}
		} else {
			ConsoleIO.printOpcaoInvalida("Nenhuma moeda com esse ID encontrada.");
		}
	}

}

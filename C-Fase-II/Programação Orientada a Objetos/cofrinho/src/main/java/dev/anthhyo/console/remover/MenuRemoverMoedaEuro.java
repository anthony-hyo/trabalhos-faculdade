package dev.anthhyo.console.remover;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Euro;
import dev.anthhyo.moedas.Moeda;
import dev.anthhyo.utilidades.ConsoleIO;

import java.util.Optional;

/**
 * Menu para remover moedas em {@link Euro} (EUR) do cofrinho
 */
@dev.anthhyo.annotation.Menu(
	titulo = "Remover Euro (EUR)",
	informacao = "Removendo moeda em Euro (EUR)"
)
public class MenuRemoverMoedaEuro extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		// Exibe cabeçalho padrão
		printBase();

		// Filtra apenas moedas do tipo usando stream e exibe para o usuário
		for (Moeda moeda : Main.COFRINHO.getListaMoedas().stream().filter(moeda -> moeda instanceof Euro).toList()) {
			ConsoleIO.printOpcao(moeda.getId(), String.valueOf(moeda.getValor()));
		}

		int valor = Main.CONSOLE.getInt("Escolha a moeda que deseja remover:", "Moeda inválida! Digite apenas números.");

		// Procura a moeda pelo ID informado usando Optional para evitar null pointer
		Optional<Moeda> moedaOptional = Main.COFRINHO.getListaMoedas().stream().filter(moeda -> moeda.getId() == valor).findFirst();

		// Remove a moeda caso exista
		if (moedaOptional.isPresent()) {
			if (Main.COFRINHO.remover(moedaOptional.get())) {
				ConsoleIO.printSucesso("Euro removido com sucesso!");
			}
		} else {
			ConsoleIO.printOpcaoInvalida("Nenhuma moeda com esse ID encontrada.");
		}
	}

}

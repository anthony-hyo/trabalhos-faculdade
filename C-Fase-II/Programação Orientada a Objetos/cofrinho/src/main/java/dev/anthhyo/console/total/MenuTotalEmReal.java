package dev.anthhyo.console.total;

import dev.anthhyo.Main;
import dev.anthhyo.utilidades.ConsoleIO;

@dev.anthhyo.annotation.Menu(
	titulo = "Calcular total convertido para Real (BRL)",
	informacao = "Total de moedas em Real (BRL)"
)
public class MenuTotalEmReal extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		// Exibe total convertido em real
		ConsoleIO.printOpcao("R$ %.2f".formatted(Main.COFRINHO.totalConvertido()), "Total convertido para Real (BRL)");
	}

}

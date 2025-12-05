package dev.anthhyo.console.adicionar;

import dev.anthhyo.Main;
import dev.anthhyo.moedas.Dolar;
import dev.anthhyo.utilidades.ConsoleIO;

@dev.anthhyo.annotation.Menu(
	titulo = "Adicionar Dólar (USD)",
	informacao = "Adicionando em Dólar (USD)"
)
public class MenuAdicionarMoedaDolar extends dev.anthhyo.console.Menu {

	@Override
	public void print() {
		printBase();

		double valor = new ConsoleIO().getDouble("Entre com o valor:", "Valor é invalido! digite apenas numeros.");

		Main.COFRINHO.adicionar(new Dolar(valor));

		ConsoleIO.printSucesso("Dólar adicionado com sucesso!");
	}

}

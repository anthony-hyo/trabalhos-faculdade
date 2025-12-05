package dev.anthhyo.utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIO {

	private final Scanner scanner = new Scanner(System.in);

	public static void printHeader(String texto) {
		System.out.printf("%s%s%s                    %s                    %s%n", Texto.BG_BLUE, Texto.BOLD, Texto.BRIGHT_WHITE, texto, Texto.RESET);
	}

	public static void printTitulo(String texto) {
		System.out.printf("%s%s>> %s%s%n", Texto.ITALIC, Texto.BRIGHT_BLUE, texto, Texto.RESET);
	}

	public static void printOpcao(String text, String descricao) {
		System.out.printf("%s%s%s - %s%n", Texto.BOLD, text, Texto.RESET, descricao);
	}

	public static void printOpcao(int id, String descricao) {
		System.out.printf("%s%d%s - %s%n", Texto.BOLD, id, Texto.RESET, descricao);
	}

	public static void printSucesso(String texto) {
		System.out.printf("%s%s%s %s %s%n", Texto.BG_BRIGHT_GREEN, Texto.BOLD, Texto.BRIGHT_WHITE, texto, Texto.RESET);
	}

	public static void printOpcaoInvalida(String texto) {
		System.out.printf("%s%s%s%s%n", Texto.BOLD, Texto.BRIGHT_RED, texto, Texto.RESET);
	}

	public static void printOpcaoInvalida() {
		printOpcaoInvalida("Opção inválida.");
	}

	public String getString(String mensagem, String mensagemErro) {
		try {
			System.out.printf("%s: ", mensagem);

			return scanner.next();
		} catch (InputMismatchException e) {
			ConsoleIO.printOpcaoInvalida(mensagemErro);

			scanner.nextLine();

			return getString(mensagem, mensagemErro);
		}
	}

	public double getDouble(String mensagem, String mensagemErro) {
		try {
			System.out.printf("%s: ", mensagem);

			return scanner.nextDouble();
		} catch (InputMismatchException e) {
			ConsoleIO.printOpcaoInvalida(mensagemErro);

			scanner.nextLine();

			return getDouble(mensagem, mensagemErro);
		}
	}

	public Integer getInt(String mensagem, String mensagemErro) {
		try {
			System.out.printf("%s ", mensagem);

			return scanner.nextInt();
		} catch (InputMismatchException e) {
			ConsoleIO.printOpcaoInvalida(mensagemErro);

			scanner.nextLine();

			return getInt(mensagem, mensagemErro);
		}
	}

}

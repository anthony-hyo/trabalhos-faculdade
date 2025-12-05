package dev.anthhyo.utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Entrada e Saída de console com validação e estilo
 */
public class ConsoleIO {

	private final Scanner scanner = new Scanner(System.in);

	/**
	 * Imprime um cabeçalho com {@link Texto#BOLD}
	 * com a
	 * cor de fundo {@link Texto#BG_BLUE}
	 * e
	 * cor de texto {@link Texto#BRIGHT_WHITE}
	 *
	 * @param texto O texto a ser exibido
	 */
	public static void printHeader(String texto) {
		System.out.printf("%s%s%s                    %s                    %s%n", Texto.BG_BLUE, Texto.BOLD, Texto.BRIGHT_WHITE, texto, Texto.RESET);
	}

	/**
	 * Imprime um título com texto {@link Texto#ITALIC}
	 * com cor de texto {@link Texto#BRIGHT_BLUE}
	 *
	 * @param texto O texto a ser exibido
	 */
	public static void printTitulo(String texto) {
		System.out.printf("%s%s>> %s%s%n", Texto.ITALIC, Texto.BRIGHT_BLUE, texto, Texto.RESET);
	}

	/**
	 * Imprime uma opção com {@link Texto#BOLD}
	 *
	 * @param texto     O texto a ser exibido
	 * @param descricao A descricao a ser exibida
	 */
	public static void printOpcao(String texto, String descricao) {
		System.out.printf("%s%s%s - %s%n", Texto.BOLD, texto, Texto.RESET, descricao);
	}

	/**
	 * Imprime uma opção com {@link Texto#BOLD}
	 *
	 * @param id A id a ser exibida
	 * @param descricao A descricao a ser exibida
	 */
	public static void printOpcao(int id, String descricao) {
		System.out.printf("%s%d%s - %s%n", Texto.BOLD, id, Texto.RESET, descricao);
	}

	/**
	 * Imprime uma mensagem de sucesso com {@link Texto#BOLD}
	 * com a
	 * cor de fundo {@link Texto#BG_BRIGHT_GREEN}
	 * e
	 * cor de texto {@link Texto#BRIGHT_WHITE}
	 *
	 * @param texto O texto a ser exibido
	 */
	public static void printSucesso(String texto) {
		System.out.printf("%s%s%s %s %s%n", Texto.BG_BRIGHT_GREEN, Texto.BOLD, Texto.BRIGHT_WHITE, texto, Texto.RESET);
	}

	/**
	 * Imprime uma mensagem de opção inválida com {@link Texto#BOLD}
	 * com a
	 * cor de texto {@link Texto#BRIGHT_RED}
	 *
	 * @param texto O texto a ser exibido
	 */
	public static void printOpcaoInvalida(String texto) {
		System.out.printf("%s%s%s%s%n", Texto.BOLD, Texto.BRIGHT_RED, texto, Texto.RESET);
	}

	/**
	 * Imprime uma mensagem "Opção inválida." com {@link Texto#BOLD}
	 * com a
	 * cor de texto {@link Texto#BRIGHT_RED}
	 */
	public static void printOpcaoInvalida() {
		printOpcaoInvalida("Opção inválida.");
	}

	/**
	 * Pega um valor do tipo double do console
	 *
	 * @param mensagem A mensagem a ser exibida ao usuário.
	 * @param mensagemErro A mensagem a ser exibida em caso de entrada inválida.
	 *
	 * @return O valor pego do console.
	 */
	public double getDouble(String mensagem, String mensagemErro) {
		try {
			System.out.printf("%s ", mensagem);

			return scanner.nextDouble();
		} catch (InputMismatchException e) {
			ConsoleIO.printOpcaoInvalida(mensagemErro);

			scanner.nextLine();

			return getDouble(mensagem, mensagemErro);
		}
	}

	/**
	 * Pega um valor do tipo int do console
	 *
	 * @param mensagem     A mensagem a ser exibida ao usuário.
	 * @param mensagemErro A mensagem a ser exibida em caso de entrada inválida.
	 * @return O valor pego do console.
	 */
	public int getInt(String mensagem, String mensagemErro) {
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

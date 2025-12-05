package dev.anthhyo.utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIO {

	private final Scanner scanner = new Scanner(System.in);
	
	public static void printHeader(String texto) {
		System.out.printf("%s%s%s                    %s                    %s%n", Texto.BG_BRIGHT_PURPLE, Texto.BOLD, Texto.BLACK, texto, Texto.RESET);
	}
	
	public static void printTitulo(String texto) {
		System.out.printf("%s%s>> %s%s%n", Texto.ITALIC, Texto.BRIGHT_PURPLE, texto, Texto.RESET);
	}
	
	public static void printOpcao(int id, String descricao) {
		System.out.println(Texto.BOLD + id + Texto.RESET + " - " + descricao);
	}

	public int getString(String mensagem, String mensagemErro) {
		return getInt(mensagem, mensagemErro, false);
	}

	public String getString(String mensagem, String mensagemErro, boolean temError) {
		try {
			if (!temError) {
				System.out.printf("%s: ", mensagem);
			}

			return scanner.next();
		} catch (InputMismatchException e) {
			System.out.printf("%s: ", mensagemErro);

			scanner.nextLine();

			return getString(mensagem, mensagemErro, true);
		}
	}

	public int getDouble(String mensagem, String mensagemErro) {
		return getInt(mensagem, mensagemErro, false);
	}

	public double getDouble(String mensagem, String mensagemErro, boolean temError) {
		try {
			if (!temError) {
				System.out.printf("%s: ", mensagem);
			}

			return scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.out.printf("%s: ", mensagemErro);

			scanner.nextLine();

			return getDouble(mensagem, mensagemErro, true);
		}
	}

	public int getInt(String mensagem, String mensagemErro) {
		return getInt(mensagem, mensagemErro, false);
	}

	public int getInt(String mensagem, String mensagemErro, boolean temError) {
		try {
			if (!temError) {
				System.out.printf("%s ", mensagem);
			}

			return scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.printf("%s ", mensagemErro);

			scanner.nextLine();

			return getInt(mensagem, mensagemErro, true);
		}
	}

}

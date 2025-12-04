package dev.anthhyo;

import dev.anthhyo.utilidades.ScannerArgs;

import java.util.Scanner;

public class Main {

	private static final ScannerArgs scanner = new ScannerArgs();

	public static void main(String[] args) {
		scanner.getInt("Valor", "Digite novamente");
	}

}
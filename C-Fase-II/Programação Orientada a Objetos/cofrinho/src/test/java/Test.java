import dev.anthhyo.utilidades.Texto;

public class Test {

	public static void main(String[] args) {

		// ===============================
		// Cores normais
		// ===============================
		System.out.println(Texto.BLACK + "BLACK" + Texto.RESET);
		System.out.println(Texto.RED + "RED" + Texto.RESET);
		System.out.println(Texto.GREEN + "GREEN" + Texto.RESET);
		System.out.println(Texto.YELLOW + "YELLOW" + Texto.RESET);
		System.out.println(Texto.BLUE + "BLUE" + Texto.RESET);
		System.out.println(Texto.PURPLE + "PURPLE" + Texto.RESET);
		System.out.println(Texto.CYAN + "CYAN" + Texto.RESET);
		System.out.println(Texto.WHITE + "WHITE" + Texto.RESET);

		System.out.println();

		// ===============================
		// Cores brilhantes
		// ===============================
		System.out.println(Texto.BRIGHT_BLACK + "BRIGHT_BLACK" + Texto.RESET);
		System.out.println(Texto.BRIGHT_RED + "BRIGHT_RED" + Texto.RESET);
		System.out.println(Texto.BRIGHT_GREEN + "BRIGHT_GREEN" + Texto.RESET);
		System.out.println(Texto.BRIGHT_YELLOW + "BRIGHT_YELLOW" + Texto.RESET);
		System.out.println(Texto.BRIGHT_BLUE + "BRIGHT_BLUE" + Texto.RESET);
		System.out.println(Texto.BRIGHT_PURPLE + "BRIGHT_PURPLE" + Texto.RESET);
		System.out.println(Texto.BRIGHT_CYAN + "BRIGHT_CYAN" + Texto.RESET);
		System.out.println(Texto.BRIGHT_WHITE + "BRIGHT_WHITE" + Texto.RESET);

		System.out.println();

		// ===============================
		// Fundos normais
		// ===============================
		System.out.println(Texto.BG_BLACK + Texto.WHITE + " BG_BLACK " + Texto.RESET);
		System.out.println(Texto.BG_RED + Texto.WHITE + " BG_RED " + Texto.RESET);
		System.out.println(Texto.BG_GREEN + Texto.BLACK + " BG_GREEN " + Texto.RESET);
		System.out.println(Texto.BG_YELLOW + Texto.BLACK + " BG_YELLOW " + Texto.RESET);
		System.out.println(Texto.BG_BLUE + Texto.WHITE + " BG_BLUE " + Texto.RESET);
		System.out.println(Texto.BG_PURPLE + Texto.WHITE + " BG_PURPLE " + Texto.RESET);
		System.out.println(Texto.BG_CYAN + Texto.BLACK + " BG_CYAN " + Texto.RESET);
		System.out.println(Texto.BG_WHITE + Texto.BLACK + " BG_WHITE " + Texto.RESET);

		System.out.println();

		// ===============================
		// Fundos brilhantes
		// ===============================
		System.out.println(Texto.BG_BRIGHT_BLACK + Texto.WHITE + " BG_BRIGHT_BLACK " + Texto.RESET);
		System.out.println(Texto.BG_BRIGHT_RED + Texto.BLACK + " BG_BRIGHT_RED " + Texto.RESET);
		System.out.println(Texto.BG_BRIGHT_GREEN + Texto.BLACK + " BG_BRIGHT_GREEN " + Texto.RESET);
		System.out.println(Texto.BG_BRIGHT_YELLOW + Texto.BLACK + " BG_BRIGHT_YELLOW " + Texto.RESET);
		System.out.println(Texto.BG_BRIGHT_BLUE + Texto.WHITE + " BG_BRIGHT_BLUE " + Texto.RESET);
		System.out.println(Texto.BG_BRIGHT_PURPLE + Texto.WHITE + " BG_BRIGHT_PURPLE " + Texto.RESET);
		System.out.println(Texto.BG_BRIGHT_CYAN + Texto.BLACK + " BG_BRIGHT_CYAN " + Texto.RESET);
		System.out.println(Texto.BG_BRIGHT_WHITE + Texto.BLACK + " BG_BRIGHT_WHITE " + Texto.RESET);

		System.out.println();

		// ===============================
		// Estilos
		// ===============================
		System.out.println(Texto.BOLD + "BOLD - Negrito" + Texto.RESET);
		System.out.println(Texto.ITALIC + "ITALIC - Itálico (se suportado)" + Texto.RESET);
		System.out.println(Texto.UNDERLINE + "UNDERLINE - Sublinhado" + Texto.RESET);
		System.out.println(Texto.INVERT + "INVERT - Cores invertidas" + Texto.RESET);
		System.out.println(Texto.STRIKETHROUGH + "STRIKETHROUGH - Riscado" + Texto.RESET);

		System.out.println();

		// ===============================
		// Combinações
		// ===============================
		System.out.println(
			Texto.BG_PURPLE + Texto.BRIGHT_WHITE + Texto.BOLD +
				" Texto estilizado completo " +
				Texto.RESET
		);
	}

}

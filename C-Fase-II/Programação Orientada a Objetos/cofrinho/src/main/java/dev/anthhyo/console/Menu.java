package dev.anthhyo.console;

import dev.anthhyo.Main;
import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.interfaces.IMenu;
import dev.anthhyo.utilidades.ConsoleIO;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

public abstract class Menu implements IMenu {

	protected String header;

	protected String titulo;

	/**
	 * Valida a opção escolhida pelo
	 * usuário e retorna MenuOpcao correspondente
	 */
	private static MenuOpcao validarOpcao(dev.anthhyo.annotation.Menu menu) {
		while (true) {
			int selecionado = Main.CONSOLE.getInt("Escolha a opção desejada: ", "Por favor digite apenas números");

			Optional<MenuOpcao> menuOpcaoOptional = Arrays.stream(menu.opcoes()).filter(opcao -> opcao.id() == selecionado).findAny();

			if (menuOpcaoOptional.isEmpty()) {
				ConsoleIO.printOpcaoInvalida();
				continue;
			}

			return menuOpcaoOptional.get();
		}
	}

	/**
	 * Exibe menu e processa navegação
	 */
	@Override
	public void print() {
		// Exibe cabeçalho padrão
		dev.anthhyo.annotation.Menu menu = printBase();

		//Exibe opções baseadas na annotation
		for (MenuOpcao opcoe : menu.opcoes()) {
			//Acessa annotation para obter título e exibe
			ConsoleIO.printOpcao(opcoe.id(), opcoe.cls().getAnnotation(dev.anthhyo.annotation.Menu.class).titulo());
		}

		// Instancia e executa menu selecionado via reflexão
		try {
			//Valida entrada do usuário
			//Cria instância da classe selecionada dinamicamente   
			//Executa método print() da instância criada
			validarOpcao(menu).cls().getDeclaredConstructor().newInstance().print();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException |
		         NoSuchMethodException e) {
			ConsoleIO.printOpcaoInvalida(e.getCause().getMessage());
		}
	}

	/**
	 * Exibe cabeçalho e título usando annotations.
	 *
	 * @return {@link dev.anthhyo.annotation.Menu}
	 * @throws UnsupportedOperationException se annotation @Menu estiver ausente
	 */
	protected dev.anthhyo.annotation.Menu printBase() {
		Class<? extends Menu> cls = this.getClass();

		if (!cls.isAnnotationPresent(dev.anthhyo.annotation.Menu.class)) {
			throw new UnsupportedOperationException("Missing @Menu annotation");
		}

		//Pega annotation
		dev.anthhyo.annotation.Menu menu = cls.getAnnotation(dev.anthhyo.annotation.Menu.class);

		this.header = menu.header();
		this.titulo = menu.informacao();

		//Header pode ser suprimido via "none"
		if (!this.header.equals("none")) {
			ConsoleIO.printHeader(this.header);
		}

		//Todo menu tem título
		ConsoleIO.printTitulo(this.titulo);

		return menu;
	}

}

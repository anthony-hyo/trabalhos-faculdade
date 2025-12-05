package dev.anthhyo.console;

import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.interfaces.IMenu;
import dev.anthhyo.utilidades.ConsoleIO;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

public abstract class Menu implements IMenu {

	protected String header;

	protected String titulo;

	private static MenuOpcao validarOpcao(dev.anthhyo.annotation.Menu menu) {
		while (true) {
			int selecionado = new ConsoleIO().getInt("Escolha a opção desejada: ", "Por favor digite apenas números");

			Optional<MenuOpcao> menuOpcaoOptional = Arrays.stream(menu.opcoes()).filter(opcao -> opcao.id() == selecionado).findAny();

			if (menuOpcaoOptional.isEmpty()) {
				ConsoleIO.printOpcaoInvalida();
				continue;
			}

			return menuOpcaoOptional.get();
		}
	}

	@Override
	public void print() {
		dev.anthhyo.annotation.Menu menu = printBase();

		for (MenuOpcao opcoe : menu.opcoes()) {
			ConsoleIO.printOpcao(opcoe.id(), opcoe.cls().getAnnotation(dev.anthhyo.annotation.Menu.class).titulo());
		}

		try {
			validarOpcao(menu).cls().getDeclaredConstructor().newInstance().print();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException |
		         NoSuchMethodException e) {
			ConsoleIO.printOpcaoInvalida(e.getCause().getMessage());
		}
	}

	protected dev.anthhyo.annotation.Menu printBase() {
		Class<? extends Menu> cls = this.getClass();

		if (!cls.isAnnotationPresent(dev.anthhyo.annotation.Menu.class)) {
			throw new UnsupportedOperationException("Missing @Menu annotation");
		}

		dev.anthhyo.annotation.Menu menu = cls.getAnnotation(dev.anthhyo.annotation.Menu.class);

		this.header = menu.header();
		this.titulo = menu.informacao();

		if (!this.header.equals("none")) {
			ConsoleIO.printHeader(this.header);
		}

		ConsoleIO.printTitulo(this.titulo);

		return menu;
	}

}

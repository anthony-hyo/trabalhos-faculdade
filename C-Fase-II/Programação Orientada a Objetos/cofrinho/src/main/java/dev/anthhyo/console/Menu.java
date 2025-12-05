package dev.anthhyo.console;

import dev.anthhyo.annotation.MenuOpcao;
import dev.anthhyo.interfaces.IMenu;
import dev.anthhyo.utilidades.ConsoleIO;

import java.util.Arrays;

public abstract class Menu implements IMenu {

	protected String header;

	protected String titulo;

	public IMenu opcao(int id, Class<? extends IMenu> menuClass) {
		if (!menuClass.isAnnotationPresent(dev.anthhyo.annotation.Menu.class)) {
			throw new UnsupportedOperationException("Missing @Menu annotation");
		}

		dev.anthhyo.annotation.Menu menu = menuClass.getAnnotation(dev.anthhyo.annotation.Menu.class);

		this.header = menu.header();

		return this;
	}

	@Override
	public void print() {
		Class<? extends Menu> cls = this.getClass();

		if (!cls.isAnnotationPresent(dev.anthhyo.annotation.Menu.class)) {
			throw new UnsupportedOperationException("Missing @Menu annotation");
		}

		dev.anthhyo.annotation.Menu menu = cls.getAnnotation(dev.anthhyo.annotation.Menu.class);

		this.header = menu.header();
		this.titulo = menu.titulo();

		if (!this.header.equals("none")) {
			ConsoleIO.printHeader(this.header);
		}
		
		ConsoleIO.printTitulo(this.titulo);

		for (MenuOpcao opcoe : menu.opcoes()) {
			ConsoleIO.printOpcao(opcoe.id(), opcoe.descricao());
		}

		int selecionado = new ConsoleIO().getInt(">", "Digite novamente");

		if (Arrays.stream(menu.opcoes()).noneMatch(opcao -> opcao.id() == selecionado)) {
			System.out.println("Opcao Invalida");
			return;
		}

		opcaoSelecionada(selecionado);
	}

}

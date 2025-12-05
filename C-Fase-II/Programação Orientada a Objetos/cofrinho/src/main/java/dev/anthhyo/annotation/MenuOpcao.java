package dev.anthhyo.annotation;

import dev.anthhyo.interfaces.IMenu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MenuOpcao {

	int id();

	Class<? extends IMenu> cls();

}

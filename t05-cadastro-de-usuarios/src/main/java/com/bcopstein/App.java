package com.bcopstein;

import java.io.IOException;
import java.util.Iterator;

public class App {
	public static void main(String[] args) {
		try {
			CadastroUsuarios cd = new CadastroUsuarios();
			

		} catch (IOException e) {
			System.out.println("Arquivo de dados não encontrado!!");
			System.exit(0);
		}
	}

}

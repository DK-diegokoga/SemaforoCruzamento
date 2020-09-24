package view;

import java.util.concurrent.Semaphore;

import controller.Carrinhos;

public class Principal {

	public static void main(String[] args) {

		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);

		for (int i = 0; i < 4; i++) {
			Carrinhos carrito = new Carrinhos(i + 1, semaforo);
			carrito.start();
		}
	}
}

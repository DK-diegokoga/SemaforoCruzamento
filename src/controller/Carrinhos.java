package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Carrinhos extends Thread {
	private String[] sentido = { "Norte para o Sul", "Sul para o Norte", "Leste para o Oeste", "Oeste para o Leste" };
	private String[] sentidos = { "Sul", "Norte", "Oeste", "Leste" };
	private static int sentido1 = 0;
	private Semaphore semaforo;
	private int idCarro;
	private static int ordem = 1;

	public Carrinhos(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			Movimentando();
			cruzamento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void Movimentando() {
		Random deslocamento = new Random();
		int disTotal = 100;
		int disPercorrida = 0;
		int tempo = 100;
		int ram;
		System.out.println("#" + idCarro + " foi o " + ordem + ".º a começar a travessia, do " + sentido[sentido1]);
		ordem++;
		while (disPercorrida < disTotal) {
			ram = deslocamento.nextInt(10) + 20;
			disPercorrida += ram;

			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idCarro + " já percorreu " + disPercorrida + "m. ");
		}
	}

	private void cruzamento() {
		System.out.println("#" + idCarro + " cruzou a avenida e chegou no " + sentidos[sentido1]);
		sentido1++;
	}
}

package com.project.accesoparque;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parque {
    private final Puerta[] puertas;
    private int codAcceso = 1;

    public Parque(int numeroPuertas) {
        puertas = new Puerta[numeroPuertas];
        for (int i = 0; i < numeroPuertas; i++) {
            puertas[i] = new Puerta(i + 1);
        }
    }

    public void iniciacióndeSimulacion() {
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 visitantes

        for (int i = 0; i < 10; i++) {
            final int visitanteId = i + 1;
            executor.execute(() -> {
                Visitante visitante = new Visitante(visitanteId, CodigoDeAcceso());
                accesoParque(visitante);
            });
        }

        executor.shutdown();
    }

    private synchronized int CodigoDeAcceso() {
        return codAcceso++;
    }

    private void accesoParque(Visitante visitante) {
        System.out.println("El Visitante " + visitante.getId() + " con código " + visitante.getCodigoAcceso() + " intentando acceder al parque.");
        for (Puerta puerta : puertas) {
            if (puerta.acceder(visitante)) {
                return;
            }
        }
        System.out.println("El Visitante " + visitante.getId() + " se encuentra  esperando para entrar a la atracción.");
    }
}

package com.project.accesoparque;

import java.util.concurrent.Semaphore;

public class AtraccionParque {
    private final String nombre;
    private final Semaphore semaphore;

    public AtraccionParque(String nombre, int capacidad) {
        this.nombre = nombre;
        this.semaphore = new Semaphore(capacidad); // Capacidad de la atracción
    }

    public void acceso(Visitante visitante) {
        try {
            semaphore.acquire();
            System.out.println("Visitante " + visitante.getId() + " está accediendo:  " + nombre);
            // Simular tiempo en la atracción
            Thread.sleep(2000);
            System.out.println("Visitante " + visitante.getId() + " ha finalizado la atracción " + nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}


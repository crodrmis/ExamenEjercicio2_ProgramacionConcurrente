package com.project.accesoparque;

import java.util.concurrent.Semaphore;

public class Puerta {
    private final int id;
    private final Semaphore semaforo;
    public Puerta(int id) {
        this.id = id;
        this.semaforo = new Semaphore(1); // Solo una persona puede acceder a la vez
    }

    public boolean acceder(Visitante visitante) {
        if (semaforo .tryAcquire()) {
            try {
                System.out.println("Visitante " + visitante.getId() + " accediendo a través de la puerta " + id);
                // Simular tiempo de acceso
                Thread.sleep(1000);
                System.out.println("Visitante " + visitante.getId() + " ha accedido a la puerta " + id);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaforo .release();
            }
            return true;
        }
        return false;
    }
}

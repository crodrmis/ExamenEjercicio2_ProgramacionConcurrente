package com.project.accesoparque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class accesoparqueApplication {

    public static void main(String[] args) {
        Parque parque = new Parque(3); // 3 puertas de acceso
        parque.iniciacióndeSimulacion();
        SpringApplication.run(accesoparqueApplication.class, args);
    }

}

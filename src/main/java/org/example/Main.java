package org.example;

import org.example.dtos.Cliente;
import org.example.threads.ThreadCajera;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        List<Cliente>clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2 }));
        clientes.add(new Cliente("Cliente 2", new int[] { 1, 1, 5, 1, 1 }));
        clientes.add(new Cliente("Cliente 3", new int[] { 5, 3, 1, 5, 2 }));

        long init = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < clientes.size(); i ++) {
            executor.execute(new ThreadCajera("cajera " + i, clientes.get(i), init));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Espero a que terminen de ejecutarse todos los procesos para pasar a las siguientes instrucciones
        }

        long fin = System.currentTimeMillis();
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
    }
}

package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ArrayList<Client> clients = new ArrayList<>(){{
            add(new Client("Cliente 1", new int[] { 2, 2, 1, 5, 2 }));
            add(new Client("Cliente 2", new int[] { 1, 1, 5, 1, 1 }));
            add(new Client("Cliente 3", new int[] { 5, 3, 1, 5, 2 }));
        }};

        ArrayList<Cashier> cashiers = new ArrayList<>(){{
            add(new Cashier("Ana"));
            add(new Cashier("Paca"));
            add(new Cashier("Noa"));
        }};

        long init = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < clients.size(); i ++) {
            executor.execute(new Shop(clients.get(i), cashiers.get(i), init));
        }

        executor.shutdown();
    }
}

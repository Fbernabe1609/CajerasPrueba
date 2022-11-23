package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop {

    static int position = 0;
    static boolean close = false;
    static ArrayList<Cashier> cashiers = new ArrayList<>();
    static ArrayList<Thread> threads = new ArrayList<>();
    static ArrayList<Client> clients = new ArrayList<>();

    public static void Shopping() {
        createClients();
        int numberCashiers = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numberCashiers);
        openShop();
        chargeCustomers(numberCashiers, executor);
        if (close) {
            closeShop();
        }
    }

    public static void openShop() {
        System.out.println("Tienda abierta.\n");
    }

    public static void chargeCustomers(int numberCashiers, ExecutorService executor) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < numberCashiers; i++) {
            cashiers.add(new Cashier(String.valueOf(i), clients.get(i), startTime));
        }
        for (position = 0; position < numberCashiers; position++) {
            threads.add(cashiers.get(position));
        }
        for (Thread thread : threads) {
            executor.execute(thread);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            close = true;
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void closeShop() {
        System.out.println("\nCerrando tienda.");
    }

    public static void createClients() {
        int numberClients = (int) (Math.random() * 10 + 1);
        System.out.println(numberClients);
        for (int i = 0; i < numberClients; i++) {
            int randomAmountShoppingBasket = (int) (Math.random() * 10 + 1);
            ArrayList<Integer> products = new ArrayList<>();
            for (int j = 0; j < randomAmountShoppingBasket; j++) {
                products.add(randomProduct());
            }
            clients.add(new Client("Cliente " + i, products));
        }
    }

    public static int randomProduct() {
        return (int) (Math.random() * 10 + 1);
    }
}

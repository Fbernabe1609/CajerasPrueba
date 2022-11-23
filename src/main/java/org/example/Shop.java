package org.example;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Shop implements Emojis {

    static int position = 2;
    static int numberClients = 0;
    static boolean close = false;
    static ArrayList<Cashier> cashiers = new ArrayList<>();
    static ArrayList<Client> clients = new ArrayList<>();

    public static void Shopping() {

        int numberCashiers = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numberCashiers);

        createClients();
        openShop();

        System.out.println("Número de clientes: " + numberClients + "\n");

        chargeCustomers(numberCashiers, executor);

        if (close) {

            closeShop();
        }
    }

    public static void openShop() {

        System.out.println(PARTY_FACE + "Tienda abierta" + PARTY_FACE + ".");
    }

    public static void chargeCustomers(int numberCashiers, ExecutorService executor) {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numberCashiers; i++) {

            cashiers.add(new Cashier(String.valueOf(i), clients.get(i), startTime));
        }

        for (int i = 0; i < numberCashiers; i++) {

            executor.execute(cashiers.get(i));
        }

        executor.shutdown();

        try {

            close = executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }
    }

    public static void closeShop() {

        System.out.println("\n" + LOUDLY_CRYING_FACE + "Tienda cerrada" + LOUDLY_CRYING_FACE + ".");
    }

    public static void createClients() {

        totalNumberClients();
        for (int i = 0; i < numberClients; i++) {
            int randomAmountShoppingBasket = (int) (Math.random() * 10 + 1);
            ArrayList<Integer> products = new ArrayList<>();
            for (int j = 0; j < randomAmountShoppingBasket; j++) {
                products.add(randomProduct());
            }
            clients.add(new Client("Cliente " + i, products));
        }
    }

    public static void totalNumberClients() {

        while (numberClients < 3) {
            numberClients = (int) (Math.random() * ((10 - 3 + 1) + 3));
        }
    }

    public static int randomProduct() {

        return (int) (Math.random() * 10 + 1);
    }
}

package org.example;

public class Cashier extends Thread {
    String cashierName;
    Client client;

    Long waitTime;

    public Cashier(String cashierName, Client client, Long waitTime) {
        this.cashierName = cashierName;
        this.client = client;
        this.waitTime = waitTime;
    }

    public Long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(Long waitTime) {
        this.waitTime = waitTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String name) {
        this.cashierName = name;
    }

    @Override
    public void run() {

        System.out.println("La cajera " + this.cashierName + " comienza ha procesar la compra del cliente " + this.client.getNombre() + " a los: " + (System.currentTimeMillis() - this.waitTime) / 1000 + " segundos.");

        for (int i = 0; i < this.client.getShoppingBasket().size(); i++) {
            this.waitTimeSeconds(client.getShoppingBasket().get(i));
            System.out.println("La cajera " + this.cashierName + " ha procesado el producto " + (i + 1) + " del cliente " + this.client.getNombre() + ". Tiempo: " + (System.currentTimeMillis() - this.waitTime) / 1000 + "s");
        }

        System.out.println("La cajera " + this.cashierName + " ha terminado de procesar al cliente " + this.client.getNombre() + " a los: " + (System.currentTimeMillis() - this.waitTime) / 1000 + " segundos.");
        if (Shop.position < Shop.clients.size()) {
            this.client = Shop.clients.get(Shop.position);
            Shop.position = Shop.position + 1;
            run();
        }
    }

    private void waitTimeSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

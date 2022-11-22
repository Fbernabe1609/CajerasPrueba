package org.example;

public class Cashier extends Thread {
    String cashierName;

    public Cashier(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String name) {
        this.cashierName = name;
    }

    @Override
    public void run() {

//        System.out.println("La cajera " + this.cashier.getCashierName() + " comienza ha procesar la compra del cliente " + this.client.getNombre() + " a los: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "segundos.");
//
//        for (int i = 0; i < this.client.getShoppingBasket().length; i++) {
//            this.waitTimeSeconds(client.getShoppingBasket()[i]);
//            System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.client.getNombre() + ". Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "s");
//        }
//
//        System.out.println("La cajera " + this.cashier.getCashierName()  + " ha terminado de procesar al cliente " + this.client.getNombre() + " a los: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "segundos.");
    }
}

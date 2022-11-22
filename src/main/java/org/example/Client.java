package org.example;

public class Client extends Thread{

    private String name;
    private int [] shoppingBasket;

    public Client(String name, int[] shoppingBasket) {
        this.name = name;
        this.shoppingBasket = shoppingBasket;
    }

    public String getNombre() {
        return name;
    }

    public int[] getShoppingBasket() {
        return shoppingBasket;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public void setShoppingBasket(int[] shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
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

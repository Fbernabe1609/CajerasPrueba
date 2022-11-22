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
}

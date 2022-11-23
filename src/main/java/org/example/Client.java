package org.example;

import java.util.ArrayList;

public class Client {

    private String name;
    private ArrayList<Integer> shoppingBasket;

    public Client(String name, ArrayList<Integer> shoppingBasket) {
        this.name = name;
        this.shoppingBasket = shoppingBasket;
    }

    public String getNombre() {
        return name;
    }

    public ArrayList<Integer> getShoppingBasket() {
        return shoppingBasket;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public void setShoppingBasket(ArrayList<Integer> shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }
}

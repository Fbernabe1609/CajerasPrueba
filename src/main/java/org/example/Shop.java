package org.example;

public class Shop extends Thread{

        private Client client;

        private Cashier cashier;

        private long initialTime;

        public Shop(Client client, Cashier cashier, long time){
            this.client = client;
            this.cashier = cashier;
            this.initialTime = time;
        }

        @Override
        public void run() {

             System.out.println("La cajera " + this.cashier.getCashierName() + " comienza ha procesar la compra del cliente " + this.client.getNombre() + " a los: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "segundos.");

             for (int i = 0; i < this.client.getShoppingBasket().length; i++) {
                this.waitTimeSeconds(client.getShoppingBasket()[i]);
                System.out.println("Procesado el producto " + (i + 1) + " del cliente " + this.client.getNombre() + ". Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "s");
            }

            System.out.println("La cajera " + this.cashier.getCashierName()  + " ha terminado de procesar al cliente " + this.client.getNombre() + " a los: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "segundos.");
        }

        private void waitTimeSeconds(int seconds) {
            try {
                Thread.sleep(seconds * 1000L);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
 }

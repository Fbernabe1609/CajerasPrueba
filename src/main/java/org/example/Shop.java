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

             System.out.println("La cajera " + this.cashier.getName() + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                    + this.client.getNombre() + " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000
                    + "seg");

             for (int i = 0; i < this.client.getShoppingBasket().length; i++) {
                this.esperarXsegundos(client.getShoppingBasket()[i]);
                System.out.println("Procesado el producto " + (i + 1)
                        + " del cliente " + this.client.getNombre() + "->Tiempo: "
                        + (System.currentTimeMillis() - this.initialTime) / 1000
                        + "seg");
            }

            System.out.println("La cajera " + this.cashier.getName()  + " HA TERMINADO DE PROCESAR "
                    + this.client.getNombre() + " EN EL TIEMPO: "
                    + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

        }

        private void esperarXsegundos(int segundos) {
            try {
                Thread.sleep(segundos * 1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
 }

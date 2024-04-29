package org.example.stock_observer;

public class Main {
    public static void main(String[] args) {
        // Créer une instance de Product
        Product watch = new Product("Casio watch ", 10);
        Product handBag = new Product("Coach handBag", 8);

        // Créer des observateurs
        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();

        // Enregistrer les observateurs auprès du produit
        watch.registerObserver(stockManager);
        handBag.registerObserver(supplier);

        // Modifier le niveau de stock et observer les notifications
        watch.setStockLevel(8);
        handBag.setStockLevel(5);


    }

}

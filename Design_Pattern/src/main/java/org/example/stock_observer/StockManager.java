package org.example.stock_observer;

public class StockManager implements Observer {
    @Override
    public void update(Product product) {
        System.out.println("StockManager: Le niveau de stock du produit "
                + product.getName() +  " est maintenant " + product.getStockLevel() + ".");
    }
}

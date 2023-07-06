package main;

import inventory.Product;
import inventory.Inventory;
import inventory.Warehouse;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Inventory inventory = new Inventory();
        Warehouse warehouse = new Warehouse();

        product.productId = 1;
        product.productName = "pencils";
        product.price = 2.0;

        inventory.product = product;
        inventory.quantity = 500;

        warehouse.warehouseId = 1;
        warehouse.warehouseName = "Wherehouse";
        warehouse.inventories = "Placeholder";

        System.out.println("Product ID: " + inventory.product.productId + ", Name: " + inventory.product.productName + ", Price: " + inventory.product.price);
        System.out.println("Inventory Quantity: " + inventory.quantity);
        System.out.println("Warehouse ID: " + warehouse.warehouseId + ", Name:" + warehouse.warehouseName);
    }
}

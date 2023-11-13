package lab6.salesAccounting;

import java.util.LinkedList;
import java.util.Scanner;

public class SalesAccounting {

    private LinkedList<Product> data;
    private float money;

    public SalesAccounting() {
        this.data = new LinkedList<>();
        money = 0;

    }

    public void inputProduct(Product product) {
        data.add(product);
    }

    public void displayProducts() {
        for (Product i : data) {
            i.display();
        }
    }

    public Product mostPopular() {
        Product product = new Product("Null", 0, 0);
        int count = 0;
        for (Product i : data) {
            if (i.getCount() > count) {
                count = i.getCount();
                product = i;
            }
        }
        return product;
    }

    public float getMoney() {
        this.countMoney();
        return money;
    }

    private void countMoney() {
        money = 0;
        for (Product i : data) {
            money += i.getCount() * i.getPrice();
        }
    }

}

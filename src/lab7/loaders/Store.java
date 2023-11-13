package lab7.loaders;

import java.util.ArrayList;

public class Store {
    ArrayList<Integer> products;

    public Store(ArrayList<Integer> list) {
        products = list;
    }

    public Integer takeProduct() {
        System.out.println(products.get(products.size() - 1));
        return products.remove(products.size() - 1);
    }

    public Integer weightOfProduct() {
        return products.get(products.size() - 1);
    }

    public void putProducts(ArrayList<Integer> hands) {
        products.addAll(hands);
        hands.forEach(System.out::println);
        hands.clear();
    }

    public int size() {
        return products.size();
    }
}

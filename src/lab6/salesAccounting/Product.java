package lab6.salesAccounting;

public class Product {
    private String name;
    private float price;
    private int count;

    public Product(String name, float price, int count) {
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public static Product parseProduct(String str) {
        String[] array = str.split(" ");
        if (array.length == 2) {
            try {
                float price = Float.parseFloat(array[1]);
                return new Product(array[0], price);
            } catch (NumberFormatException e) {
                return null;
            }
        } else if (array.length == 3) {
            try {
                float price = Float.parseFloat(array[1]);
                int count = Integer.parseInt(array[2]);
                return new Product(array[0], price, count);
            } catch (NumberFormatException e) {
                return null;
            }
        } else return null;
    }

    public void display() {
        System.out.println(name + " " + price + " " + count);
    }
    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

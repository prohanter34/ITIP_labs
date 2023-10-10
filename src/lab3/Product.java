package lab3;

public class Product {
    private String name;
    private String description;
    private float price;
    private int count;

    public Product(String name, String description, float price, int count) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public void addPrice(float price) {
        this.price += price;
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

    public String getDescription() {
        return description;
    }

    public void setPrice(float price) {
        if (price > 0) {

            this.price = price;
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        if (count >= 0) {

            this.count = count;
        }
    }
}

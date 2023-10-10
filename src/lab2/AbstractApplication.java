package lab2;

public abstract class AbstractApplication {

    private float weight;
    private String name;
    static private int count;

    public AbstractApplication(String name, float weight) {
        this.name = name;
        this.weight = weight;
        count += 1;
    }

    public AbstractApplication() {
        this.name = "lab2.Application";
        this.weight = 0;
        count += 1;
    }
    public void display() {
        System.out.println(name);
        System.out.println(weight);
    }

    public double getWeight() {
        return weight;
    }
    public String getName() {
        return name;
    }
    public static int getCount() {
        return count;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = (float) weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

}

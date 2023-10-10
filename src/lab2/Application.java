package lab2;

public class Application extends AbstractApplication {
    private String producer;
    private String platform;
    private String briefInfo;

    public Application(String name, String producer, String platform, float weight) {
        super(name, weight);
        this.producer = producer;
        this.platform = platform;
        makeBriefInfo();
    }

    public Application() {
        super();
        this.producer = null;
    }

    @Override
    public void display() {
        super.display();
        System.out.println(producer);
        System.out.println(platform);
    }

    public void startMessage() {
        System.out.println("Запускаем приложение");
    }

    public void closeMessage() {
        System.out.println("Закрываем приложение");
    }

    public String getProducer() {
        return producer;
    }

    public String getPlatform() {
        return platform;
    }

    public String getBriefInfo() {
        return briefInfo;
    }
    public void makeBriefInfo() {
        briefInfo = getName() + " " + getProducer() + " " + getWeight();
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}


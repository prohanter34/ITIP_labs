package lab2;

public class WeatherApp extends Application {
    private String trackingPlace;
    private boolean widget;
    public WeatherApp(String name, String producer, String platform, float weight) {
       super(name, producer, platform, weight);
       this.widget = false;
    }

    @Override
    public void startMessage() {
        System.out.println("Звоним метеорологам");
    }

    @Override
    public void closeMessage() {
        System.out.println("Попутного ветра!");
    }

    public void switchWidget() {
        this.widget = !this.widget;
    }

    public String getTrackingPlace() {
        return trackingPlace;
    }
    public void setTrackingPlace(String trackingPlace) {
        this.trackingPlace = trackingPlace;
    }
}

package lab2;

public class GameApp extends Application {
    private String genre;
    private float playedHours;

    public GameApp(String name, String producer, String platform, float weight, String genre) {
        super(name, producer, platform, weight);
        this.genre = genre;
    }

    @Override
    public void startMessage() {
        System.out.println("Приготавливаем джостик");
    }

    @Override
    public void closeMessage() {
        System.out.println("GGWP");
    }

    public String getGenre() {
        return genre;
    }

    public float getPlayedHours() {
        return playedHours;
    }

    public void increasePlayedHours(int hours) {
        this.playedHours += hours;
    }

    public void increasePlayedHours(float hours) {
        this.playedHours += hours;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}


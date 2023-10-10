import lab2.AbstractApplication;
import lab2.GameApp;
import lab2.SocialNetworkApp;
import lab2.WeatherApp;
import lab3.HashTable;

public class Main {
    public static void main(String[] args) {

        WeatherApp weatherApp = new WeatherApp("MYWeather", "microsolid", "windows", 100);
        GameApp game = new GameApp("CS:RUN", "valve", "windows", 20000, "shooter");
        SocialNetworkApp socialNetwork = new SocialNetworkApp("VK", "mail", "android", 100);
        weatherApp.setTrackingPlace("Moscow");
        socialNetwork.authentication("admin");
        System.out.println(weatherApp.getName());
        System.out.println(socialNetwork.getProfileId());
        System.out.println(AbstractApplication.getCount());
        HashTable<String, String> map = new HashTable<>();
        map.put("Иван", "Каравайченко");
        map.put("Иван", "gh");
        map.put("Иван", "kl");
        map.put("ferferfer", "frfrfrfrgr");
        map.put("Матвей", "Коцюба");
        map.put("Артем", "Мокосеев");
        System.out.println(map.size());
        System.out.println(map.size());
    }
}


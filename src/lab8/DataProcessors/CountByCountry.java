package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.HashMap;

@DataProcessor
public class CountByCountry extends CountProcessor {
    @DataProcessor
    public String countByCountry(HashMap<String, People> data) {
        HashMap<String, Integer> map = new HashMap<>();
        data.entrySet().stream().toList().forEach((e) -> {
            String country = e.getValue().getCountry();
            if (map.containsKey(country)) {
                map.put(country, map.get(country) + 1);
            } else {
                map.put(country, 1);
            }
        });
        return convertToString(map);
    }
}

package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@DataProcessor
public class CountProcessor extends lab8.DataProcessors.DataProcessor {

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

    @DataProcessor
    public String countCurrencyAVG(HashMap<String, People> data) {
        float sum = data.entrySet().stream().reduce(0.0f, (x, y) -> {
            return x + y.getValue().getCurrency();
        }, Float::sum);
        return "Currency AVG: " + sum/data.size() + "\n";
    }

    private String convertToString(HashMap<String, Integer> data) {
        StringBuilder output = new StringBuilder();
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().toList();
        for (Map.Entry<String, Integer> entry: list) {
            output.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return output.toString();
    }
}

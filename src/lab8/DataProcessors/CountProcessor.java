package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@DataProcessor
public class CountProcessor extends lab8.DataProcessors.DataProcessor {

    String convertToString(HashMap<String, Integer> data) {
        StringBuilder output = new StringBuilder();
        List<Map.Entry<String, Integer>> list = data.entrySet().stream().toList();
        for (Map.Entry<String, Integer> entry: list) {
            output.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return output.toString();
    }
}

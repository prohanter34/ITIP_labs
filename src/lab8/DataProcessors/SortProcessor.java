package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.*;
import java.util.stream.Collectors;

@DataProcessor
public class SortProcessor extends lab8.DataProcessors.DataProcessor {

    @DataProcessor
    public String sortByCurrency(HashMap<String, People> data) {
        List<Map.Entry<String, People>> list = data.entrySet().stream().sorted((x, y) -> {
            return Float.compare(x.getValue().getCurrency(), y.getValue().getCurrency());
        }).toList();
        return convertToString(list);
    }


    @DataProcessor
    public String sortByCountry(HashMap<String, People> data) {
        List<Map.Entry<String, People>> list = data.entrySet().stream().sorted((x, y) -> {
            return x.getValue().getCountry().compareTo(y.getValue().getCountry());
        }).toList();
        return convertToString(list);
    }

    private String convertToString(List<Map.Entry<String, People>> list) {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, People> entry : list) {
            output.append(entry.getKey()).append(",").append(entry.getValue().toString()).append("\n");
        }
        return output.toString();
    }
}

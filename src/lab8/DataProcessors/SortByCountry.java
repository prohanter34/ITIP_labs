package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DataProcessor
public class SortByCountry extends SortProcessor{
    @DataProcessor
    public String sortByCountry(HashMap<String, People> data) {
        List<Map.Entry<String, People>> list = data.entrySet().stream().sorted((x, y) -> {
            return x.getValue().getCountry().compareTo(y.getValue().getCountry());
        }).toList();
        return convertToString(list);
    }
}

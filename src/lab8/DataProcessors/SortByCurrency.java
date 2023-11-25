package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByCurrency extends SortProcessor {
    @DataProcessor
    public String sortByCurrency(HashMap<String, People> data) {
        List<Map.Entry<String, People>> list = data.entrySet().stream().sorted((x, y) -> {
            return Float.compare(x.getValue().getCurrency(), y.getValue().getCurrency());
        }).toList();
        return convertToString(list);
    }
}

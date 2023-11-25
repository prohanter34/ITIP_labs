package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.HashMap;
@DataProcessor
public class CountCurrencyAVG extends CountProcessor {
    @DataProcessor
    public String countCurrencyAVG(HashMap<String, People> data) {
        float sum = data.entrySet().stream().reduce(0.0f, (x, y) -> {
            return x + y.getValue().getCurrency();
        }, Float::sum);
        return "Currency AVG: " + sum/data.size() + "\n";
    }
}

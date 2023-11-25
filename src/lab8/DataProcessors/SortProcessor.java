package lab8.DataProcessors;

import lab8.DataProcessor;
import lab8.People;

import java.util.*;
import java.util.stream.Collectors;

@DataProcessor
public class SortProcessor extends lab8.DataProcessors.DataProcessor {


    String convertToString(List<Map.Entry<String, People>> list) {
        StringBuilder output = new StringBuilder();
        for (Map.Entry<String, People> entry : list) {
            output.append(entry.getKey()).append(",").append(entry.getValue().toString()).append("\n");
        }
        return output.toString();
    }
}

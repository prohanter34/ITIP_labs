package lab8;

import lab8.DataProcessors.*;
import lab8.DataProcessors.DataProcessor;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataManager {

    private ArrayList<DataProcessor> processors;
    private ExecutorService service;
    private HashMap<String, People> data;
    private String outputData = "";

    public DataManager() {
        this.processors = new ArrayList<>();
        this.service = Executors.newFixedThreadPool(10);
        this.data = new HashMap<>();
    }

    public static void main(String[] args) {
        DataManager manager = new DataManager();
        CountByCountry processor = new CountByCountry();
        SortByCurrency processor1 = new SortByCurrency();
        manager.registerDataProcessor(processor);
        manager.registerDataProcessor(processor1);
        manager.loadData("src/lab8/data.csv");
        manager.processData();
        manager.saveData("src/lab8/newdata.csv");
    }
    public void registerDataProcessor(DataProcessor processor) {
        processors.add(processor);
    }

    public void loadData(String source) {
        File file = new File(source);
        try (FileReader reader = new FileReader(file);) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();

            while (line != null) {

                String[] array = line.split(",");
                try {
                    float currency = Float.parseFloat(array[3]);
                    People people = new People(array[1], array[2], currency, array[4]);
                    data.put(array[0], people);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void processData() {
        ArrayList<Future<String>> futures = new ArrayList<>();
        for (DataProcessor processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.getAnnotation(lab8.DataProcessor.class) != null) {
                    futures.add(service.submit(() -> {
                        try {
                            return (String) method.invoke(processor, data);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            return "";
                        }
                    }));
                }
            }
        }
        for (Future<String> f : futures) {
            try {
                outputData += f.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        service.shutdown();
    }

    public void saveData(String destination) {
        File file = new File(destination);
        
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(outputData + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package lab7;

import lab7.loaders.LoaderRealization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        ArrayList<Integer> stage = new ArrayList<>(Arrays.asList(100, 49, 50, 60, 80, 100, 50, 80, 95));
        LoaderRealization loader = new LoaderRealization(stage);

        service.execute(() -> loader.run(1));
        service.execute(() -> loader.run(2));
        service.execute(() -> loader.run(3));

        service.shutdown();
    }

}
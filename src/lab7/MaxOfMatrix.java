package lab7;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxOfMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 4, 5, 6, 7},
                {1, 3, 4, 5, 6, 7},
                {1, 3, 4, 5, 6, 9},
                {1, 3, 4, 5, 6, 7},
        };
        System.out.println(maxOfMatrix(matrix));
    }

    public static int maxOfMatrix(int[][] matrix) {
        ArrayList<Future<Integer>> futures = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            Future<Integer> future = service.submit(new MaxOfMatrixCallable(matrix[i]));
            futures.add(future);
        }
        int max = 0;
        for (Future<Integer> i : futures) {
            try {
                int num = i.get();
                if (num > max) {
                    max = num;
                }
            } catch (ExecutionException | InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        service.close();
        return max;
    }
}

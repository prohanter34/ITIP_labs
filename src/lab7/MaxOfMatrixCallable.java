package lab7;

import java.util.concurrent.Callable;

public class MaxOfMatrixCallable implements Callable<Integer> {

    private final int[] array;

    public MaxOfMatrixCallable(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() throws Exception {
        int max = 0;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}

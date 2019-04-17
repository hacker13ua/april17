package org.esurovskiy;


import java.util.Arrays;
import java.util.concurrent.Callable;

public class SummingRowTask implements Callable<Integer> {
    int[] row;

    public SummingRowTask(final int[] row) {
        this.row = row;
    }

    public Integer call() throws Exception {
        int sum = 0;
        for (final int element : row) {
            sum += element;
        }
        return sum;
    }
}

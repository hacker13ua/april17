package org.esurovskiy;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SummingRowMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[][] array = generateArray();
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);

        List<SummingRowTask> tasks = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            SummingRowTask task = new SummingRowTask(array[i]);
            tasks.add(task);
        }

        List<Future<Integer>> futures = executorService.invokeAll(tasks);
        int sum = 0;
        for (final Future<Integer> future : futures) {
            sum += future.get();
        }

        executorService.shutdown();
        System.out.println("SUM=" + sum);
    }

    private static int[][] generateArray() {
        int[][] array = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                array[i][j] = 100;
            }
        }
        return array;
    }
}

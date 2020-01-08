package timer;

import tiq.array.RemoveDuplicatesFromSortedArray;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution
            = new RemoveDuplicatesFromSortedArray();

        long startTime = System.nanoTime();
        for (int i=0; i<100000; i++) {
            solution.run();
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // 1 second = 1_000_000_000 nanoseconds
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;

        System.out.println("--- " + elapsedTimeInSecond + " seconds ---");
    }
}
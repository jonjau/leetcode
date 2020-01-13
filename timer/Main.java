package timer;

import static tiq.array.BuySellStock2.run;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        int repeats = 100_000;
        System.out.println(run());
        System.out.println("Now running " + repeats + " times:");
        long startTime = System.nanoTime();
        for (int i=0; i<repeats; i++) {
            run();
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        // 1 second = 1_000_000_000 nanoseconds
        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;

        System.out.println("--- " + elapsedTimeInSecond + " seconds ---");
    }
}
package timer;

import static tiq.string.ReverseString.run;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        int repeats = 1;
        System.out.println("Now running " + repeats + " time(s):");
        for (int i=0; i<repeats; i++) {
            long startTime = System.nanoTime();
            tiq.string.ReverseString.run();
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            // 1 second = 1_000_000_000 nanoseconds
            double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;

            System.out.println("--- " + elapsedTimeInSecond + " seconds ---");
        }

    }
}
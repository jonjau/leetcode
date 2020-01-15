package tiq.array.util;

import java.util.Random;

/**
 * RandomIntArray
 */
public class RandomIntArray {

    public static int[] nonnegatives(int n, int max) {
        return nonnegatives(n, max, 123);
    }
    public static int[] nonnegatives(int n, int max, long seed) {
        Random random = new Random(seed);
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = random.nextInt(max);
        }
        return array;
    }
}
package tiq.array.util;

import java.util.Random;

/**
 * RandomIntArray
 */
public class RandomIntArray {

    public static int[] nonnegatives(int n, int max) {
        Random random = new Random(123);
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = random.nextInt(max);
        }
        return array;
    }
}
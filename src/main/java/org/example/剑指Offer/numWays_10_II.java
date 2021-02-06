package org.example.剑指Offer;

public class numWays_10_II {
    public static int numWays(int n) {
        if (n == 0) return 1;
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = (array[i - 1] + array[i - 2]) % 1000000007;
        }
        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(100));
    }
}

package org.example.剑指Offer;

public class printNumbers_17 {
    public static int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = printNumbers(2);
        System.out.println();
    }
}

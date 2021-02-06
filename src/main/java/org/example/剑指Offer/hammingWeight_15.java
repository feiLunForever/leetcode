package org.example.剑指Offer;

public class hammingWeight_15 {
    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            result += (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static int hammingWeight1(int n) {
        int result = 0;
        while (n != 0) {
            result++;
            n = n & (n - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}

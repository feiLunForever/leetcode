package org.example.剑指Offer;

public class lastRemaining_62 {
    public static int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        int x = lastRemaining(n - 1, m);
        return (m + x) % n;
    }

    public static int lastRemaining1(int n, int m) {
        int f = 0;
        for (int i = 2; i < n + 1; i++) {
            f = (m + f) % n;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }
}

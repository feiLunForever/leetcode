package org.example.程序员面试经典;

public class maximum_16_07 {
    public static int maximum(int a, int b) {
        return (int) ((Math.abs((long) a - (long) b) + (long) a + (long) b) / 2);
    }

    public static void main(String[] args) {
        System.out.println(maximum(2, 5));
    }
}

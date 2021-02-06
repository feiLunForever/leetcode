package org.example.算法;

public class KMP {

    public static int kmp(String str, String pattern) {
        // 预处理，生成next数组
        int[] next = getNext(pattern);
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != pattern.charAt(j))
                j = next[j - 1];
            if (str.charAt(i) == pattern.charAt(j))
                j++;
            if (j == pattern.length())
                return i - pattern.length() + 1;
        }
        return -1;
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = next[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "hello";
        String pattern = "ll";
        System.out.println(kmp(str, pattern));
    }
}

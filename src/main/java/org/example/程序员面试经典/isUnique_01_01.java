package org.example.程序员面试经典;

public class isUnique_01_01 {
    public static boolean isUnique(String astr) {
        int result = 0;
        for (int i = 0; i < astr.length(); i++) {
            int move = astr.charAt(i) - 'a';
            if ((result & (1 << move)) != 0) {
                return false;
            } else {
                result |= (1 << move);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("aa"));
    }
}

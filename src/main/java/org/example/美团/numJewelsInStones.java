package org.example.美团;

import java.util.LinkedHashSet;
import java.util.Set;

public class numJewelsInStones {

    public static int numJewelsInStones(String J, String S) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int r = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                r++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

}

package org.example.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class firstUniqChar_50 {
    public static char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> entry : map.entrySet()){
            if(entry.getValue()){
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String str = "aadadaadc";
        System.out.println(firstUniqChar(str));
    }
}

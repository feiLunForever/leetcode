package org.example.栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class isValid_20 {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)) {
                if (stack.isEmpty() || map.get(a) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(a);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }
}

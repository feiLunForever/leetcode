package 面试整理.栈和队列;

import java.util.Stack;

public class isValid_20 {
    public static boolean isValid(String s) {
        if ((s.length() & 1) == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if ('(' == ch || '{' == ch || '[' == ch)
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;
                if (!match(stack.pop(), ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean match(Character left, Character right) {
        if ('(' == left)
            return ')' == right;
        else if ('{' == left)
            return '}' == right;
        else
            return ']' == right;
    }

    public static void main(String[] args) {
        boolean s = isValid("((");
        System.out.println(s);
    }

}

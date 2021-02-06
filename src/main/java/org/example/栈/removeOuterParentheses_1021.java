package org.example.栈;

public class removeOuterParentheses_1021 {

    public static String removeOuterParentheses(String S) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (')' == S.charAt(i)) index--;
            if (index > 0) sb.append(S.charAt(i));
            if ('(' == S.charAt(i)) index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "(()())(())";
        System.out.println(removeOuterParentheses(str));
    }
}

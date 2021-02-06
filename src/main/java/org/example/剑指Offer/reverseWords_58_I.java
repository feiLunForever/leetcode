package org.example.剑指Offer;

public class reverseWords_58_I {
    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            String str = arr[i];
            if (str != null && !"".equals(str)) {
                sb.append(" " + str);
            }
        }
        return sb.length() == 0 ? "" : sb.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}

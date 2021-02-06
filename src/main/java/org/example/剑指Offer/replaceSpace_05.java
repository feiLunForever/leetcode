package org.example.剑指Offer;

public class replaceSpace_05 {
    public static String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static String replaceSpace1(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                array[j++] = '%';
                array[j++] = '2';
                array[j++] = '0';
            }else {
                array[j++] = s.charAt(i);
            }
        }
        return new String(array,0,j);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace1("We are happy."));
    }
}

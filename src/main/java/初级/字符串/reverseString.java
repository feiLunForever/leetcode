package 初级.字符串;

public class reverseString {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        System.out.println();

    }
}

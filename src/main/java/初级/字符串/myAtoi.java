package 初级.字符串;

public class myAtoi {
    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = 0, res = 0, flag = 1;
        while (i < s.length() && ' ' == s.charAt(i))
            i++;
        if (i == s.length()) {
            return 0;
        }
        if ('-' == s.charAt(i))
            flag = -1;
        if ('-' == s.charAt(i) || '+' == s.charAt(i))
            i++;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int r = s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + r;
            i++;
        }
        return res * flag;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoi(s));
    }
}

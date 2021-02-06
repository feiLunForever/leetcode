package 初级.字符串;

public class countAndSay {

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";
        StringBuffer sb = new StringBuffer();
        String str = countAndSay(n - 1);
        int index = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(index)) {
                sb.append(i - index).append(str.charAt(index));
                index = i;
            }
        }
        sb.append(str.length() - index).append(str.charAt(index));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

}

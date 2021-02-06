package 初级.字符串;

public class isAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ret = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ret[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ret[t.charAt(i) - 'a']--;
            if (ret[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";
        System.out.println(isAnagram(s, t));
    }

}

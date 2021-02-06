package 初级.字符串;

public class strStr {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        // 预处理，生成next数组
        int[] next = getNext(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j))
                j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
                j = next[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "aabaabaaf";
        String pattern = "aabaaf";
        System.out.println(strStr(str, pattern));
    }

}

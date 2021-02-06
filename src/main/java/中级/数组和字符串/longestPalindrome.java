package 中级.数组和字符串;

import java.util.Arrays;

public class longestPalindrome {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] array = s.toCharArray();
        int max = 1;
        int begin = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (array[i] != array[j])
                    dp[i][j] = false;
                //j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，
                // 其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
                else if (j - i < 3)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i + 1][j - 1];

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > max) {
                    begin = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

}

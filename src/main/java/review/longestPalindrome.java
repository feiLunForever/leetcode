package review;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        boolean[][] dp = new boolean[s.length()][s.length()];// dp[i][j] 是否有回文
        int begin = 0, max = 0;
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}

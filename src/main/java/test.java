public class test {
    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {
        if (s == null)
            return null;
        int len = s.length();
        if (len < 2)
            return s;
        boolean dp[][] = new boolean[len][len];// 记录s[i,j]是否有回文
        int begin = 0;
        int max = 1;
        // s[i,j]
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) // 首尾不等，则直接判断不是回文
                    dp[i][j] = false;
                else {
                    if (j - i < 3) //j - i < 3 等价于 j - i + 1 < 4，即当子串 s[i..j] 的长度等于 2 或者等于 3 的时候，
                        // 其实只需要判断一下头尾两个字符是否相等就可以直接下结论了。
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];// 根据子串做判定
                }
                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, max);
    }
}
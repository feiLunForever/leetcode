package 中级.数组和字符串;

import java.util.LinkedHashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int rk = -1;
        int n = s.length();
        int ans = 0;
        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            if (i >= 1) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

package 面试整理.数组;

/**
 * 滑动窗口
 */
public class lengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = -1; // s[l,r]  为当前的滑动窗口
        int[] caches = new int[256]; // 缓存，记录出现的次数
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && caches[s.charAt(r + 1)] == 0) { // 滑动窗口下一位=0，代表无重复
                caches[s.charAt(++r)]++; // 出现次数+1
            } else {  // 出现过，则不断左移左边界
                caches[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}

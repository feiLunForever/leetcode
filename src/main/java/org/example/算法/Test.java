package org.example.算法;

public class Test {
    public static int lengthOfLongestSubstring(String s) {
        int[] caches = new int[256]; // 记录字符存在的次数
        int l = 0, r = -1;// s[l,r] 为当前滑动的窗口
        int res = 0;
        while (l < s.length()) {
            if (r + 1 < s.length() && caches[s.charAt(r + 1)] == 0) {// 不越界且下个字符没有出现过
                caches[s.charAt(r + 1)]++;// 出现的次数+1
                r++;// 窗口继续右移右边界
            } else { //出现过
                caches[s.charAt(l)]--;// 此时需要向右滑动，所以此时的左边界出现的次数应该-1
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

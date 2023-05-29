package review;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int[] cache = new int[256];
        int left = 0, right = 0;
        int res = 0;
        while (left < s.length()) {
            if (right + 1 < s.length() && cache[s.charAt(right + 1)] == 0) {
                cache[s.charAt(right + 1)]++;
                right++;
            } else {
                left++;
                cache[s.charAt(left)]--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}

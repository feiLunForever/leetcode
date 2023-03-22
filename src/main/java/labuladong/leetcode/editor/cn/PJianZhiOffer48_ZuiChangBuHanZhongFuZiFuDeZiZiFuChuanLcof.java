/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 滑动窗口</details><br>
 *
 * <div>👍 561, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长不含重复字符的子字符串 LCOF
 *
 * @author DY
 * @date 2023-03-22 11:27:21
 */
public class PJianZhiOffer48_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
	public static void main(String[] args) {
		//测试代码
		Solution solution = new PJianZhiOffer48_ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
	}

	//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int lengthOfLongestSubstring(String s) {
			Set<Character> cache = new HashSet<>();
			int left = 0, right = 0;
			int res = 0;
			while (right < s.length()) {
				Character cur = s.charAt(right);
				while (left < right && cache.contains(cur)) {
					cache.remove(s.charAt(left++));
				}
				res = Math.max(res, right - left + 1);
				cache.add(cur);
				++right;
			}
			return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

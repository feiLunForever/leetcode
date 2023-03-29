/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数学 | 双指针 | 枚举</details><br>
 *
 * <div>👍 527, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 和为s的连续正数序列 LCOF
 *
 * @author DY
 * @date 2023-03-29 18:00:20
 */
public class PJianZhiOffer57II_HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer57II_HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
		System.out.println(Arrays.deepToString(solution.findContinuousSequence(9)));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int left = 1, right = 2;
            int sum = left;
            List<int[]> res = new LinkedList<>();
            while (right < target) {
                sum += right; // 将当前元素加进来
                ++right; // 扩大窗口
                while (sum > target) { // 缩减窗口
                    sum -= left; // 将左边界剔除
                    ++left; // 左边界右移
                }
				if (sum == target && (right - left) > 1) { // 找到一组
					int[] arr = new int[right - left];
					int k = 0;
					for (int i = left; i < right; i++) {
						arr[k++] = i;
					}
					res.add(arr);
				}
            }
            int[][] rs = new int[res.size()][];
            for (int i = 0; i < res.size(); i++) {
                rs[i] = res.get(i);
            }
            return rs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

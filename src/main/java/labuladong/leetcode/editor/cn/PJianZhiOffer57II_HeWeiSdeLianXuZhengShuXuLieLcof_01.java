/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数学 | 双指针 | 枚举</details><br>
 *
 * <div>👍 562, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 和为s的连续正数序列 LCOF
 *
 * @author DY
 * @date 2023-08-08 15:48:01
 */
public class PJianZhiOffer57II_HeWeiSdeLianXuZhengShuXuLieLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer57II_HeWeiSdeLianXuZhengShuXuLieLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int l = 1, r = 1;
            int sum = 0;
            List<int[]> list = new LinkedList<>();
            while (r < target) {
                sum += r++;
                while (sum > target) {
                    sum -= l++;
                }
                if (sum == target && r - l > 1) {
                    int[] temp = new int[r - l];
                    int k = 0;
                    for (int i = l; i < r; i++) {
                        temp[k++] = i;
                    }
                    list.add(temp);
                }
            }
            int[][] res = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

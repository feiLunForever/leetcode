/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>贪心 | 字符串 | 排序</details><br>
 *
 * <div>👍 627, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 把数组排成最小的数 LCOF
 *
 * @author DY
 * @date 2023-04-10 17:42:06
 */
public class PMianShiTi45_BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PMianShiTi45_BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            int n = nums.length;
            String[] arr = new String[n];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(arr, (a, b) -> {
                return (a + b).compareTo(b + a);
            });
            return String.join("", arr);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

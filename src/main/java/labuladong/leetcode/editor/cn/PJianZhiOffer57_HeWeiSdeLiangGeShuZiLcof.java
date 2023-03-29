/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 二分查找</details><br>
 *
 * <div>👍 246, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 和为s的两个数字 LCOF
 *
 * @author DY
 * @date 2023-03-29 12:29:15
 */
public class PJianZhiOffer57_HeWeiSdeLiangGeShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer57_HeWeiSdeLiangGeShuZiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = nums[l] + nums[r];
                if (mid < target) {
                    ++l;
                } else if (mid > target) {
                    --r;
                } else {
                    return new int[]{nums[l], nums[r]};
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 排序</details><br>
 *
 * <div>👍 1087, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 数组中重复的数字 LCOF
 *
 * @author DY
 * @date 2023-02-28 18:59:32
 */
public class P_JianZhiOffer03_ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P_JianZhiOffer03_ShuZuZhongZhongFuDeShuZiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRepeatNumber(int[] nums) {
            int i = 0;
            while (i < nums.length) {
                if (nums[i] == i) {
                    ++i;
                    continue;
                }
                if (nums[nums[i]] == nums[i]) return nums[i];
                swap(nums, i);
            }
            return -1;
        }

        private void swap(int[] nums, int i) {
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
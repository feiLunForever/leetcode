/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>
 *
 * <div>👍 284, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 调整数组顺序使奇数位于偶数前面 LCOF
 *
 * @author DY
 * @date 2023-03-08 12:19:18
 */
public class PJianZhiOffer21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
		System.out.println(solution.exchange(new int[]{1, 2, 3, 4}));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                while (i < j && nums[i] % 2 == 1) ++i;
                while (i < j && nums[j] % 2 == 0) --j;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

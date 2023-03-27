/**
 * <p>Given an integer array <code>nums</code> and an integer <code>k</code>, split <code>nums</code> into <code>k</code> non-empty subarrays such that the largest sum of any subarray is <strong>minimized</strong>.</p>
 *
 * <p>Return <em>the minimized largest sum of the split</em>.</p>
 *
 * <p>A <strong>subarray</strong> is a contiguous part of the array.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [7,2,5,10,8], k = 2
 * <strong>Output:</strong> 18
 * <strong>Explanation:</strong> There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,2,3,4,5], k = 2
 * <strong>Output:</strong> 9
 * <strong>Explanation:</strong> There are four ways to split nums into two subarrays.
 * The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 1000</code></li>
 * <li><code>0 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
 * <li><code>1 &lt;= k &lt;= min(50, nums.length)</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 二分查找 | 动态规划</details><br>
 *
 * <div>👍 780, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Split Array Largest Sum
 *
 * @author DY
 * @date 2023-03-26 17:53:42
 */
public class PFour10_SplitArrayLargestSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour10_SplitArrayLargestSum().new Solution();
		System.out.println(solution.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int k) {
            int l = 0, r = 0;
            for (int num : nums) {
                l = Math.max(l, num);
                r += num;
            }
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                int sum = cal(nums, mid);
                if (sum > k) { // 如果分割数太多，说明「子数组各自的和的最大值」太小，此时需要将「子数组各自的和的最大值」调大
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }

        private int cal(int[] nums, int x) {
            int sum = 0;
            for (int i = 0; i < nums.length; ) {
                int cap = x;
                while (i < nums.length && cap >= nums[i]) {
                    cap -= nums[i];
                    ++i;
                }
                ++sum;
            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

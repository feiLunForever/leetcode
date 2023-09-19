/**
 * <p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>
 *
 * <ul>
 * <li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
 * <li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
 * <li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
 * </ul>
 *
 * <p>You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
 * <strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> nums = [2,2,2,2,2], target = 8
 * <strong>Output:</strong> [[2,2,2,2]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= nums.length &lt;= 200</code></li>
 * <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
 * <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>
 *
 * <div>👍 1754, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 4Sum
 *
 * @author DY
 * @date 2023-09-19 19:14:57
 */
public class POne8_FourSum_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne8_FourSum_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new LinkedList<>();
            if (nums == null || nums.length < 4) return res;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int l = j + 1, r = nums.length - 1;
                    while (l < r) {
                        long sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                            while (l < r && nums[l] == nums[l + 1]) ++l;
                            while (l < r && nums[r] == nums[r - 1]) --r;
                            ++l;
                            --r;
                        } else if (sum < target) {
                            ++l;
                        } else {
                            --r;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

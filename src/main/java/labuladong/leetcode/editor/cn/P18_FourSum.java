//<p>Given an array <code>nums</code> of <code>n</code> integers, return <em>an array of all the <strong>unique</strong> quadruplets</em> <code>[nums[a], nums[b], nums[c], nums[d]]</code> such that:</p>
//
//<ul>
//	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
//	<li><code>a</code>, <code>b</code>, <code>c</code>, and <code>d</code> are <strong>distinct</strong>.</li>
//	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
//</ul>
//
//<p>You may return the answer in <strong>any order</strong>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,0,-1,0,-2,2], target = 0
//<strong>Output:</strong> [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [2,2,2,2,2], target = 8
//<strong>Output:</strong> [[2,2,2,2]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
//	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
//	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>
//
//<div>👍 1333, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 4Sum
 *
 * @author DY
 * @date 2022-08-18 16:24:46
 */
public class P18_FourSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P18_FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
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
                    int left = j + 1, right = nums.length - 1;
                    while (left < right) {
                        long temp = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                        if (temp == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right && nums[right] == nums[right - 1]) right--;
                            left++;
                            right--;
                        } else if (temp < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
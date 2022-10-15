//<p>Given an integer array <code>nums</code>, return the length of the longest strictly increasing subsequence.</p>
//
//<p>A <strong>subsequence</strong> is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, <code>[3,6,2,7]</code> is a subsequence of the array <code>[0,3,1,6,2,2,7]</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [10,9,2,5,3,7,101,18]
//<strong>Output:</strong> 4
//<strong>Explanation:</strong> The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [0,1,0,3,2,3]
//<strong>Output:</strong> 4
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [7,7,7,7,7,7,7]
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 2500</code></li> 
// <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><b>Follow up:</b>&nbsp;Can you come up with an algorithm that runs in&nbsp;<code>O(n log(n))</code> time complexity?</p>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 动态规划</details><br>
//
//<div>👍 2833, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence
 *
 * @author DY
 * @date 2022-10-15 15:35:40
 */
public class P300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int[] res = new int[nums.length];
            Arrays.fill(res, 1);
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        res[i] = Math.max(res[i], res[j] + 1);
                    }
                }
            }
            int max = -1;
            for (int temp : res) {
                max = Math.max(max, temp);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//<p>You are given a 2D array of integers <code>envelopes</code> where <code>envelopes[i] = [w<sub>i</sub>, h<sub>i</sub>]</code> represents the width and the height of an envelope.</p>
//
//<p>One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.</p>
//
//<p>Return <em>the maximum number of envelopes you can Russian doll (i.e., put one inside the other)</em>.</p>
//
//<p><strong>Note:</strong> You cannot rotate an envelope.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> envelopes = [[5,4],[6,4],[6,7],[2,3]]
//<strong>Output:</strong> 3
//<strong>Explanation:</strong> The maximum number of envelopes you can Russian doll is <span><code>3</code></span> ([2,3] =&gt; [5,4] =&gt; [6,7]).
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> envelopes = [[1,1],[1,1],[1,1]]
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= envelopes.length &lt;= 10<sup>5</sup></code></li> 
// <li><code>envelopes[i].length == 2</code></li> 
// <li><code>1 &lt;= w<sub>i</sub>, h<sub>i</sub> &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 动态规划 | 排序</details><br>
//
//<div>👍 819, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Russian Doll Envelopes
 *
 * @author DY
 * @date 2022-10-15 16:04:35
 */
public class P354_RussianDollEnvelopes {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P354_RussianDollEnvelopes().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            Arrays.sort(envelopes, (a, b) -> {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            });
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = envelopes[i][1];
            }
            return lengthOfLIS(height);
        }

        private int lengthOfLIS(int[] nums) {
            int count = 0, n = nums.length;
            int[] top = new int[n];
            for (int item : nums) {
                int left = 0, right = count;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (top[mid] >= item) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                if (left == count) count++;
                top[left] = item;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
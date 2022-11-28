//<p>You are given an integer array <code>nums</code> that is <strong>sorted in non-decreasing order</strong>.</p>
//
//<p>Determine if it is possible to split <code>nums</code> into <strong>one or more subsequences</strong> such that <strong>both</strong> of the following conditions are true:</p>
//
//<ul> 
// <li>Each subsequence is a <strong>consecutive increasing sequence</strong> (i.e. each integer is <strong>exactly one</strong> more than the previous integer).</li> 
// <li>All subsequences have a length of <code>3</code><strong> or more</strong>.</li> 
//</ul>
//
//<p>Return <code>true</code><em> if you can split </em><code>nums</code><em> according to the above conditions, or </em><code>false</code><em> otherwise</em>.</p>
//
//<p>A <strong>subsequence</strong> of an array is a new array that is formed from the original array by deleting some (can be none) of the elements without disturbing the relative positions of the remaining elements. (i.e., <code>[1,3,5]</code> is a subsequence of <code>[<u>1</u>,2,<u>3</u>,4,<u>5</u>]</code> while <code>[1,3,2]</code> is not).</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,3,4,5]
//<strong>Output:</strong> true
//<strong>Explanation:</strong> nums can be split into the following subsequences:
//[<strong><u>1</u></strong>,<strong><u>2</u></strong>,<strong><u>3</u></strong>,3,4,5] --&gt; 1, 2, 3
//[1,2,3,<strong><u>3</u></strong>,<strong><u>4</u></strong>,<strong><u>5</u></strong>] --&gt; 3, 4, 5
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,3,4,4,5,5]
//<strong>Output:</strong> true
//<strong>Explanation:</strong> nums can be split into the following subsequences:
//[<strong><u>1</u></strong>,<strong><u>2</u></strong>,<strong><u>3</u></strong>,3,<strong><u>4</u></strong>,4,<strong><u>5</u></strong>,5] --&gt; 1, 2, 3, 4, 5
//[1,2,3,<strong><u>3</u></strong>,4,<strong><u>4</u></strong>,5,<strong><u>5</u></strong>] --&gt; 3, 4, 5
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3,4,4,5]
//<strong>Output:</strong> false
//<strong>Explanation:</strong> It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li> 
// <li><code>nums</code> is sorted in <strong>non-decreasing</strong> order.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 哈希表 | 堆（优先队列）</details><br>
//
//<div>👍 408, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Split Array into Consecutive Subsequences
 *
 * @author DY
 * @date 2022-11-25 09:36:55
 */
public class P659_SplitArrayIntoConsecutiveSubsequences {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P659_SplitArrayIntoConsecutiveSubsequences().new Solution();
        System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPossible(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>(); // 记录每个数字的频率
            Map<Integer, Integer> need = new HashMap<>(); // 记录每个数字的需要
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            for (int num : nums) {
                if (freq.get(num) == 0) { // 此数字已经用完了
                    continue;
                }
                if (need.getOrDefault(num, 0) > 0) { // 先判断能否拼接到以前的序列中
                    need.put(num, need.get(num) - 1); // 拼到以前的序列，需求-1
                    freq.put(num, freq.get(num) - 1); // 频率-1
                    need.put(num + 1, need.getOrDefault(num + 1, 0) + 1); // 对下一个数字的需求+1
                } else if (freq.getOrDefault(num, 0) > 0
                        && freq.getOrDefault(num + 1, 0) > 0
                        && freq.getOrDefault(num + 2, 0) > 0) {  // 自成一个序列
                    freq.put(num, freq.get(num) - 1);
                    freq.put(num + 1, freq.get(num + 1) - 1);
                    freq.put(num + 2, freq.get(num + 2) - 1);
                    need.put(num + 3, need.getOrDefault(num + 3, 0) + 1);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
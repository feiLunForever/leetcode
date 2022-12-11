//<p>Given a <strong>1-indexed</strong> array of integers <code>numbers</code> that is already <strong><em>sorted in non-decreasing order</em></strong>, find two numbers such that they add up to a specific <code>target</code> number. Let these two numbers be <code>numbers[index<sub>1</sub>]</code> and <code>numbers[index<sub>2</sub>]</code> where <code>1 &lt;= index<sub>1</sub> &lt; index<sub>2</sub> &lt;= numbers.length</code>.</p>
//
//<p>Return<em> the indices of the two numbers, </em><code>index<sub>1</sub></code><em> and </em><code>index<sub>2</sub></code><em>, <strong>added by one</strong> as an integer array </em><code>[index<sub>1</sub>, index<sub>2</sub>]</code><em> of length 2.</em></p>
//
//<p>The tests are generated such that there is <strong>exactly one solution</strong>. You <strong>may not</strong> use the same element twice.</p>
//
//<p>Your solution must use only constant extra space.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> numbers = [<u>2</u>,<u>7</u>,11,15], target = 9
//<strong>Output:</strong> [1,2]
//<strong>Explanation:</strong> The sum of 2 and 7 is 9. Therefore, index<sub>1</sub> = 1, index<sub>2</sub> = 2. We return [1, 2].
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> numbers = [<u>2</u>,3,<u>4</u>], target = 6
//<strong>Output:</strong> [1,3]
//<strong>Explanation:</strong> The sum of 2 and 4 is 6. Therefore index<sub>1</sub> = 1, index<sub>2</sub> = 3. We return [1, 3].
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> numbers = [<u>-1</u>,<u>0</u>], target = -1
//<strong>Output:</strong> [1,2]
//<strong>Explanation:</strong> The sum of -1 and 0 is -1. Therefore index<sub>1</sub> = 1, index<sub>2</sub> = 2. We return [1, 2].
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>2 &lt;= numbers.length &lt;= 3 * 10<sup>4</sup></code></li>
//	<li><code>-1000 &lt;= numbers[i] &lt;= 1000</code></li>
//	<li><code>numbers</code> is sorted in <strong>non-decreasing order</strong>.</li>
//	<li><code>-1000 &lt;= target &lt;= 1000</code></li>
//	<li>The tests are generated such that there is <strong>exactly one solution</strong>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 二分查找</details><br>
//
//<div>👍 862, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Two Sum II - Input Array Is Sorted
 *
 * @author DY
 * @date 2022-08-08 11:41:37
 */
public class P167_TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P167_TwoSumIiInputArrayIsSorted().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                }
                if (sum > target) { // 求和结果 > 目标值，则让 sum 小一点
                    --right;
                } else {
                    ++left;
                }
            }
            return new int[]{-1, -1};
        }


        public List<List<Integer>> twoSum1(int[] numbers, int target) {
            Arrays.sort(numbers);
            List<List<Integer>> res = new LinkedList<>();
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int mid = numbers[left] + numbers[right];
                int leftV = numbers[left];
                int rightV = numbers[right];
                if (mid == target) {
                    res.add(new LinkedList<>(Arrays.asList(numbers[left], numbers[right])));
                    while (left < right && numbers[left] == leftV) left++;
                    while (left < right && numbers[right] == rightV) right--;
                } else if (mid < target) {
                    while (left < right && numbers[left] == leftV) left++;
                } else {
                    while (left < right && numbers[right] == rightV) right--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
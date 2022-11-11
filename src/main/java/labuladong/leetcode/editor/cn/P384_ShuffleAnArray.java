//<p>Given an integer array <code>nums</code>, design an algorithm to randomly shuffle the array. All permutations of the array should be <strong>equally likely</strong> as a result of the shuffling.</p>
//
//<p>Implement the <code>Solution</code> class:</p>
//
//<ul> 
// <li><code>Solution(int[] nums)</code> Initializes the object with the integer array <code>nums</code>.</li> 
// <li><code>int[] reset()</code> Resets the array to its original configuration and returns it.</li> 
// <li><code>int[] shuffle()</code> Returns a random shuffling of the array.</li> 
//</ul>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//["Solution", "shuffle", "reset", "shuffle"]
//[[[1, 2, 3]], [], [], []]
//<strong>Output</strong>
//[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//<strong>Explanation</strong>
//Solution solution = new Solution([1, 2, 3]);
//solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
//                       // Any permutation of [1,2,3] must be equally likely to be returned.
//                       // Example: return [3, 1, 2]
//solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
//solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
//
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 50</code></li> 
// <li><code>-10<sup>6</sup> &lt;= nums[i] &lt;= 10<sup>6</sup></code></li> 
// <li>All the elements of <code>nums</code> are <strong>unique</strong>.</li> 
// <li>At most <code>10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>reset</code> and <code>shuffle</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 随机化</details><br>
//
//<div>👍 313, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle an Array
 *
 * @author DY
 * @date 2022-11-11 17:37:29
 */
public class P384_ShuffleAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P384_ShuffleAnArray().new Solution(new int[]{1, 2, 3});
        solution.shuffle();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int[] nums;

        private Random rand = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int n = nums.length;
            int[] ints = Arrays.copyOf(nums, n);
            for (int i = 0; i < n; i++) {
                int round = i + rand.nextInt(n - i); // 随机生成一个[i,n) 值
                swaps(ints, i, round);
            }
            return ints;
        }

        private void swaps(int[] ints, int i, int j) {
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
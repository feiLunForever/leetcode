/**
 * <p>Given an integer <code>n</code>, return <em>the number of structurally unique <strong>BST'</strong>s (binary search trees) which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
 * <pre>
 * <strong>Input:</strong> n = 3
 * <strong>Output:</strong> 5
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 19</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 数学 | 动态规划 | 二叉树</details><br>
 *
 * <div>👍 2389, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Unique Binary Search Trees
 *
 * @author DY
 * @date 2023-10-29 17:46:15
 */
public class PNine6_UniqueBinarySearchTrees_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine6_UniqueBinarySearchTrees_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[][] memo = new int[n + 1][n + 1];
            return count(1, n, memo);
        }

        private int count(int lo, int hi, int[][] memo) {
            if (lo > hi) return 1;
            if (memo[lo][hi] != 0) return memo[lo][hi];
            int sum = 0;
            for (int i = lo; i <= hi; i++) {
                int left = count(lo, i - 1, memo);
                int right = count(i + 1, hi, memo);
                sum += left * right;
            }
            memo[lo][hi] = sum;
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

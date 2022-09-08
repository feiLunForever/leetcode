//<p>Given an integer <code>n</code>, return <em>the number of structurally unique <strong>BST&#39;</strong>s (binary search trees) which has exactly </em><code>n</code><em> nodes of unique values from</em> <code>1</code> <em>to</em> <code>n</code>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg" style="width: 600px; height: 148px;" />
//<pre>
//<strong>Input:</strong> n = 3
//<strong>Output:</strong> 5
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 19</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>树 | 二叉搜索树 | 数学 | 动态规划 | 二叉树</details><br>
//
//<div>👍 1927, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Unique Binary Search Trees
 *
 * @author DY
 * @date 2022-09-08 17:03:17
 */
public class P96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P96_UniqueBinarySearchTrees().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numTrees(int n) {
            int[][] cache = new int[n + 1][n + 1];
            return count(1, n, cache);
        }

        private int count(int start, int end, int[][] cache) {
            if (start > end) return 1;
            if (cache[start][end] != 0) return cache[start][end];
            int sum = 0;
            for (int i = start; i <= end; i++) {
                int left = count(start, i - 1, cache);
                int right = count(i + 1, end, cache);
                sum += left * right;
            }
			cache[start][end] = sum;
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
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
 * <div>👍 2242, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Unique Binary Search Trees
 *
 * @author DY
 * @date 2023-05-23 17:15:23
 */
public class PNine6_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine6_UniqueBinarySearchTrees().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTrees(int n) {
            int[][] memo = new int[n + 1][n + 1];
            return dfs(1, n, memo);
        }

        private int dfs(int l, int r, int[][] memo) {
            if (l > r) return 1;
            if (memo[l][r] != 0) return memo[l][r];
            int res = 0;
            for (int i = l; i <= r; i++) {
                // i 的值作为根节点 root
                int left = dfs(l, i - 1, memo);
                int right = dfs(i + 1, r, memo);
                res += left * right;
            }
            memo[l][r] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * <p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>
 *
 * <p>Given an integer <code>n</code>, return <em>the number of distinct solutions to the&nbsp;<strong>n-queens puzzle</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
 * <pre>
 * <strong>Input:</strong> n = 4
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> There are two distinct solutions to the 4-queens puzzle as shown.
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
 * <li><code>1 &lt;= n &lt;= 9</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>回溯</details><br>
 *
 * <div>👍 452, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * N-Queens II
 *
 * @author DY
 * @date 2023-07-31 17:51:02
 */
public class PFive2_NQueensIi_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive2_NQueensIi_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int count = 0;

        public int totalNQueens(int n) {
            boolean[] col = new boolean[n];
            Set<Integer> left = new HashSet<>();
            Set<Integer> right = new HashSet<>();
            backTrace(0, n, left, right, col);
            return count;
        }

        private void backTrace(int row, int n, Set<Integer> left, Set<Integer> right, boolean[] col) {
            if (row == n) {
                ++count;
                return;
            }
            for (int i = 0; i < n; i++) {
                int leftIndex = row + i;
                int rightIndex = row - i;
                if (!left.contains(leftIndex) && !right.contains(rightIndex) && !col[i]) {
                    left.add(leftIndex);
                    right.add(rightIndex);
                    col[i] = true;
                    backTrace(row + 1, n, left, right, col);
                    left.remove(leftIndex);
                    right.remove(rightIndex);
                    col[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

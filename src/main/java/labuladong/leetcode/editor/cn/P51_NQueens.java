//<p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>
//
//<p>Given an integer <code>n</code>, return <em>all distinct solutions to the <strong>n-queens puzzle</strong></em>. You may return the answer in <strong>any order</strong>.</p>
//
//<p>Each solution contains a distinct board configuration of the n-queens&#39; placement, where <code>&#39;Q&#39;</code> and <code>&#39;.&#39;</code> both indicate a queen and an empty space, respectively.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
//<pre>
//<strong>Input:</strong> n = 4
//<strong>Output:</strong> [[&quot;.Q..&quot;,&quot;...Q&quot;,&quot;Q...&quot;,&quot;..Q.&quot;],[&quot;..Q.&quot;,&quot;Q...&quot;,&quot;...Q&quot;,&quot;.Q..&quot;]]
//<strong>Explanation:</strong> There exist two distinct solutions to the 4-queens puzzle as shown above
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1
//<strong>Output:</strong> [[&quot;Q&quot;]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 9</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>
//
//<div>👍 1445, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * N-Queens
 *
 * @author DY
 * @date 2022-08-10 09:45:56
 */
public class P51_NQueens {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            LinkedList<Integer> trace = new LinkedList<>();
            Set<Integer> left = new HashSet<>(2 * n - 1);
            Set<Integer> right = new HashSet<>(2 * n - 1);
            boolean[] col = new boolean[n];
            List<List<String>> res = new ArrayList<>();

            backTrack(0, n, trace, left, right, col, res);

            return res;
        }

        private void backTrack(int row, int maxRow, LinkedList<Integer> trace, Set<Integer> left, Set<Integer> right, boolean[] col, List<List<String>> res) {
            if (row == maxRow) {
                res.add(buildBoard(trace));
                return;
            }
            for (int i = 0; i < maxRow; i++) {
                int leftIndex = row + i;
                int rightIndex = row - i;
                if (!left.contains(leftIndex) && !right.contains(rightIndex) && !col[i]) {
                    left.add(leftIndex);
                    right.add(rightIndex);
                    col[i] = true;
                    trace.add(i);

                    backTrack(row + 1, maxRow, trace, left, right, col, res);

                    left.remove(leftIndex);
                    right.remove(rightIndex);
                    col[i] = false;
                    trace.removeLast();
                }
            }
        }

        private List<String> buildBoard(LinkedList<Integer> trace) {
            List<String> res = new ArrayList<>(trace.size());

            for (int row : trace) {
                char[] chars = new char[trace.size()];
                Arrays.fill(chars, '.');
                chars[row] = 'Q';
                res.add(new String(chars));
            }
            return res;
        }









        /*public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new LinkedList<>();
            LinkedList<Integer> queue = new LinkedList<>();
            Set<Integer> leftDia = new HashSet<>(2 * n - 1);
            Set<Integer> rightDia = new HashSet<>(2 * n - 1);
            boolean[] columns = new boolean[n];

            dfs(n, 0, columns, leftDia, rightDia, queue, res);

            return res;
        }

        private void dfs(int n, int row, boolean[] columns, Set<Integer> leftDia, Set<Integer> rightDia, LinkedList<Integer> queue, List<List<String>> res) {
            if (row == n) {
                res.add(buildBoard(queue));
                return;
            }
            for (int i = 0; i < n; i++) {

                int leftDiaIndex = row + i;
                int rightDiaIndex = row - i;

                if (!columns[i] && !leftDia.contains(leftDiaIndex) && !rightDia.contains(rightDiaIndex)) {
                    queue.add(i);
                    columns[i] = true;
                    leftDia.add(leftDiaIndex);
                    rightDia.add(rightDiaIndex);
                    dfs(n, row + 1, columns, leftDia, rightDia, queue, res);

                    queue.removeLast();
                    columns[i] = false;
                    leftDia.remove(leftDiaIndex);
                    rightDia.remove(rightDiaIndex);
                }
            }
        }

        private List<String> buildBoard(LinkedList<Integer> queue) {
            int n = queue.size();
            List<String> res = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queue.get(i)] = 'Q';
                res.add(new String(row));
            }
            return res;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
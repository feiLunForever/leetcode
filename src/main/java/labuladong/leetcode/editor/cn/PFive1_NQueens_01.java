/**
 * <p>The <strong>n-queens</strong> puzzle is the problem of placing <code>n</code> queens on an <code>n x n</code> chessboard such that no two queens attack each other.</p>
 *
 * <p>Given an integer <code>n</code>, return <em>all distinct solutions to the <strong>n-queens puzzle</strong></em>. You may return the answer in <strong>any order</strong>.</p>
 *
 * <p>Each solution contains a distinct board configuration of the n-queens' placement, where <code>'Q'</code> and <code>'.'</code> both indicate a queen and an empty space, respectively.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
 * <pre>
 * <strong>Input:</strong> n = 4
 * <strong>Output:</strong> [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * <strong>Explanation:</strong> There exist two distinct solutions to the 4-queens puzzle as shown above
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> [["Q"]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 9</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>
 *
 * <div>👍 1838, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * N-Queens
 *
 * @author DY
 * @date 2023-07-31 17:33:26
 */
public class PFive1_NQueens_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive1_NQueens_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            LinkedList<Integer> trace = new LinkedList<>(); // 记录每一行的Q 列的位置
            Set<Integer> left = new HashSet<>(); // 记录左对角线的Q
            Set<Integer> right = new HashSet<>(); // 记录右对角线的Q
            boolean[] col = new boolean[n]; // 记录每一列的Q
            List<List<String>> res = new LinkedList<>();
            backTrace(0, n, trace, left, right, col, res);
            return res;
        }

		private void backTrace(int row, int n, LinkedList<Integer> trace, Set<Integer> left, Set<Integer> right, boolean[] col, List<List<String>> res) {
        	if(row == n) {
        		res.add(buildBoard(trace));
        		return;
			}
			for (int j = 0; j < n; j++) {
				int leftIndex = row + j;
				int rightIndex = row - j;
				if(!left.contains(leftIndex) && !right.contains(rightIndex) && !col[j]) {
					left.add(leftIndex);
					right.add(rightIndex);
					col[j] = true;
					trace.add(j);
					backTrace(row+1,n,trace,left,right,col,res);
					left.remove(leftIndex);
					right.remove(rightIndex);
					col[j] = false;
					trace.removeLast();
				}
			}
		}

		private List<String> buildBoard(LinkedList<Integer> trace) {
        	List<String> res = new ArrayList<>(trace.size());
        	for (int col : trace) {
				char[] chars = new char[trace.size()];
				Arrays.fill(chars,'.');
				chars[col] = 'Q';
				res.add(new String(chars));
			}
        	return res;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}

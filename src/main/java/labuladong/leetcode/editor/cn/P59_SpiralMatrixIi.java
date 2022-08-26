//<p>Given a positive integer <code>n</code>, generate an <code>n x n</code> <code>matrix</code> filled with elements from <code>1</code> to <code>n<sup>2</sup></code> in spiral order.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/spiraln.jpg" style="width: 242px; height: 242px;" />
//<pre>
//<strong>Input:</strong> n = 3
//<strong>Output:</strong> [[1,2,3],[8,9,4],[7,6,5]]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1
//<strong>Output:</strong> [[1]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 20</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>
//
//<div>👍 802, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Spiral Matrix II
 *
 * @author DY
 * @date 2022-08-26 16:36:06
 */
public class P59_SpiralMatrixIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P59_SpiralMatrixIi().new Solution();
		System.out.println(solution.generateMatrix(3));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            circle(res, 0, 0, n - 1, n - 1, 1);
            return res;
        }

        private void circle(int[][] res, int x1, int y1, int x2, int y2, int start) {
            if (x1 > x2 || y1 > y2) return;

            if (x1 == x2) { // 只剩下 y1 --> y2
                for (int i = y1; i <= y2; i++) {
                    res[x1][i] = start++;
                }
                return;
            }
            if (y1 == y2) { // 只剩下 x1 --> x2
                for (int i = x1; i <= x2; i++) {
                    res[i][y1] = start++;
                }
                return;
            }
            // 按照 右 --> 下 --> 左 --> 上 的顺序遍历
            for (int i = y1; i < y2; i++) res[x1][i] = start++;
            for (int i = x1; i < x2; i++) res[i][y2] = start++;
            for (int i = y2; i > y1; i--) res[x2][i] = start++;
            for (int i = x2; i > x1; i--) res[i][y1] = start++;

            circle(res, x1 + 1, y1 + 1, x2 - 1, y2 - 1, start); // 缩小圈
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
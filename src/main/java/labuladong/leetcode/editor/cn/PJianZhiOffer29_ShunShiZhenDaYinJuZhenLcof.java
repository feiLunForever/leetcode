/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 矩阵 | 模拟</details><br>
 *
 * <div>👍 505, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 顺时针打印矩阵  LCOF
 *
 * @author DY
 * @date 2023-03-09 18:45:01
 */
public class PJianZhiOffer29_ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer29_ShunShiZhenDaYinJuZhenLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
            int m = matrix.length, n = matrix[0].length;
            int[] res = new int[m * n];
            circle(matrix, 0, 0, m - 1, n - 1, res, 0);
            return res;
        }

        private void circle(int[][] matrix, int x1, int y1, int x2, int y2, int[] res, int index) {
            if (x1 > x2 || y1 > y2) return;
            if (x1 == x2) { // 只剩下y1 --> y2
                for (int i = y1; i <= y2; i++) {
                    res[index++] = matrix[x1][i];
                }
                return;
            }
            if (y1 == y2) { // 只剩下x1 --> x2
                for (int i = x1; i <= x2; i++) {
                    res[index++] = matrix[i][y1];
                }
                return;
            }
            for (int i = y1; i < y2; i++) res[index++] = matrix[x1][i]; // 右遍历
            for (int i = x1; i < x2; i++) res[index++] = matrix[i][y2]; // 下遍历
            for (int i = y2; i > y1; i--) res[index++] = matrix[x2][i]; // 左遍历
            for (int i = x2; i > x1; i--) res[index++] = matrix[i][y1]; // 上遍历

            circle(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, res, index); // 缩小圈
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

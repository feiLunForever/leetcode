/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 回溯 | 矩阵</details><br>
 *
 * <div>👍 817, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 矩阵中的路径  LCOF
 *
 * @author DY
 * @date 2023-07-31 18:06:18
 */
public class PJianZhiOffer12_JuZhenZhongDeLuJingLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer12_JuZhenZhongDeLuJingLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length, n = board[0].length;
            boolean[][] used = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (backTrace(board, i, j, word, 0, used)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backTrace(char[][] board, int row, int col, String word, int i, boolean[][] used) {
            int m = board.length, n = board[0].length;
            if (row < 0 || row >= m || col < 0 || col >= n) return false;
            if (used[row][col]) return false;
            if (board[row][col] != word.charAt(i)) return false;
            if (word.length() - 1 == i) return true;

            used[row][col] = true;
            ++i;
            boolean res = backTrace(board, row - 1, col, word, i, used)
                    || backTrace(board, row + 1, col, word, i, used)
                    || backTrace(board, row, col - 1, word, i, used)
                    || backTrace(board, row, col + 1, word, i, used);
            used[row][col] = false;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

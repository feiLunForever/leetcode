/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 回溯 | 矩阵</details><br>
 *
 * <div>👍 747, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 矩阵中的路径  LCOF
 *
 * @author DY
 * @date 2023-03-02 19:03:31
 */
public class PJianZhiOffer12_JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer12_JuZhenZhongDeLuJingLcof().new Solution();
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] used = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, used, i, j, word, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board, boolean[][] used, int row, int col, String word, int index) {
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
            if(used[row][col]) return false;
            if (board[row][col] != word.charAt(index)) return false;
            if (word.length() - 1 == index) return true;
            used[row][col] = true;
            ++index;
            boolean res = dfs(board, used, row - 1, col, word, index)
                    || dfs(board, used, row + 1, col, word, index)
                    || dfs(board, used, row, col - 1, word, index)
                    || dfs(board, used, row, col + 1, word, index);
            used[row][col] = false;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes
 * of the grid.
 * <p>
 * <p>
 * The '.' character indicates empty cells.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",
 * ".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",
 * ".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".",
 * "6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4",
 * "8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"]
 * ,["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9
 * ","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4
 * ","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is
 * shown below:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * <p>
 * <p>
 * Related Topics数组 | 哈希表 | 回溯 | 矩阵
 * <p>
 * 👍 1662, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

/**
 * Sudoku Solver
 *
 * @author DY
 * @date 2023-06-24 16:37:05
 */
public class PThree7_SudokuSolver {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PThree7_SudokuSolver().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            backTrack(board, 0, 0);
        }

        private boolean backTrack(char[][] board, int i, int j) {
            int m = 9, n = 9;
            if (j == n) { // 这一行遍历完了，下一行
                return backTrack(board, i + 1, 0);
            }
            if (i == m) return true; // 遍历完了
            if (board[i][j] != '.') { // 如果有预设数字，不用我们穷举，下一把
                return backTrack(board, i, j + 1);
            }
            for (char ch = '1'; ch <= '9'; ch++) {
                if (!valid(board, i, j, ch)) {
                    continue;
                }
                board[i][j] = ch;
                if (backTrack(board, i, j + 1)) { // 如果找到一个可行解，立即结束
                    return true;
                }
                board[i][j] = '.'; // 撤回
            }
            return false;
        }

        private boolean valid(char[][] board, int i, int j, char ch) {
            for (int k = 0; k < 9; k++) {
                if (board[i][k] == ch) return false; // 判断行是否重复
                if (board[k][j] == ch) return false; // 判断列是否重复
                for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) { // 判断3*3方框中是否重复
                    for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
                        if (board[m][n] == ch) return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

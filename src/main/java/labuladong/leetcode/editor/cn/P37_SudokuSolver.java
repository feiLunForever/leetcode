//<p>Write a program to solve a Sudoku puzzle by filling the empty cells.</p>
//
//<p>A sudoku solution must satisfy <strong>all of the following rules</strong>:</p>
//
//<ol> 
// <li>Each of the digits <code>1-9</code> must occur exactly once in each row.</li> 
// <li>Each of the digits <code>1-9</code> must occur exactly once in each column.</li> 
// <li>Each of the digits <code>1-9</code> must occur exactly once in each of the 9 <code>3x3</code> sub-boxes of the grid.</li> 
//</ol>
//
//<p>The <code>'.'</code> character indicates empty cells.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" style="height:250px; width:250px" />
//<pre>
//<strong>Input:</strong> board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
//<strong>Output:</strong> [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
//<strong>Explanation:</strong>&nbsp;The input board is shown above and the only valid solution is shown below:
//</pre>
//
//<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png" style="height:250px; width:250px" />
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
// <li><code>board.length == 9</code></li>
// <li><code>board[i].length == 9</code></li>
// <li><code>board[i][j]</code> is a digit or <code>'.'</code>.</li>
// <li>It is <strong>guaranteed</strong> that the input board has only one solution.</li>
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>数组 | 回溯 | 矩阵</details><br>
//
//<div>👍 1453, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Sudoku Solver
 *
 * @author DY
 * @date 2022-11-11 09:28:23
 */
public class P37_SudokuSolver {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P37_SudokuSolver().new Solution();
		solution.solveSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}});

    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            backTraverse(board, 0, 0);
        }

        private boolean backTraverse(char[][] board, int i, int j) {
            int m = board.length, n = board[0].length;
            if (j == n) { // 到下一行
                return backTraverse(board, i + 1, 0);
            }
            if (i == m) { // 走完整个棋盘
                return true;
            }
            if (board[i][j] != '.') {
                return backTraverse(board, i, j + 1);
            }
            for (char ch = '1'; ch <= '9'; ch++) {
                if (!valid(board, i, j, ch)) {
                    continue;
                }
                board[i][j] = ch; // 选择
                if (backTraverse(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.'; // 取消选择
            }
            return false;
        }

        private boolean valid(char[][] board, int i, int j, char ch) {
            int m = board.length, n = board[0].length;
            for (int k = 0; k < n; k++) { // 判断此行有无该值
                if (board[i][k] == ch) {
                    return false;
                }
            }
            for (int k = 0; k < m; k++) { // 判断此列有无该值
                if (board[k][j] == ch) {
                    return false;
                }
            }
			int startRow = (i / 3) * 3;
			int startCol = (j / 3) * 3;
            for (int k = startRow; k < startRow + 3; k++) { // 判断3*3小九宫格里有无该值
                for (int l = startCol; l < startCol + 3; l++) {
                    if (board[k][l] == ch) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
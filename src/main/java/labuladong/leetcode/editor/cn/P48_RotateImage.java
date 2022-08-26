//<p>You are given an <code>n x n</code> 2D <code>matrix</code> representing an image, rotate the image by <strong>90</strong> degrees (clockwise).</p>
//
//<p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="width: 500px; height: 188px;" />
//<pre>
//<strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
//<strong>Output:</strong> [[7,4,1],[8,5,2],[9,6,3]]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="width: 500px; height: 201px;" />
//<pre>
//<strong>Input:</strong> matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//<strong>Output:</strong> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>n == matrix.length == matrix[i].length</code></li>
//	<li><code>1 &lt;= n &lt;= 20</code></li>
//	<li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 矩阵</details><br>
//
//<div>👍 1401, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Rotate Image
 *
 * @author DY
 * @date 2022-08-26 15:54:16
 */
public class P48_RotateImage {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P48_RotateImage().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            // 先根据对角线反转，再每一行反转
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    swap(matrix, i, j, j, i);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    swap(matrix, i, j, i, n - 1 - j);
                }
            }
        }

        private void swap(int[][] matrix, int row1, int rol1, int row2, int rol2) {
            int temp = matrix[row1][rol1];
            matrix[row1][rol1] = matrix[row2][rol2];
            matrix[row2][rol2] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
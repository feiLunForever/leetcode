/**
 * <p>You are given an <code>n x n</code> 2D <code>matrix</code> representing an image, rotate the image by <strong>90</strong> degrees (clockwise).</p>
 *
 * <p>You have to rotate the image <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank"><strong>in-place</strong></a>, which means you have to modify the input 2D matrix directly. <strong>DO NOT</strong> allocate another 2D matrix and do the rotation.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat1.jpg" style="width: 500px; height: 188px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <strong>Output:</strong> [[7,4,1],[8,5,2],[9,6,3]]
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/28/mat2.jpg" style="width: 500px; height: 201px;" />
 * <pre>
 * <strong>Input:</strong> matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * <strong>Output:</strong> [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == matrix.length == matrix[i].length</code></li>
 * <li><code>1 &lt;= n &lt;= 20</code></li>
 * <li><code>-1000 &lt;= matrix[i][j] &lt;= 1000</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 矩阵</details><br>
 *
 * <div>👍 1729, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Rotate Image
 *
 * @author DY
 * @date 2023-09-20 19:16:59
 */
public class PFour8_RotateImage_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFour8_RotateImage_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for (int[] row : matrix) {
                int l = 0, r = row.length - 1;
                while (l < r) {
                    int temp = row[l];
                    row[l] = row[r];
                    row[r] = temp;
                    ++l;
                    --r;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

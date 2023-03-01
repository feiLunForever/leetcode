/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 分治 | 矩阵</details><br>
 *
 * <div>👍 889, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 二维数组中的查找 LCOF
 *
 * @author DY
 * @date 2023-03-01 12:12:19
 */
public class P_JianZhiOffer04_ErWeiShuZuZhongDeChaZhaoLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P_JianZhiOffer04_ErWeiShuZuZhongDeChaZhaoLcof().new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            int row = matrix.length, col = matrix[0].length;
            int i = 0, j = col - 1;
            while (i < row && j >= 0) {
                if (matrix[i][j] == target) return true;
                else if (matrix[i][j] < target) ++i;
                else --j;
            }
            return false;
        }


        /*public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int i = 0, j = 0;
            while (i < matrix.length && j < matrix[0].length) {
                int row = i, col = j;
                while (row < matrix.length) {
                    if (matrix[row][j] == target) return true;
                    else if (matrix[row][j] < target) ++row;
                    else break;
                }
                while (col < matrix[0].length) {
                    if (matrix[i][col] == target) return true;
                    else if (matrix[i][col] < target) ++col;
                    else break;
                }
                ++i;
                ++j;
            }
            return false;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
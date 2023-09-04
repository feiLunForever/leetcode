/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 二分查找 | 分治 | 矩阵</details><br>
 *
 * <div>👍 1006, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 二维数组中的查找 LCOF
 *
 * @author DY
 * @date 2023-09-04 18:39:17
 */
public class PJianZhiOffer04_ErWeiShuZuZhongDeChaZhaoLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer04_ErWeiShuZuZhongDeChaZhaoLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
        	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                if (matrix[i][j] == target) return true;
                if (matrix[i][j] < target) ++i;
                else --j;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

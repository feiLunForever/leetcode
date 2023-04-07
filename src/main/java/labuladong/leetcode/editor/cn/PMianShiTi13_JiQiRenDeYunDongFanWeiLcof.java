/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 动态规划</details><br>
 *
 * <div>👍 621, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 机器人的运动范围  LCOF
 *
 * @author DY
 * @date 2023-04-07 18:30:45
 */
public class PMianShiTi13_JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PMianShiTi13_JiQiRenDeYunDongFanWeiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] used = new boolean[m][n];
            return dfs(used, m, n, k, 0, 0);
        }

        private int dfs(boolean[][] used, int m, int n, int k, int i, int j) {
            if (i >= m || j >= n || used[i][j] || (bitSum(i) + bitSum(j)) > k) {
                return 0;
            }
            used[i][j] = true;
            return 1 + dfs(used, m, n, k, i + 1, j) + dfs(used, m, n, k, i, j + 1);
        }

        private int bitSum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += (i % 10);
                i /= 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

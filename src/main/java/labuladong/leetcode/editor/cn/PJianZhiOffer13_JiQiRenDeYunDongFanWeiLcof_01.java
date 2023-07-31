/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 动态规划</details><br>
 *
 * <div>👍 650, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 机器人的运动范围  LCOF
 *
 * @author DY
 * @date 2023-07-31 19:36:47
 */
public class PJianZhiOffer13_JiQiRenDeYunDongFanWeiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer13_JiQiRenDeYunDongFanWeiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] used = new boolean[m][n];
            return dfs(m, n, 0, 0, k, used);
        }

        private int dfs(int m, int n, int i, int j, int k, boolean[][] used) {
            if (i >= m || j >= n || bitSum(i) + bitSum(j) > k) {
                return 0;
            }
            used[i][j] = true;
            return 1 + dfs(m, n, i + 1, j, k, used)
                    + dfs(m, n, i, j + 1, k, used);
        }

        private int bitSum(int x) {
            int sum = 0;
            while (x != 0) {
                sum += (x % 10);
                x /= 10;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数学 | 动态规划 | 概率与统计</details><br>
 *
 * <div>👍 567, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * n个骰子的点数  LCOF
 *
 * @author DY
 * @date 2023-07-31 14:10:08
 */
public class PJianZhiOffer60_NgeTouZiDeDianShuLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer60_NgeTouZiDeDianShuLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] dicesProbability(int n) {
			int min = n, max = 6 * n;
			double[][] dp = new double[n+1][max + 1]; // dp[i][j] => i个筛子投掷出j点的概率
			for (int i = 1; i <= 6; i++) {
				dp[1][i] = 1.0 / 6; // 一个筛子的概率都是1/6
			}
			for (int i = 2; i <= n; i++) { // i个筛子
				for (int j = i; j <= 6 * i; j++) { // 投掷出j点，范围是[i, 6*i]
					for (int k = 1; k <= 6; k++) { // 每个筛子的结果
						if(j <= k) break;
						dp[i][j] += dp[i - 1][j - k] / 6;
					}
				}
			}
			double[] res = new double[max - min + 1];
			int i = 0;
			for (int k = min; k <= max; k++) {
				res[i++] = dp[n][k];
			}
			return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数学 | 动态规划</details><br>
 *
 * <div>👍 240, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 剪绳子 II LCOF
 *
 * @author DY
 * @date 2023-03-03 18:59:49
 */
public class PJianZhiOffer14II_JianShengZiIiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer14II_JianShengZiIiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            if (n == 2) return 1;
            if (n == 3) return 2;
            long res = 1;
            int mod = (int) (1e9 + 7);
            while (n > 4) {
                res *= 3;
                res %= mod;
                n -= 3;
            }
            return (int) (res * n % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

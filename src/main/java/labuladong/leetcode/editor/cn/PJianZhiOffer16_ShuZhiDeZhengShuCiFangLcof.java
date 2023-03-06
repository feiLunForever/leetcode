/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>递归 | 数学</details><br>
 *
 * <div>👍 394, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 数值的整数次方 LCOF
 *
 * @author DY
 * @date 2023-03-06 12:25:39
 */
public class PJianZhiOffer16_ShuZhiDeZhengShuCiFangLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer16_ShuZhiDeZhengShuCiFangLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            long temp = n;
            if (temp < 0) {
                temp = -temp;
                x = 1 / x;
            }
            double res = 1.0;
            while (temp > 0) {
                if ((temp & 1) == 1) {
                    res *= x;
                }
                x *= x;
                temp >>= 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

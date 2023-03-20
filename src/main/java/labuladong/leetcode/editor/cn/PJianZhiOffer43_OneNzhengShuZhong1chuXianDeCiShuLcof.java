/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>递归 | 数学 | 动态规划</details><br>
 *
 * <div>👍 415, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 1～n整数中1出现的次数  LCOF
 *
 * @author DY
 * @date 2023-03-20 14:39:53
 */
public class PJianZhiOffer43_OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer43_OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {
            int high = n / 10; // 高位
            int cur = n % 10; // 当前位
            int low = 0; // 低位
            int digit = 1; // 个位
            int res = 0;
            while (high != 0 || cur != 0) {
                if (cur == 0) {
                    res += high * digit;
                } else if (cur == 1) {
                    res += (high * digit + low + 1);
                } else {
                    res += (high + 1) * digit;
                }
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

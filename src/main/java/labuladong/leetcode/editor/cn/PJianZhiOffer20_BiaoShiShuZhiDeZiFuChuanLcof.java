/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>字符串</details><br>
 *
 * <div>👍 431, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/7uUsXJpFJ8wzuMMxBmS7NQ' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 表示数值的字符串 LCOF
 *
 * @author DY
 * @date 2023-03-07 19:11:45
 */
public class PJianZhiOffer20_BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer20_BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
//		System.out.println(solution.isNumber("."));
//		System.out.println(solution.isNumber("11"));
//        System.out.println(solution.isNumber(". 1"));
//        System.out.println(solution.isNumber("-1E-16"));
        System.out.println(solution.isNumber("32.e-80123"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            int n = s.length(), index = 0;
            boolean hasNum = false; // 标记是否含有数字
            boolean hasE = false; // 标记是否含有E
            boolean hasSign = false; // 标记是否含有符号
            boolean hasDot = false; // 标记是否含有.
            while (index < n && s.charAt(index) == ' ') {
                ++index; // 处理前面的空格
            }
            while (index < n) {
                while (index < n && s.charAt(index) >= '0' && s.charAt(index) <= '9') { // 处理数字部分
                    hasNum = true;
                    ++index;
                }
                if (index == n) return true;
                if (s.charAt(index) == 'e' || s.charAt(index) == 'E') {
                    if (!hasNum || hasE) { // 前面没有数字或者已经出现过 e
                        return false;
                    }
                    hasE = true; // 标记出现了 e
                    // 重置 数字、符号和. 标识
                    hasNum = false;
                    hasSign = false;
                    hasDot = false;
                } else if (s.charAt(index) == '+' || s.charAt(index) == '-') {
                    if (hasNum || hasSign || hasDot) { // 前面有数字或者. 或者出现过符号
                        return false;
                    }
                    hasSign = true;
                } else if (s.charAt(index) == '.') {
                    if (hasDot || hasE) { // 前面出现过 .或者出现过 E
                        return false;
                    }
                    hasDot = true;
                } else if (s.charAt(index) == ' ') {
                    break;
                } else {
                    return false;
                }
                ++index;
            }
            while (index < n && s.charAt(index) == ' ') {
                ++index; // 处理前面的空格
            }
            return hasNum && index == n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

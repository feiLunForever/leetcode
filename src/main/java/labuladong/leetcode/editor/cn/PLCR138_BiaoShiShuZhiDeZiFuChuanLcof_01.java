/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>字符串</details><br>
 *
 * <div>👍 555, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 有效数字
 *
 * @author DY
 * @date 2023-11-07 17:32:04
 */
public class PLCR138_BiaoShiShuZhiDeZiFuChuanLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR138_BiaoShiShuZhiDeZiFuChuanLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validNumber(String s) {
            boolean hasNum = false; // 标记是否有数字
            boolean hasE = false; // 标记是否有E
            boolean hasSign = false; // 标记是否有+-
            boolean hasDot = false; // 标记是否有.
            char[] chars = s.trim().toCharArray();
            for (char ch : chars) {
                if (ch >= '0' && ch <= '9') {
                    hasNum = true;
                } else if (ch == 'e' || ch == 'E') {
                    if (hasE || !hasNum) { // 前面出现了e或者前面没有数字
                        return false;
                    }
                    hasE = true;
                    // 重置数字、符号和.标识
                    hasNum = false;
                    hasDot = false;
                    hasSign = false;
                } else if (ch == '+' || ch == '-') {
                    if (hasSign || hasDot || hasNum) { // 前面有数字或者.或者+-
                        return false;
                    }
                    hasSign = true;
                } else if (ch == '.') {
                    if (hasDot || hasE) { // 前面出现过.或者前面有E
                        return false;
                    }
                    hasDot = true;
                } else {
                    return false; // 其他情况一律是false
                }
            }
            return hasNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

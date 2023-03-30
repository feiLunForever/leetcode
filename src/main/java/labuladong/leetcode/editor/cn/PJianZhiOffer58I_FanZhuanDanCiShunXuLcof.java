/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>双指针 | 字符串</details><br>
 *
 * <div>👍 279, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 翻转单词顺序 LCOF
 *
 * @author DY
 * @date 2023-03-30 13:48:26
 */
public class PJianZhiOffer58I_FanZhuanDanCiShunXuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer58I_FanZhuanDanCiShunXuLcof().new Solution();
        System.out.println(solution.reverseWords(""));
//        System.out.println(solution.reverseWords(" "));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            int r = s.length() - 1;
            StringBuilder sb = new StringBuilder();
            while (r >= 0) {
                while (r >= 0 && s.charAt(r) == ' ') --r;
                if (r < 0) break;
                int l = r - 1;
                while (l >= 0 && s.charAt(l) != ' ') --l;
                for (int i = l + 1; i <= r; i++) {
                    sb.append(s.charAt(i));
                }
                sb.append(' ');
                r = l;
            }
            return sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

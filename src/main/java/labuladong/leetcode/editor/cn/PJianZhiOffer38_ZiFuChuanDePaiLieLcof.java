/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>字符串 | 回溯</details><br>
 *
 * <div>👍 656, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串的排列  LCOF
 *
 * @author DY
 * @date 2023-03-15 18:41:52
 */
public class PJianZhiOffer38_ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer38_ZiFuChuanDePaiLieLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            if (s == null) return null;
            List<String> res = new LinkedList<>();
            boolean[] used = new boolean[s.length()];
            StringBuilder trace = new StringBuilder();
            char[] array = s.toCharArray();
            Arrays.sort(array);
            permutation(array, used, trace, res);
            return res.toArray(new String[0]);
        }

        private void permutation(char[] array, boolean[] used, StringBuilder trace, List<String> res) {
            if (trace.length() == array.length) {
                res.add(trace.toString());
            }
            for (int i = 0; i < array.length; i++) {
                if (used[i]) continue;
                if (i > 0 && array[i] == array[i - 1] && !used[i - 1]) continue;
                trace.append(array[i]);
                used[i] = true;
                permutation(array, used, trace, res);
                trace.deleteCharAt(trace.length() - 1);
                used[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

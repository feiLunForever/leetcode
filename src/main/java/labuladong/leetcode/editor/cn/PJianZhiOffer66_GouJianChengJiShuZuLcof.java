/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 前缀和</details><br>
 *
 * <div>👍 313, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 构建乘积数组 LCOF
 *
 * @author DY
 * @date 2023-04-06 12:14:28
 */
public class PJianZhiOffer66_GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer66_GouJianChengJiShuZuLcof().new Solution();
		System.out.println(Arrays.toString(solution.constructArr(new int[]{1, 2, 3, 4, 5})));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            int n = a.length;
            if (n == 0) return new int[]{};
            int[] preSuffix = new int[n]; // preSuffix[i] ->  0..i 前缀乘积
            int[] postSuffix = new int[n]; // preSuffix[i] ->  i..n-1 后缀乘积
            preSuffix[0] = a[0];
            for (int i = 1; i < n; i++) {
                preSuffix[i] = preSuffix[i - 1] * a[i];
            }
            postSuffix[n - 1] = a[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                postSuffix[i] = postSuffix[i + 1] * a[i];
            }
            int[] res = new int[n];
            res[0] = postSuffix[1];
            res[n - 1] = preSuffix[n - 2];
            for (int i = 1; i < n - 1; i++) {
                res[i] = preSuffix[i - 1] * postSuffix[i + 1];
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

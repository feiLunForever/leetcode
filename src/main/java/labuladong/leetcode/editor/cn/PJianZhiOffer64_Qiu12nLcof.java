/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 递归 | 脑筋急转弯</details><br>
 *
 * <div>👍 600, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 求1+2+…+n LCOF
 *
 * @author DY
 * @date 2023-04-03 19:07:21
 */
public class PJianZhiOffer64_Qiu12nLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer64_Qiu12nLcof().new Solution();
		System.out.println(solution.sumNums(3));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    	private int res;
        public int sumNums(int n) {
            boolean x = n > 1 && sumNums(n - 1) > 0;
            res += n;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

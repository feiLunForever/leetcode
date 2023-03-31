/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>递归 | 数学</details><br>
 *
 * <div>👍 769, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 圆圈中最后剩下的数字 LCOF
 *
 * @author DY
 * @date 2023-03-31 18:18:19
 */
public class PJianZhiOffer62_YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer62_YuanQuanZhongZuiHouShengXiaDeShuZiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n, int m) {
			if(n == 1) return 0;
			int x = lastRemaining(n-1,m);
			return (x + m) % n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数学 | 二分查找</details><br>
 *
 * <div>👍 327, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 数字序列中某一位的数字  LCOF
 *
 * @author DY
 * @date 2023-03-20 21:46:23
 */
public class PJianZhiOffer44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer44_ShuZiXuLieZhongMouYiWeiDeShuZiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            if (n == 0) return 0;
            int digit = 1; // 数位（个位/十位/百位/...，就是1/2/3/...）
            long count = 9; // 该数位的数一共的索引个数（不是数字个数）
            int start = 1; // 属于该数位的所有数的起始点数（个位是1，十位是10，百位是100）
            while (n > count) { // 找出 n 属于那个数位里的索引
                n -= count;
                digit += 1; // 1,  2,  3, ...
                start *= 10; // 1, 10, 100, ...
                count = 9L * digit * start; // 9, 180, 2700, ...
            }
			// 上面的循环结束后：
			// digit 等于原始的 n 所属的数位；start 等于原始的 n 所属数位的数的起始点
			// count 等于原始的 n 所属数位的索引总个数（不重要了，下面不用）
			// n 等于在当前数位里的第 n - 1 个索引（索引从 0 开始算起）
            int num = start + (n - 1) / digit;
            int remainder = (n - 1) % digit; // 余数就是原始的 n 是这个数字中的第几位
            return Long.toString(num).charAt(remainder) - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

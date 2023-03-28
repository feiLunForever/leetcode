/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 数组</details><br>
 *
 * <div>👍 787, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 数组中数字出现的次数 LCOF
 *
 * @author DY
 * @date 2023-03-28 12:32:42
 */
public class PJianZhiOffer56I_ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer56I_ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        solution.singleNumbers(new int[]{1,2,5,2});
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int ret = 0;
            for (int num : nums) {
                ret ^= num;
            }
            int target = 1;
            while ((ret & target) == 0) { // 找到ret第一个为1的位数
                target <<= 1;
            }
            int a = 0, b = 0;
            for (int num : nums) {
                if ((num & target) == 0) {
                    a ^= num;
                } else {
                    b ^= num;
                }
            }
            return new int[]{a, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

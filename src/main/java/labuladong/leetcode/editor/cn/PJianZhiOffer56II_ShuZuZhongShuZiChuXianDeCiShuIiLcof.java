/**
 * <p>English description is not available for the problem. Please switch to Chinese.</p>
 *
 * <details><summary><strong>Related Topics</strong></summary>位运算 | 数组</details><br>
 *
 * <div>👍 431, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 数组中数字出现的次数 II LCOF
 *
 * @author DY
 * @date 2023-03-28 18:19:31
 */
public class PJianZhiOffer56II_ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer56II_ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int i = 0; i < 32; i++) { // int最大32位，统计每一位
                int cnt = 0;
				int index = 1 << i; // 第几位
                for (int num : nums) {
					if((num & index) != 0) ++cnt;
                }
                if(cnt % 3 != 0){ // 说明这一位为1
                	res ^= index; // 该位设为1
				}
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

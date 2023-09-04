/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 哈希表 | 分治 | 计数 | 排序</details><br>
 *
 * <div>👍 397, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 数组中出现次数超过一半的数字  LCOF
 *
 * @author DY
 * @date 2023-09-04 18:48:24
 */
public class PJianZhiOffer39_ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer39_ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int x = 0, count = 0;
            for (int num : nums) {
                if (count == 0) x = num;
                count += num == x ? 1 : -1;
            }
            return x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

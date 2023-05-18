/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>数组 | 排序</details><br>
 *
 * <div>👍 321, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子  LCOF
 *
 * @author DY
 * @date 2023-04-11 15:43:05
 */
public class PMianShiTi61_BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PMianShiTi61_BuKePaiZhongDeShunZiLcof().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {
			Set<Integer> set = new HashSet<>(nums.length);
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int num : nums){
				if(num == 0) continue; // 大小王忽略
				if(set.contains(num)) return false; // 重复，一定不是顺子
				max = Math.max(max,num);
				min = Math.min(min,num);
				set.add(num);
			}
			return max - min < 5;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

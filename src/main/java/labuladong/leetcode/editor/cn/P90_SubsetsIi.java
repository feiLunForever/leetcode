//<p>Given an integer array <code>nums</code> that may contain duplicates, return <em>all possible subsets (the power set)</em>.</p>
//
//<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<pre><strong>Input:</strong> nums = [1,2,2]
//<strong>Output:</strong> [[],[1],[1,2],[1,2,2],[2],[2,2]]
//</pre><p><strong>Example 2:</strong></p>
//<pre><strong>Input:</strong> nums = [0]
//<strong>Output:</strong> [[],[0]]
//</pre>
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
//	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 回溯</details><br>
//
//<div>👍 902, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Subsets II
 *
 * @author DY
 * @date 2022-08-11 12:50:11
 */
public class P90_SubsetsIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P90_SubsetsIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();

            LinkedList<Integer> queue = new LinkedList<>();

			Arrays.sort(nums);

            backTrack(nums, 0, queue, res);

            return res;
        }

        private void backTrack(int[] nums, int start, LinkedList<Integer> queue, List<List<Integer>> res) {
			res.add(new LinkedList<>(queue));
            for (int i = start; i < nums.length; i++) {

                if (i > start && nums[i] == nums[i - 1]) continue;

                queue.add(nums[i]);
                backTrack(nums, i + 1, queue, res);
                queue.removeLast();
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
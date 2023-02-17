//<p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible subsets (the power set)</em>.</p>
//
//<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3]
//<strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [0]
//<strong>Output:</strong> [[],[0]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
//	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
//	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>位运算 | 数组 | 回溯</details><br>
//
//<div>👍 1740, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Subsets
 *
 * @author DY
 * @date 2022-08-10 12:47:45
 */
public class P78_Subsets {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P78_Subsets().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            LinkedList<Integer> trace = new LinkedList<>();
            List<List<Integer>> rs = new LinkedList<>();
            backTrack(nums, 0, trace, rs);
            return rs;
        }

        private void backTrack(int[] nums, int start, LinkedList<Integer> trace, List<List<Integer>> rs) {
            rs.add(new ArrayList<>(trace)); // 前序位置，每个节点的值都是一个子集

            for (int i = start; i < nums.length; i++) {
                trace.add(nums[i]);
                backTrack(nums, i + 1, trace, rs);
                trace.removeLast();
            }
        }

        /*public List<List<Integer>> subsets(int[] nums) {
            LinkedList<Integer> queue = new LinkedList<>();
            List<List<Integer>> res = new LinkedList<>();

            backTrace(nums, 0, queue, res);

            return res;
        }

        private void backTrace(int[] nums, int start, LinkedList<Integer> queue, List<List<Integer>> res) {

            res.add(new LinkedList<>(queue));

            for (int i = start; i < nums.length; i++) {
                queue.add(nums[i]);

                backTrace(nums, i + 1, queue, res);

                queue.removeLast();
            }

        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
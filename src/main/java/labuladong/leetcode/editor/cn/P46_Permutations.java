//<p>Given an array <code>nums</code> of distinct integers, return <em>all the possible permutations</em>. You can return the answer in <strong>any order</strong>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<pre><strong>Input:</strong> nums = [1,2,3]
//<strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//</pre><p><strong>Example 2:</strong></p>
//<pre><strong>Input:</strong> nums = [0,1]
//<strong>Output:</strong> [[0,1],[1,0]]
//</pre><p><strong>Example 3:</strong></p>
//<pre><strong>Input:</strong> nums = [1]
//<strong>Output:</strong> [[1]]
//</pre>
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 6</code></li>
//	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
//	<li>All the integers of <code>nums</code> are <strong>unique</strong>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>
//
//<div>👍 2158, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Permutations
 *
 * @author DY
 * @date 2022-08-10 17:07:45
 */
public class P46_Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> queue = new LinkedList<>();

            boolean[] used = new boolean[nums.length];

            backTrack(nums, queue, res, used);

            return res;

        }

        private void backTrack(int[] nums, LinkedList<Integer> queue, List<List<Integer>> res, boolean[] used) {
            if (queue.size() == nums.length) {
                res.add(new LinkedList<>(queue));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    queue.add(nums[i]);
                    used[i] = true;

                    backTrack(nums, queue, res, used);

                    queue.removeLast();
                    used[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
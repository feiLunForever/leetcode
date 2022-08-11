//<p>Given a collection of numbers, <code>nums</code>,&nbsp;that might contain duplicates, return <em>all possible unique permutations <strong>in any order</strong>.</em></p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,1,2]
//<strong>Output:</strong>
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> nums = [1,2,3]
//<strong>Output:</strong> [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= nums.length &lt;= 8</code></li>
//	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>
//
//<div>👍 1155, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Permutations II
 *
 * @author DY
 * @date 2022-08-11 17:26:31
 */
public class P47_PermutationsIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P47_PermutationsIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> queue = new LinkedList<>();
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            backTrack(nums, used, queue, res);
            return res;
        }

        private void backTrack(int[] nums, boolean[] used, LinkedList<Integer> queue, List<List<Integer>> res) {
            if (queue.size() == nums.length) {
                res.add(new LinkedList<>(queue));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                queue.add(nums[i]);
                used[i] = true;
                backTrack(nums, used, queue, res);
                used[i] = false;
                queue.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
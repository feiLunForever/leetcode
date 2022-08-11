//<p>Given an array of <strong>distinct</strong> integers <code>candidates</code> and a target integer <code>target</code>, return <em>a list of all <strong>unique combinations</strong> of </em><code>candidates</code><em> where the chosen numbers sum to </em><code>target</code><em>.</em> You may return the combinations in <strong>any order</strong>.</p>
//
//<p>The <strong>same</strong> number may be chosen from <code>candidates</code> an <strong>unlimited number of times</strong>. Two combinations are unique if the frequency of at least one of the chosen numbers is different.</p>
//
//<p>It is <strong>guaranteed</strong> that the number of unique combinations that sum up to <code>target</code> is less than <code>150</code> combinations for the given input.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> candidates = [2,3,6,7], target = 7
//<strong>Output:</strong> [[2,2,3],[7]]
//<strong>Explanation:</strong>
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> candidates = [2,3,5], target = 8
//<strong>Output:</strong> [[2,2,2,2],[2,3,3],[3,5]]
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> candidates = [2], target = 1
//<strong>Output:</strong> []
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= candidates.length &lt;= 30</code></li>
//	<li><code>1 &lt;= candidates[i] &lt;= 200</code></li>
//	<li>All elements of <code>candidates</code> are <strong>distinct</strong>.</li>
//	<li><code>1 &lt;= target &lt;= 500</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>
//
//<div>👍 2104, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum
 *
 * @author DY
 * @date 2022-08-11 17:44:07
 */
public class P39_CombinationSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P39_CombinationSum().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> queue = new LinkedList<>();
            backTrack(candidates, 0, target, queue, res);
            return res;
        }

        private void backTrack(int[] candidates, int start, int target, LinkedList<Integer> queue, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new LinkedList<>(queue));
                return;
            }
            if (target < 0) return;

            for (int i = start; i < candidates.length; i++) {
                queue.add(candidates[i]);
                backTrack(candidates, i, target - candidates[i], queue, res);
                queue.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
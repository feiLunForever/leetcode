//<p>Given a collection of candidate numbers (<code>candidates</code>) and a target number (<code>target</code>), find all unique combinations in <code>candidates</code>&nbsp;where the candidate numbers sum to <code>target</code>.</p>
//
//<p>Each number in <code>candidates</code>&nbsp;may only be used <strong>once</strong> in the combination.</p>
//
//<p><strong>Note:</strong>&nbsp;The solution set must not contain duplicate combinations.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> candidates = [10,1,2,7,6,1,5], target = 8
//<strong>Output:</strong> 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
//<strong>Output:</strong> 
//[
//[1,2,2],
//[5]
//]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
//	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
//	<li><code>1 &lt;= target &lt;= 30</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>数组 | 回溯</details><br>
//
//<div>👍 1066, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum II
 *
 * @author DY
 * @date 2022-08-11 17:06:19
 */
public class P40_CombinationSumIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P40_CombinationSumIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            LinkedList<Integer> trace = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(candidates);
            backTrack(candidates, 0, target, trace, res);
            return res;
        }

        private void backTrack(int[] candidates, int start, int target, LinkedList<Integer> trace, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(trace));
                return;
            }
            if (target < 0) return;
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                trace.add(candidates[i]);
                backTrack(candidates, i + 1, target - candidates[i], trace, res);
                trace.removeLast();
            }
        }

        /*public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> queue = new LinkedList<>();
            Arrays.sort(candidates);
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
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                queue.add(candidates[i]);
                backTrack(candidates, i + 1, target - candidates[i], queue, res);
                queue.removeLast();
            }
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
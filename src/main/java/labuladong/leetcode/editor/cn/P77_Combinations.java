//<p>Given two integers <code>n</code> and <code>k</code>, return <em>all possible combinations of</em> <code>k</code> <em>numbers out of the range</em> <code>[1, n]</code>.</p>
//
//<p>You may return the answer in <strong>any order</strong>.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 4, k = 2
//<strong>Output:</strong>
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1, k = 1
//<strong>Output:</strong> [[1]]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 20</code></li>
//	<li><code>1 &lt;= k &lt;= n</code></li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>回溯</details><br>
//
//<div>👍 1080, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Combinations
 *
 * @author DY
 * @date 2022-08-10 16:54:04
 */
public class P77_Combinations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P77_Combinations().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> trace = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            backtrack(1, n, k, trace, res);
            return res;
        }

        private void backtrack(int start, int n, int k, LinkedList<Integer> trace, List<List<Integer>> res) {
            // base case
            if (trace.size() == k) {
                res.add(new ArrayList<>(trace));
                return;
            }

            for (int i = start; i <= n; i++) {
                trace.add(i); // choice
                backtrack(i + 1, n, k, trace, res);
                trace.removeLast(); // backTrace
            }
        }

        /*public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> queue = new LinkedList<>();
            List<List<Integer>> res = new LinkedList<>();

            backTrack(1, n, k, queue, res);

            return res;
        }

        private void backTrack(int start, int n, int k, LinkedList<Integer> queue, List<List<Integer>> res) {
            if (k == queue.size()) {
                res.add(new LinkedList<>(queue));
                return;
            }

            for (int i = start; i <= n; i++) {
                queue.add(i);
                backTrack(i + 1, n, k, queue, res);
                queue.removeLast();
            }
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
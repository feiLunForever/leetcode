/**
 * <p>Given a directed acyclic graph (<strong>DAG</strong>) of <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code>, find all possible paths from node <code>0</code> to node <code>n - 1</code> and return them in <strong>any order</strong>.</p>
 *
 * <p>The graph is given as follows: <code>graph[i]</code> is a list of all nodes you can visit from node <code>i</code> (i.e., there is a directed edge from node <code>i</code> to node <code>graph[i][j]</code>).</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_1.jpg" style="width: 242px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> graph = [[1,2],[3],[3],[]]
 * <strong>Output:</strong> [[0,1,3],[0,2,3]]
 * <strong>Explanation:</strong> There are two paths: 0 -&gt; 1 -&gt; 3 and 0 -&gt; 2 -&gt; 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_2.jpg" style="width: 423px; height: 301px;" />
 * <pre>
 * <strong>Input:</strong> graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * <strong>Output:</strong> [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>n == graph.length</code></li>
 * <li><code>2 &lt;= n &lt;= 15</code></li>
 * <li><code>0 &lt;= graph[i][j] &lt; n</code></li>
 * <li><code>graph[i][j] != i</code> (i.e., there will be no self-loops).</li>
 * <li>All the elements of <code>graph[i]</code> are <strong>unique</strong>.</li>
 * <li>The input graph is <strong>guaranteed</strong> to be a <strong>DAG</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 回溯</details><br>
 *
 * <div>👍 405, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * All Paths From Source to Target
 *
 * @author DY
 * @date 2023-05-31 18:31:56
 */
public class PSeven97_AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven97_AllPathsFromSourceToTarget().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> result = new LinkedList<>();
            LinkedList<Integer> trace = new LinkedList<>();
            traverse(graph, 0, trace, result);
            return result;
        }

        private void traverse(int[][] graph, int s, LinkedList<Integer> trace, List<List<Integer>> result) {
            trace.add(s);
            if (s == graph.length - 1) {
                result.add(new LinkedList<>(trace));
                trace.removeLast();
                return;
            }
            for (int v : graph[s]) {
                traverse(graph, v, trace, result);
            }
            trace.removeLast();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

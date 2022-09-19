//<p>Given a directed acyclic graph (<strong>DAG</strong>) of <code>n</code> nodes labeled from <code>0</code> to <code>n - 1</code>, find all possible paths from node <code>0</code> to node <code>n - 1</code> and return them in <strong>any order</strong>.</p>
//
//<p>The graph is given as follows: <code>graph[i]</code> is a list of all nodes you can visit from node <code>i</code> (i.e., there is a directed edge from node <code>i</code> to node <code>graph[i][j]</code>).</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_1.jpg" style="width: 242px; height: 242px;" /> 
//<pre>
//<strong>Input:</strong> graph = [[1,2],[3],[3],[]]
//<strong>Output:</strong> [[0,1,3],[0,2,3]]
//<strong>Explanation:</strong> There are two paths: 0 -&gt; 1 -&gt; 3 and 0 -&gt; 2 -&gt; 3.
//</pre>
//
//<p><strong>Example 2:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/09/28/all_2.jpg" style="width: 423px; height: 301px;" /> 
//<pre>
//<strong>Input:</strong> graph = [[4,3,1],[3,2,4],[3],[4],[]]
//<strong>Output:</strong> [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>n == graph.length</code></li> 
// <li><code>2 &lt;= n &lt;= 15</code></li> 
// <li><code>0 &lt;= graph[i][j] &lt; n</code></li> 
// <li><code>graph[i][j] != i</code> (i.e., there will be no self-loops).</li> 
// <li>All the elements of <code>graph[i]</code> are <strong>unique</strong>.</li> 
// <li>The input graph is <strong>guaranteed</strong> to be a <strong>DAG</strong>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 回溯</details><br>
//
//<div>👍 336, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * All Paths From Source to Target
 *
 * @author DY
 * @date 2022-09-19 16:01:55
 */
public class P797_AllPathsFromSourceToTarget {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P797_AllPathsFromSourceToTarget().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new LinkedList<>();
            traverse(graph, 0, new LinkedList<>(), res);
            return res;
        }

        private void traverse(int[][] graph, int index, LinkedList<Integer> path, List<List<Integer>> res) {
            path.addLast(index); // 将节点添加到路径中
            if (index == graph.length - 1) { // 已经遍历到最后节点，添加到结果中
                res.add(new ArrayList<>(path));
            }
            for (int v : graph[index]) { // 递归每个相邻节点
                traverse(graph, v, path, res);
            }
            path.removeLast(); // 回溯移除节点
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
/**
 * <p>There is an <strong>undirected</strong> graph with <code>n</code> nodes, where each node is numbered between <code>0</code> and <code>n - 1</code>. You are given a 2D array <code>graph</code>, where <code>graph[u]</code> is an array of nodes that node <code>u</code> is adjacent to. More formally, for each <code>v</code> in <code>graph[u]</code>, there is an undirected edge between node <code>u</code> and node <code>v</code>. The graph has the following properties:</p>
 *
 * <ul>
 * <li>There are no self-edges (<code>graph[u]</code> does not contain <code>u</code>).</li>
 * <li>There are no parallel edges (<code>graph[u]</code> does not contain duplicate values).</li>
 * <li>If <code>v</code> is in <code>graph[u]</code>, then <code>u</code> is in <code>graph[v]</code> (the graph is undirected).</li>
 * <li>The graph may not be connected, meaning there may be two nodes <code>u</code> and <code>v</code> such that there is no path between them.</li>
 * </ul>
 *
 * <p>A graph is <strong>bipartite</strong> if the nodes can be partitioned into two independent sets <code>A</code> and <code>B</code> such that <strong>every</strong> edge in the graph connects a node in set <code>A</code> and a node in set <code>B</code>.</p>
 *
 * <p>Return <code>true</code><em> if and only if it is <strong>bipartite</strong></em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi2.jpg" style="width: 222px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.</pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/21/bi1.jpg" style="width: 222px; height: 222px;" />
 * <pre>
 * <strong>Input:</strong> graph = [[1,3],[0,2],[1,3],[0,2]]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> We can partition the nodes into two sets: {0, 2} and {1, 3}.</pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>graph.length == n</code></li>
 * <li><code>1 &lt;= n &lt;= 100</code></li>
 * <li><code>0 &lt;= graph[u].length &lt; n</code></li>
 * <li><code>0 &lt;= graph[u][i] &lt;= n - 1</code></li>
 * <li><code>graph[u]</code>&nbsp;does not contain&nbsp;<code>u</code>.</li>
 * <li>All the values of <code>graph[u]</code> are <strong>unique</strong>.</li>
 * <li>If <code>graph[u]</code> contains <code>v</code>, then <code>graph[v]</code> contains <code>u</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 图</details><br>
 *
 * <div>👍 470, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Is Graph Bipartite?
 *
 * @author DY
 * @date 2023-06-06 15:12:48
 */
public class PSeven85_IsGraphBipartite {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven85_IsGraphBipartite().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean[] visited; // 记录图中节点是否被访问过
        private boolean[] color; // 记录图中节点的颜色，false 和 true 代表两种不同颜色

        public boolean isBipartite(int[][] graph) {
            visited = new boolean[graph.length];
			color = new boolean[graph.length];
			// 因为图不一定是联通的，可能存在多个子图
			// 所以要把每个节点都作为起点进行一次遍历
			// 如果发现任何一个子图不是二分图，整幅图都不算二分图
            for (int i = 0; i < graph.length; i++) {
                if (!traverse(graph, i)) return false;
            }
            return true;
        }

        private boolean traverse(int[][] graph, int v) {
            if (visited[v]) return true;
            visited[v] = true;

            for (int s : graph[v]) {
                if (!visited[s]) { // 相邻节点 w 没有被访问过，那么应该给节点 w 涂上和节点 v 不同的颜色
                    color[s] = !color[v];
                    if (!traverse(graph, s)) return false;
                } else { // 相邻节点 w 已经被访问过，根据 v 和 w 的颜色判断是否是二分图
                    if (color[s] == color[v]) return false; // 若相同，则此图不是二分图
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

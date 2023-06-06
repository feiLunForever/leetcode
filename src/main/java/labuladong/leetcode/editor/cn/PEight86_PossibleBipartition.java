/**
 * <p>We want to split a group of <code>n</code> people (labeled from <code>1</code> to <code>n</code>) into two groups of <strong>any size</strong>. Each person may dislike some other people, and they should not go into the same group.</p>
 *
 * <p>Given the integer <code>n</code> and the array <code>dislikes</code> where <code>dislikes[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that the person labeled <code>a<sub>i</sub></code> does not like the person labeled <code>b<sub>i</sub></code>, return <code>true</code> <em>if it is possible to split everyone into two groups in this way</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> The first group has [1,4], and the second group has [2,3].
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> We need at least 3 groups to divide them. We cannot put them in two groups.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 2000</code></li>
 * <li><code>0 &lt;= dislikes.length &lt;= 10<sup>4</sup></code></li>
 * <li><code>dislikes[i].length == 2</code></li>
 * <li><code>1 &lt;= a<sub>i</sub> &lt; b<sub>i</sub> &lt;= n</code></li>
 * <li>All the pairs of <code>dislikes</code> are <strong>unique</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 图</details><br>
 *
 * <div>👍 376, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Possible Bipartition
 *
 * @author DY
 * @date 2023-06-06 15:35:57
 */
public class PEight86_PossibleBipartition {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight86_PossibleBipartition().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean[] visited;

        private boolean[] color;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            visited = new boolean[n + 1]; // 图节点编号从 1 开始
            color = new boolean[n + 1];

            List<Integer>[] graph = buildGraph(n, dislikes);

            for (int i = 0; i <= n; i++) {
                if (!traverse(graph, i)) return false;
            }

            return true;
        }

        private boolean traverse(List<Integer>[] graph, int v) {
            if (visited[v]) return true;
            visited[v] = true;
            for (int t : graph[v]) {
                if (!visited[t]) {
                    color[t] = !color[v];
                    if (!traverse(graph, t)) return false;
                } else {
                    if (color[t] == color[v]) return false;
                }
            }
            return true;
        }

        private List<Integer>[] buildGraph(int n, int[][] dislikes) {
            List<Integer>[] graph = new LinkedList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : dislikes) { // 「无向图」相当于「双向图」
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

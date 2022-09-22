//<p>You are given a network of <code>n</code> nodes, labeled from <code>1</code> to <code>n</code>. You are also given <code>times</code>, a list of travel times as directed edges <code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>, where <code>u<sub>i</sub></code> is the source node, <code>v<sub>i</sub></code> is the target node, and <code>w<sub>i</sub></code> is the time it takes for a signal to travel from source to target.</p>
//
//<p>We will send a signal from a given node <code>k</code>. Return <em>the <strong>minimum</strong> time it takes for all the</em> <code>n</code> <em>nodes to receive the signal</em>. If it is impossible for all the <code>n</code> nodes to receive the signal, return <code>-1</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png" style="width: 217px; height: 239px;" /> 
//<pre>
//<strong>Input:</strong> times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//<strong>Output:</strong> 2
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> times = [[1,2,1]], n = 2, k = 1
//<strong>Output:</strong> 1
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> times = [[1,2,1]], n = 2, k = 2
//<strong>Output:</strong> -1
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= k &lt;= n &lt;= 100</code></li> 
// <li><code>1 &lt;= times.length &lt;= 6000</code></li> 
// <li><code>times[i].length == 3</code></li> 
// <li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li> 
// <li><code>u<sub>i</sub> != v<sub>i</sub></code></li> 
// <li><code>0 &lt;= w<sub>i</sub> &lt;= 100</code></li> 
// <li>All the pairs <code>(u<sub>i</sub>, v<sub>i</sub>)</code> are <strong>unique</strong>. (i.e., no multiple edges.)</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 最短路 | 堆（优先队列）</details><br>
//
//<div>👍 596, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Network Delay Time
 *
 * @author DY
 * @date 2022-09-22 19:22:12
 */
public class P743_NetworkDelayTime {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P743_NetworkDelayTime().new Solution();
        System.out.println(solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            List<int[]>[] graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : times) {
                graph[edge[0]].add(new int[]{edge[1], edge[2]});
            }

            int[] disTo = dijkstra(k, graph);

            int res = 0;
            for (int i = 1; i < disTo.length; i++) {
                if (disTo[i] == Integer.MAX_VALUE) {
                    return -1;
                }
                res = Integer.max(res, disTo[i]);
            }
            return res;
        }

        private int[] dijkstra(int start, List<int[]>[] graph) {
            int[] disTo = new int[graph.length]; // disTo[i] ==> start -> to 的最短距离
            Arrays.fill(disTo, Integer.MAX_VALUE);
            // 二元组 int[] {id, disToId}
            Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((o) -> o[1]));
            disTo[start] = 0;
            queue.offer(new int[]{start, disTo[start]});

            while (!queue.isEmpty()) {
                int[] item = queue.poll();
                int id = item[0];
                int disToId = item[1];

                if (disToId > disTo[id]) {
                    continue;
                }

                for (int[] neighbor : graph[id]) {
                    int neighborId = neighbor[0];
                    int disToNeighborId = disTo[id] + neighbor[1];
                    if (disToNeighborId < disTo[neighborId]) {
                        disTo[neighborId] = disToNeighborId;
                        queue.offer(new int[]{neighborId, disToNeighborId});
                    }
                }
            }
            return disTo;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
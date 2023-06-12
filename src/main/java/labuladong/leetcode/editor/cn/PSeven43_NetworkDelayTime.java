/**
 * <p>You are given a network of <code>n</code> nodes, labeled from <code>1</code> to <code>n</code>. You are also given <code>times</code>, a list of travel times as directed edges <code>times[i] = (u<sub>i</sub>, v<sub>i</sub>, w<sub>i</sub>)</code>, where <code>u<sub>i</sub></code> is the source node, <code>v<sub>i</sub></code> is the target node, and <code>w<sub>i</sub></code> is the time it takes for a signal to travel from source to target.</p>
 *
 * <p>We will send a signal from a given node <code>k</code>. Return <em>the <strong>minimum</strong> time it takes for all the</em> <code>n</code> <em>nodes to receive the signal</em>. If it is impossible for all the <code>n</code> nodes to receive the signal, return <code>-1</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png" style="width: 217px; height: 239px;" />
 * <pre>
 * <strong>Input:</strong> times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * <strong>Output:</strong> 2
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> times = [[1,2,1]], n = 2, k = 1
 * <strong>Output:</strong> 1
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> times = [[1,2,1]], n = 2, k = 2
 * <strong>Output:</strong> -1
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= k &lt;= n &lt;= 100</code></li>
 * <li><code>1 &lt;= times.length &lt;= 6000</code></li>
 * <li><code>times[i].length == 3</code></li>
 * <li><code>1 &lt;= u<sub>i</sub>, v<sub>i</sub> &lt;= n</code></li>
 * <li><code>u<sub>i</sub> != v<sub>i</sub></code></li>
 * <li><code>0 &lt;= w<sub>i</sub> &lt;= 100</code></li>
 * <li>All the pairs <code>(u<sub>i</sub>, v<sub>i</sub>)</code> are <strong>unique</strong>. (i.e., no multiple edges.)</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 最短路 | 堆（优先队列）</details><br>
 *
 * <div>👍 671, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Network Delay Time
 *
 * @author DY
 * @date 2023-06-12 16:58:20
 */
public class PSeven43_NetworkDelayTime {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven43_NetworkDelayTime().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            List<int[]>[] graph = buildGraph(times, n);
            int[] disTo = dijkstra(k, graph);
            int res = 0;
            for (int i = 1; i < n + 1; i++) {
                if (disTo[i] == Integer.MAX_VALUE) {
                    return -1;
                }
                res = Math.max(res, disTo[i]);
            }
            return res;
        }

        private int[] dijkstra(int start, List<int[]>[] graph) {
            int v = graph.length; // 节点个数
            int[] disTo = new int[v]; // disTo[i] start节点 -》 i节点的最短距离
            Arrays.fill(disTo, Integer.MAX_VALUE);
            disTo[start] = 0;
            Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            queue.offer(new int[]{start, 0});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curId = cur[0];
                int startToCurDis = cur[1]; // start节点 -》 cur节点的最短距离

                if (startToCurDis > disTo[curId]) { // 已经有一条更短的路径到达 curNode 节点了
                    continue;
                }

                for (int[] neighbor : graph[curId]) {
                    int neighborId = neighbor[0];
                    int startToNeighborDis = disTo[curId] + neighbor[1];
                    if (startToNeighborDis < disTo[neighborId]) {
                        disTo[neighborId] = startToNeighborDis; // 更新 dp table
                        queue.offer(new int[]{neighborId, startToNeighborDis}); // 将这个节点以及距离放入队列
                    }
                }
            }
            return disTo;
        }

        private List<int[]>[] buildGraph(int[][] times, int n) {
            List<int[]>[] graph = new LinkedList[n + 1]; // 节点从1开始
            for (int i = 1; i < n + 1; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                graph[from].add(new int[]{to, weight});
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

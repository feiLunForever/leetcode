/**
 * <p>You are given an undirected weighted graph of&nbsp;<code>n</code>&nbsp;nodes (0-indexed), represented by an edge list where&nbsp;<code>edges[i] = [a, b]</code>&nbsp;is an undirected edge connecting the nodes&nbsp;<code>a</code>&nbsp;and&nbsp;<code>b</code>&nbsp;with a probability of success of traversing that edge&nbsp;<code>succProb[i]</code>.</p>
 *
 * <p>Given two nodes&nbsp;<code>start</code>&nbsp;and&nbsp;<code>end</code>, find the path with the maximum probability of success to go from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>&nbsp;and return its success probability.</p>
 *
 * <p>If there is no path from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>, <strong>return&nbsp;0</strong>. Your answer will be accepted if it differs from the correct answer by at most <strong>1e-5</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex1.png" style="width: 187px; height: 186px;" /></strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
 * <strong>Output:</strong> 0.25000
 * <strong>Explanation:</strong>&nbsp;There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex2.png" style="width: 189px; height: 186px;" /></strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
 * <strong>Output:</strong> 0.30000
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex3.png" style="width: 215px; height: 191px;" /></strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
 * <strong>Output:</strong> 0.00000
 * <strong>Explanation:</strong>&nbsp;There is no path between 0 and 2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= n &lt;= 10^4</code></li>
 * <li><code>0 &lt;= start, end &lt; n</code></li>
 * <li><code>start != end</code></li>
 * <li><code>0 &lt;= a, b &lt; n</code></li>
 * <li><code>a != b</code></li>
 * <li><code>0 &lt;= succProb.length == edges.length &lt;= 2*10^4</code></li>
 * <li><code>0 &lt;= succProb[i] &lt;= 1</code></li>
 * <li>There is at most one edge between every two nodes.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>图 | 数组 | 最短路 | 堆（优先队列）</details><br>
 *
 * <div>👍 126, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Path with Maximum Probability
 *
 * @author DY
 * @date 2023-06-12 18:59:43
 */
public class POne514_PathWithMaximumProbability {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne514_PathWithMaximumProbability().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            List<double[]>[] graph = buildGraph(n, edges, succProb);
            double[] cost = new double[n]; // cost[i] : 节点 start 到达节点 i 的最大概率
            Arrays.fill(cost, -1); // dp table 初始化为一个取不到的最小值
            cost[start] = 1; // base case，start 到 start 的概率就是 1

            Queue<double[]> queue = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
            queue.add(new double[]{start, cost[start]});

            while (!queue.isEmpty()) {
                double[] cur = queue.poll();
                int id = (int) cur[0];
                double v = cur[1];

                if (id == end) { // 遇到终点提前返回
                    return v;
                }

                if (v < cost[id]) { // 已经有一条概率更大的路径到达 curNode 节点了
                    continue;
                }

                for (double[] neighbor : graph[id]) { // 将 curNode 的相邻节点装入队列
                    int neighborId = (int) neighbor[0];
                    double neighborV = cost[id] * neighbor[1];
                    if (neighborV > cost[neighborId]) {
                        cost[neighborId] = neighborV;
                        queue.add(new double[]{neighborId, neighborV});
                    }
                }
            }
            return 0.0f;
        }

        private List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
            List<double[]>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                double value = succProb[i];
                graph[from].add(new double[]{to, value}); // 无向图就是双向图
                graph[to].add(new double[]{from, value});
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

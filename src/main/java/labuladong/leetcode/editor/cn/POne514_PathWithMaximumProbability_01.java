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
 * <div>👍 141, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Path with Maximum Probability
 *
 * @author DY
 * @date 2023-11-14 15:06:22
 */
public class POne514_PathWithMaximumProbability_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne514_PathWithMaximumProbability_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            List<double[]>[] graph = buildGraph(n, edges, succProb);
            double[] cost = new double[n];
            Arrays.fill(cost, -1);
            cost[start_node] = 1;
            Queue<double[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
            q.offer(new double[]{start_node, cost[start_node]});

            while (!q.isEmpty()) {
                double[] cur = q.poll();
                int curId = (int) cur[0];
                double w = cur[1];
                if (curId == end_node) {
                    return w;
                }
                if (w < cost[curId]) {
                    continue;
                }
                for (double[] neighbor : graph[curId]) {
                    int neighborId = (int) neighbor[0];
                    double neighborW = cost[curId] * neighbor[1];
                    if (neighborW > cost[neighborId]) {
                        cost[neighborId] = neighborW;
                        q.offer(new double[]{neighborId, neighborW});
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
                double weight = succProb[i];
                graph[from].add(new double[]{to, weight});
                graph[to].add(new double[]{from, weight});
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

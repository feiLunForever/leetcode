//<p>You are given an undirected weighted graph of&nbsp;<code>n</code>&nbsp;nodes (0-indexed), represented by an edge list where&nbsp;<code>edges[i] = [a, b]</code>&nbsp;is an undirected edge connecting the nodes&nbsp;<code>a</code>&nbsp;and&nbsp;<code>b</code>&nbsp;with a probability of success of traversing that edge&nbsp;<code>succProb[i]</code>.</p>
//
//<p>Given two nodes&nbsp;<code>start</code>&nbsp;and&nbsp;<code>end</code>, find the path with the maximum probability of success to go from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>&nbsp;and return its success probability.</p>
//
//<p>If there is no path from&nbsp;<code>start</code>&nbsp;to&nbsp;<code>end</code>, <strong>return&nbsp;0</strong>. Your answer will be accepted if it differs from the correct answer by at most <strong>1e-5</strong>.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex1.png" style="width: 187px; height: 186px;" /></strong></p>
//
//<pre>
//<strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
//<strong>Output:</strong> 0.25000
//<strong>Explanation:</strong>&nbsp;There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex2.png" style="width: 189px; height: 186px;" /></strong></p>
//
//<pre>
//<strong>Input:</strong> n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
//<strong>Output:</strong> 0.30000
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/09/20/1558_ex3.png" style="width: 215px; height: 191px;" /></strong></p>
//
//<pre>
//<strong>Input:</strong> n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//<strong>Output:</strong> 0.00000
//<strong>Explanation:</strong>&nbsp;There is no path between 0 and 2.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>2 &lt;= n &lt;= 10^4</code></li> 
// <li><code>0 &lt;= start, end &lt; n</code></li> 
// <li><code>start != end</code></li> 
// <li><code>0 &lt;= a, b &lt; n</code></li> 
// <li><code>a != b</code></li> 
// <li><code>0 &lt;= succProb.length == edges.length &lt;= 2*10^4</code></li> 
// <li><code>0 &lt;= succProb[i] &lt;= 1</code></li> 
// <li>There is at most one edge between every two nodes.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>图 | 最短路 | 堆（优先队列）</details><br>
//
//<div>👍 110, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Path with Maximum Probability
 *
 * @author DY
 * @date 2022-09-26 19:29:31
 */
public class P1514_PathWithMaximumProbability {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1514_PathWithMaximumProbability().new Solution();
        System.out.println(solution.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
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

            double[] disTo = new double[graph.length];

            disTo[start] = 1;
            Queue<double[]> queue = new PriorityQueue<double[]>((a, b) -> Double.compare(b[1], a[1]));
            queue.add(new double[]{start, disTo[start]});

            while (!queue.isEmpty()) {
                double[] item = queue.poll();
                int id = (int) item[0];
                double disToId = item[1];

                if (id == end) {
                    return disToId;
                }

                if (disToId < disTo[id]) {
                    continue;
                }

                for (double[] neighbor : graph[id]) {
                    int next = (int) neighbor[0];
                    double disToNext = disTo[id] * neighbor[1];
                    if (disToNext > disTo[next]) {
                        disTo[next] = disToNext;
                        queue.offer(new double[]{next, disToNext});
                    }
                }

            }

            return 0.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
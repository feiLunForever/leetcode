/**
 * <p>There are <code>n</code> cities connected by some number of flights. You are given an array <code>flights</code> where <code>flights[i] = [from<sub>i</sub>, to<sub>i</sub>, price<sub>i</sub>]</code> indicates that there is a flight from city <code>from<sub>i</sub></code> to city <code>to<sub>i</sub></code> with cost <code>price<sub>i</sub></code>.</p>
 *
 * <p>You are also given three integers <code>src</code>, <code>dst</code>, and <code>k</code>, return <em><strong>the cheapest price</strong> from </em><code>src</code><em> to </em><code>dst</code><em> with at most </em><code>k</code><em> stops. </em>If there is no such route, return<em> </em><code>-1</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-3drawio.png" style="width: 332px; height: 392px;" />
 * <pre>
 * <strong>Input:</strong> n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * <strong>Output:</strong> 700
 * <strong>Explanation:</strong>
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-1drawio.png" style="width: 332px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * <strong>Output:</strong> 200
 * <strong>Explanation:</strong>
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-2drawio.png" style="width: 332px; height: 242px;" />
 * <pre>
 * <strong>Input:</strong> n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * <strong>Output:</strong> 500
 * <strong>Explanation:</strong>
 * The graph is shown above.
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 100</code></li>
 * <li><code>0 &lt;= flights.length &lt;= (n * (n - 1) / 2)</code></li>
 * <li><code>flights[i].length == 3</code></li>
 * <li><code>0 &lt;= from<sub>i</sub>, to<sub>i</sub> &lt; n</code></li>
 * <li><code>from<sub>i</sub> != to<sub>i</sub></code></li>
 * <li><code>1 &lt;= price<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
 * <li>There will not be any multiple flights between two cities.</li>
 * <li><code>0 &lt;= src, dst, k &lt; n</code></li>
 * <li><code>src != dst</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 动态规划 | 最短路 | 堆（优先队列）</details><br>
 *
 * <div>👍 585, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Cheapest Flights Within K Stops
 *
 * @author DY
 * @date 2023-06-21 14:30:18
 */
public class PSeven87_CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven87_CheapestFlightsWithinKStops().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            Map<Integer, List<int[]>> inDegree = new HashMap<>();
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int weight = flight[2];
                List<int[]> item = inDegree.computeIfAbsent(to, o -> new LinkedList<>());
                item.add(new int[]{from, weight});
            }

            int[][] memo = new int[n][k + 1];
            for (int[] row : memo) {
                Arrays.fill(row, -999);
            }

            return dp(src, dst, inDegree, k, memo);
        }

        /**
         * 从 src 出发，k 步之内到达 s 的最短路径权重
         *
         * @param src
         * @param s
         * @param inDegree
         * @param k
         * @param memo
         * @return
         */
        private int dp(int src, int s, Map<Integer, List<int[]>> inDegree, int k, int[][] memo) {
            if (src == s) return 0;
            if (k < 0) return -1;

            if (memo[s][k] != -999) return memo[s][k];

            int res = Integer.MAX_VALUE;
            if (inDegree.containsKey(s)) { // 当 s 有入度节点时，分解为子问题
                for (int[] v : inDegree.get(s)) {
                    int from = v[0];
                    int weight = v[1];
                    int subProblem = dp(src, from, inDegree, k - 1, memo);
                    if (subProblem != -1) {
                        res = Math.min(res, subProblem + weight);
                    }
                }
            }
            memo[s][k] = res == Integer.MAX_VALUE ? -1 : res; // 如果还是初始值，说明此节点不可达
            return memo[s][k];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

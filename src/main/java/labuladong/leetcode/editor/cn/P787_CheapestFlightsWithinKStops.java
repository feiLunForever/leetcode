//<p>There are <code>n</code> cities connected by some number of flights. You are given an array <code>flights</code> where <code>flights[i] = [from<sub>i</sub>, to<sub>i</sub>, price<sub>i</sub>]</code> indicates that there is a flight from city <code>from<sub>i</sub></code> to city <code>to<sub>i</sub></code> with cost <code>price<sub>i</sub></code>.</p>
//
//<p>You are also given three integers <code>src</code>, <code>dst</code>, and <code>k</code>, return <em><strong>the cheapest price</strong> from </em><code>src</code><em> to </em><code>dst</code><em> with at most </em><code>k</code><em> stops. </em>If there is no such route, return<em> </em><code>-1</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-3drawio.png" style="width: 332px; height: 392px;" /> 
//<pre>
//<strong>Input:</strong> n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
//<strong>Output:</strong> 700
//<strong>Explanation:</strong>
//The graph is shown above.
//The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
//Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-1drawio.png" style="width: 332px; height: 242px;" /> 
//<pre>
//<strong>Input:</strong> n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
//<strong>Output:</strong> 200
//<strong>Explanation:</strong>
//The graph is shown above.
//The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
//</pre>
//
//<p><strong class="example">Example 3:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2022/03/18/cheapest-flights-within-k-stops-2drawio.png" style="width: 332px; height: 242px;" /> 
//<pre>
//<strong>Input:</strong> n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
//<strong>Output:</strong> 500
//<strong>Explanation:</strong>
//The graph is shown above.
//The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= n &lt;= 100</code></li> 
// <li><code>0 &lt;= flights.length &lt;= (n * (n - 1) / 2)</code></li> 
// <li><code>flights[i].length == 3</code></li> 
// <li><code>0 &lt;= from<sub>i</sub>, to<sub>i</sub> &lt; n</code></li> 
// <li><code>from<sub>i</sub> != to<sub>i</sub></code></li> 
// <li><code>1 &lt;= price<sub>i</sub> &lt;= 10<sup>4</sup></code></li> 
// <li>There will not be any multiple flights between two cities.</li> 
// <li><code>0 &lt;= src, dst, k &lt; n</code></li> 
// <li><code>src != dst</code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 动态规划 | 最短路 | 堆（优先队列）</details><br>
//
//<div>👍 533, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Cheapest Flights Within K Stops
 *
 * @author DY
 * @date 2022-10-25 21:39:57
 */
public class P787_CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P787_CheapestFlightsWithinKStops().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // to -> [from, price]
            HashMap<Integer, List<int[]>> graph = buildGraph(flights);
            int[][] cache = new int[n][k + 2]; // k 代表次数，k+1 代表可以转的次数，一共[0,k+1] 共 k+2
            for (int[] array : cache) {
                Arrays.fill(array, -9999);
            }
            return dp(src, dst, k + 1, graph, cache);
        }

        private int dp(int src, int dst, int k, HashMap<Integer, List<int[]>> graph, int[][] cache) {
            if (src == dst) return 0;
            if (k == 0) return -1;
            if (cache[dst][k] != -9999) return cache[dst][k];
            int res = Integer.MAX_VALUE;
            if (graph.containsKey(dst)) {
                for (int[] v : graph.get(dst)) {
                    int from = v[0];
                    int price = v[1];
                    int subProblem = dp(src, from, k - 1, graph, cache);
                    if (subProblem != -1) {
                        res = Math.min(res, subProblem + price);
                    }
                }
            }
            return cache[dst][k] = res == Integer.MAX_VALUE ? -1 : res;
        }

        private HashMap<Integer, List<int[]>> buildGraph(int[][] flights) {
            HashMap<Integer, List<int[]>> graph = new HashMap<>();
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                graph.putIfAbsent(to, new LinkedList<>());
                graph.get(to).add(new int[]{from, price});
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
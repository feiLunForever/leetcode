//<p>You are given an array <code>points</code> representing integer coordinates of some points on a 2D-plane, where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>.</p>
//
//<p>The cost of connecting two points <code>[x<sub>i</sub>, y<sub>i</sub>]</code> and <code>[x<sub>j</sub>, y<sub>j</sub>]</code> is the <strong>manhattan distance</strong> between them: <code>|x<sub>i</sub> - x<sub>j</sub>| + |y<sub>i</sub> - y<sub>j</sub>|</code>, where <code>|val|</code> denotes the absolute value of <code>val</code>.</p>
//
//<p>Return <em>the minimum cost to make all points connected.</em> All points are connected if there is <strong>exactly one</strong> simple path between any two points.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/26/d.png" style="width: 214px; height: 268px;" /> 
//<pre>
//<strong>Input:</strong> points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//<strong>Output:</strong> 20
//<strong>Explanation:</strong> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/08/26/c.png" style="width: 214px; height: 268px;" />
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> points = [[3,12],[-2,5],[-4,1]]
//<strong>Output:</strong> 18
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= points.length &lt;= 1000</code></li> 
// <li><code>-10<sup>6</sup> &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>6</sup></code></li> 
// <li>All pairs <code>(x<sub>i</sub>, y<sub>i</sub>)</code> are distinct.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>并查集 | 数组 | 最小生成树</details><br>
//
//<div>👍 240, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Min Cost to Connect All Points
 *
 * @author DY
 * @date 2022-09-21 19:24:31
 */
public class P1584_MinCostToConnectAllPoints {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1584_MinCostToConnectAllPoints().new Solution();
        System.out.println(solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostConnectPoints1(int[][] points) {
            int n = points.length;
            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < n; i++) { // 构建边
                for (int j = i + 1; j < n; j++) {
                    int x0 = points[i][0], y0 = points[i][1];
                    int x1 = points[j][0], y1 = points[j][1];
                    int weight = Math.abs(x0 - x1) + Math.abs(y0 - y1);
                    edges.add(new int[]{i, j, weight});
                }
            }
            edges.sort(Comparator.comparingInt(o -> o[2])); // 按照权重升序
            UnionFind un = new UnionFind(n);
            int total = 0;
            for (int[] edge : edges) {
                int p = edge[0];
                int q = edge[1];
                int weight = edge[2];
                if (un.connected(p, q)) { // q,q两节点已经是连通的，会产生环，不能加入到结果中
                    continue;
                }
                un.union(p, q);
                total += weight;
            }
            return total;
        }

        public int minCostConnectPoints(int[][] points) {
            List<int[]>[] graph = buildGraph(points);
            Prim prim = new Prim(graph);
            return prim.weight();
        }

        private List<int[]>[] buildGraph(int[][] points) {
            List<int[]>[] graph = new LinkedList[points.length];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int x0 = points[i][0], y0 = points[i][1];
                    int x1 = points[j][0], y1 = points[j][1];
                    int weight = Math.abs(x0 - x1) + Math.abs(y0 - y1);
                    graph[i].add(new int[]{i, j, weight});
                    graph[j].add(new int[]{j, i, weight});
                }
            }
            return graph;
        }


        public class UnionFind {
            public int count; // 连通分量个数
            public final int[] parent; // 记录每个节点的父节点

            public UnionFind(int count) {
                this.count = count;
                this.parent = new int[count];
                for (int i = 0; i < count; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    parent[rootP] = rootQ;
                    count--;
                }
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            public int count() {
                return this.count;
            }
        }

        public class Prim {
            // 三元组 int[]{from, to, weight} 表示一条边
            private final PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2])); // 存储横切边的优先级队列

            private boolean[] visited; // 记录该节点是否成为最小生成树中

            private int total;

            private List<int[]>[] graph; // 邻接表，graph[s] 代表s节点所有相邻的边

            public Prim(List<int[]>[] graph) {
                this.graph = graph;
                int n = graph.length;
                visited = new boolean[n];

                // 从第一个节点开始切割
                visited[0] = true;
                cut(0); // 将节点s的横边加入队列中
                while (!queue.isEmpty()) { // 不断进行切分，向最小生成树中添加边
                    int[] edge = queue.poll();
                    int to = edge[1];
                    if (visited[to]) {
                        continue;
                    }
                    total += edge[2];
                    visited[to] = true;
                    cut(to); // 节点 to 加入后，进行新一轮切分，会产生更多横切边
                }
            }

            public void cut(int s) {
                // 遍历s的邻边
                for (int[] edge : graph[s]) {
                    int from = edge[0];
                    int to = edge[1];
                    int weight = edge[2];
                    if (visited[to]) { // 相邻接点 to 已经在最小生成树中，跳过，否则这条边会产生环
                        continue;
                    }
                    queue.offer(edge);
                }
            }

            public int weight() {
                return total;
            }

            public boolean allConnected() {
                for (boolean visit : visited) {
                    if (!visit) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
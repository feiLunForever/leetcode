/**
 * <p>You are given an array <code>points</code> representing integer coordinates of some points on a 2D-plane, where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>.</p>
 *
 * <p>The cost of connecting two points <code>[x<sub>i</sub>, y<sub>i</sub>]</code> and <code>[x<sub>j</sub>, y<sub>j</sub>]</code> is the <strong>manhattan distance</strong> between them: <code>|x<sub>i</sub> - x<sub>j</sub>| + |y<sub>i</sub> - y<sub>j</sub>|</code>, where <code>|val|</code> denotes the absolute value of <code>val</code>.</p>
 *
 * <p>Return <em>the minimum cost to make all points connected.</em> All points are connected if there is <strong>exactly one</strong> simple path between any two points.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/26/d.png" style="width: 214px; height: 268px;" />
 * <pre>
 * <strong>Input:</strong> points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * <strong>Output:</strong> 20
 * <strong>Explanation:</strong>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/08/26/c.png" style="width: 214px; height: 268px;" />
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> points = [[3,12],[-2,5],[-4,1]]
 * <strong>Output:</strong> 18
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= points.length &lt;= 1000</code></li>
 * <li><code>-10<sup>6</sup> &lt;= x<sub>i</sub>, y<sub>i</sub> &lt;= 10<sup>6</sup></code></li>
 * <li>All pairs <code>(x<sub>i</sub>, y<sub>i</sub>)</code> are distinct.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>并查集 | 图 | 数组 | 最小生成树</details><br>
 *
 * <div>👍 283, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Min Cost to Connect All Points
 *
 * @author DY
 * @date 2023-06-09 15:19:58
 */
public class POne584_MinCostToConnectAllPoints {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne584_MinCostToConnectAllPoints().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class UF {
            private int count;
            private int[] parent;

            public UF(int n) {
                this.count = n;
                this.parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP != rootQ) {
                    parent[rootP] = rootQ;
                    --count;
                }
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }
        }

        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            List<int[]> edges = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
                }
            }
            edges.sort((a, b) -> a[2] - b[2]);

            int sum = 0;
            UF uf = new UF(n);
            for (int[] edge : edges) {
                if (uf.connected(edge[0], edge[1])) {
                    continue;
                }
                sum += edge[2];
                uf.union(edge[0], edge[1]);
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

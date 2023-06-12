/**
 * <p>You are a hiker preparing for an upcoming hike. You are given <code>heights</code>, a 2D array of size <code>rows x columns</code>, where <code>heights[row][col]</code> represents the height of cell <code>(row, col)</code>. You are situated in the top-left cell, <code>(0, 0)</code>, and you hope to travel to the bottom-right cell, <code>(rows-1, columns-1)</code> (i.e.,&nbsp;<strong>0-indexed</strong>). You can move <strong>up</strong>, <strong>down</strong>, <strong>left</strong>, or <strong>right</strong>, and you wish to find a route that requires the minimum <strong>effort</strong>.</p>
 *
 * <p>A route's <strong>effort</strong> is the <strong>maximum absolute difference</strong><strong> </strong>in heights between two consecutive cells of the route.</p>
 *
 * <p>Return <em>the minimum <strong>effort</strong> required to travel from the top-left cell to the bottom-right cell.</em></p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/04/ex1.png" style="width: 300px; height: 300px;" /></p>
 *
 * <pre>
 * <strong>Input:</strong> heights = [[1,2,2],[3,8,2],[5,3,5]]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2020/10/04/ex2.png" style="width: 300px; height: 300px;" /></p>
 *
 * <pre>
 * <strong>Input:</strong> heights = [[1,2,3],[3,8,4],[5,3,5]]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/04/ex3.png" style="width: 300px; height: 300px;" />
 * <pre>
 * <strong>Input:</strong> heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> This route does not require any effort.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>rows == heights.length</code></li>
 * <li><code>columns == heights[i].length</code></li>
 * <li><code>1 &lt;= rows, columns &lt;= 100</code></li>
 * <li><code>1 &lt;= heights[i][j] &lt;= 10<sup>6</sup></code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 并查集 | 数组 | 二分查找 | 矩阵 | 堆（优先队列）</details><br>
 *
 * <div>👍 361, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Path With Minimum Effort
 *
 * @author DY
 * @date 2023-06-12 17:56:43
 */
public class POne631_PathWithMinimumEffort {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne631_PathWithMinimumEffort().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int minimumEffortPath(int[][] heights) {
            int m = heights.length, n = heights[0].length;
            int[][] cost = new int[m][n]; // (0,0) -> (i,j) 最小体力消耗
            for (int i = 0; i < m; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }
            // int[]{x, y, cost}
            Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            cost[0][0] = 0;
            queue.offer(new int[]{0, 0, cost[0][0]});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int xyCost = cur[2];

                if (x == m - 1 && y == n - 1) {
                    return xyCost;
                }

                if (xyCost > cost[x][y]) {
                    continue;
                }

                for (int[] neighbor : buildNeighbor(heights, x, y)) {
                    int nextX = neighbor[0];
                    int nextY = neighbor[1];
                    int nextCost = Math.max(cost[x][y], Math.abs(heights[x][y] - heights[nextX][nextY]));
                    if (nextCost < cost[nextX][nextY]) {
                        cost[nextX][nextY] = nextCost;
                        queue.offer(new int[]{nextX, nextY, nextCost});
                    }
                }
            }
            return -1;
        }

        private List<int[]> buildNeighbor(int[][] heights, int x, int y) {
            int m = heights.length, n = heights[0].length;
            List<int[]> res = new ArrayList<>(4);
            for (int[] dir : dirs) {
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n) {
                    continue;
                }
                res.add(new int[]{x1, y1});
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

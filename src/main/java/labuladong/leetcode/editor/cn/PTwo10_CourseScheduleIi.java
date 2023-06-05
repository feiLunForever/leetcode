/**
 * <p>There are a total of <code>numCourses</code> courses you have to take, labeled from <code>0</code> to <code>numCourses - 1</code>. You are given an array <code>prerequisites</code> where <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that you <strong>must</strong> take course <code>b<sub>i</sub></code> first if you want to take course <code>a<sub>i</sub></code>.</p>
 *
 * <ul>
 * <li>For example, the pair <code>[0, 1]</code>, indicates that to take course <code>0</code> you have to first take course <code>1</code>.</li>
 * </ul>
 *
 * <p>Return <em>the ordering of courses you should take to finish all courses</em>. If there are many valid answers, return <strong>any</strong> of them. If it is impossible to finish all courses, return <strong>an empty array</strong>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numCourses = 2, prerequisites = [[1,0]]
 * <strong>Output:</strong> [0,1]
 * <strong>Explanation:</strong> There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * <strong>Output:</strong> [0,2,1,3]
 * <strong>Explanation:</strong> There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numCourses = 1, prerequisites = []
 * <strong>Output:</strong> [0]
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= numCourses &lt;= 2000</code></li>
 * <li><code>0 &lt;= prerequisites.length &lt;= numCourses * (numCourses - 1)</code></li>
 * <li><code>prerequisites[i].length == 2</code></li>
 * <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li>
 * <li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
 * <li>All the pairs <code>[a<sub>i</sub>, b<sub>i</sub>]</code> are <strong>distinct</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序</details><br>
 *
 * <div>👍 778, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Course Schedule II
 *
 * @author DY
 * @date 2023-06-05 14:22:14
 */
public class PTwo10_CourseScheduleIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo10_CourseScheduleIi().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            int[] inDegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                ++inDegree[edge[0]];
            }
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
            int index = 0;
            int[] res = new int[numCourses];
            while (!q.isEmpty()) {
                Integer cur = q.poll();
                res[index++] = cur;
                for (int next : graph[cur]) {
                    --inDegree[next];
                    if (inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            return index != numCourses ? new int[]{} : res;
        }

        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                graph[edge[1]].add(edge[0]);
            }
            return graph;
        }

        /**private boolean[] used;

         private boolean[] onPath;

         boolean hasCycle;

         List<Integer> postOrder = new LinkedList<>();

         public int[] findOrder(int numCourses, int[][] prerequisites) {
         used = new boolean[numCourses];
         onPath = new boolean[numCourses];

         List<Integer>[] graph = buildGraph(numCourses, prerequisites);

         for (int i = 0; i < numCourses; i++) {
         traverse(graph, i);
         }

         if (hasCycle) return new int[]{};

         int[] res = new int[postOrder.size()];
         for (int i = 0; i < numCourses; i++) {
         res[i] = postOrder.get(postOrder.size() - i - 1);
         }

         return res;
         }

         private void traverse(List<Integer>[] graph, int s) {
         if (onPath[s]) hasCycle = true;
         if (used[s] || hasCycle) return;
         onPath[s] = true;
         used[s] = true;
         for (int t : graph[s]) {
         traverse(graph, t);
         }
         postOrder.add(s);
         onPath[s] = false;
         }

         private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
         List<Integer>[] graph = new LinkedList[numCourses];
         for (int i = 0; i < numCourses; i++) {
         graph[i] = new LinkedList<>();
         }
         for (int[] edge : prerequisites) {
         graph[edge[1]].add(edge[0]);
         }
         return graph;
         }**/
    }
//leetcode submit region end(Prohibit modification and deletion)

}

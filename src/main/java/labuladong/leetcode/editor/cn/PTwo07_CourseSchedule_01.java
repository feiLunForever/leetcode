/**
 * <p>There are a total of <code>numCourses</code> courses you have to take, labeled from <code>0</code> to <code>numCourses - 1</code>. You are given an array <code>prerequisites</code> where <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that you <strong>must</strong> take course <code>b<sub>i</sub></code> first if you want to take course <code>a<sub>i</sub></code>.</p>
 *
 * <ul>
 * <li>For example, the pair <code>[0, 1]</code>, indicates that to take course <code>0</code> you have to first take course <code>1</code>.</li>
 * </ul>
 *
 * <p>Return <code>true</code> if you can finish all courses. Otherwise, return <code>false</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numCourses = 2, prerequisites = [[1,0]]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> numCourses = 2, prerequisites = [[1,0],[0,1]]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= numCourses &lt;= 2000</code></li>
 * <li><code>0 &lt;= prerequisites.length &lt;= 5000</code></li>
 * <li><code>prerequisites[i].length == 2</code></li>
 * <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li>
 * <li>All the pairs prerequisites[i] are <strong>unique</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序</details><br>
 *
 * <div>👍 1822, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Course Schedule
 *
 * @author DY
 * @date 2023-11-09 11:11:46
 */
public class PTwo07_CourseSchedule_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo07_CourseSchedule_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);

            int[] inDegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                inDegree[to]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }

            int count = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                ++count;
                for (int next : graph[cur]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            return count == numCourses;
        }


        public boolean canFinish1(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            boolean[] visited = new boolean[numCourses];
            boolean[] onPath = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (traverse(graph, i, onPath, visited)) return false;
            }

            return true;
        }

        private boolean traverse(List<Integer>[] graph, int x, boolean[] onPath, boolean[] visited) {
            if (onPath[x]) return true;
            if (visited[x]) return false;
            visited[x] = true;
            onPath[x] = true;

            for (int v : graph[x]) {
                if (traverse(graph, v, onPath, visited)) return true;
            }
            onPath[x] = false;
            return false;
        }

        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

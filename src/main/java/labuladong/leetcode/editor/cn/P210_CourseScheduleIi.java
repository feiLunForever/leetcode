//<p>There are a total of <code>numCourses</code> courses you have to take, labeled from <code>0</code> to <code>numCourses - 1</code>. You are given an array <code>prerequisites</code> where <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that you <strong>must</strong> take course <code>b<sub>i</sub></code> first if you want to take course <code>a<sub>i</sub></code>.</p>
//
//<ul> 
// <li>For example, the pair <code>[0, 1]</code>, indicates that to take course <code>0</code> you have to first take course <code>1</code>.</li> 
//</ul>
//
//<p>Return <em>the ordering of courses you should take to finish all courses</em>. If there are many valid answers, return <strong>any</strong> of them. If it is impossible to finish all courses, return <strong>an empty array</strong>.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> numCourses = 2, prerequisites = [[1,0]]
//<strong>Output:</strong> [0,1]
//<strong>Explanation:</strong> There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//<strong>Output:</strong> [0,2,1,3]
//<strong>Explanation:</strong> There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> numCourses = 1, prerequisites = []
//<strong>Output:</strong> [0]
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= numCourses &lt;= 2000</code></li> 
// <li><code>0 &lt;= prerequisites.length &lt;= numCourses * (numCourses - 1)</code></li> 
// <li><code>prerequisites[i].length == 2</code></li> 
// <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li> 
// <li><code>a<sub>i</sub> != b<sub>i</sub></code></li> 
// <li>All the pairs <code>[a<sub>i</sub>, b<sub>i</sub>]</code> are <strong>distinct</strong>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序</details><br>
//
//<div>👍 705, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Course Schedule II
 *
 * @author DY
 * @date 2022-09-19 18:46:45
 */
public class P210_CourseScheduleIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P210_CourseScheduleIi().new Solution();
		System.out.println(solution.findOrder(2, new int[][]{}));
	}

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean hasCycle = false;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            boolean[] visited = new boolean[numCourses];
            boolean[] onPath = new boolean[numCourses];
            List<Integer> postOrder = new LinkedList<>(); // 后序遍历结果

            for (int i = 0; i < numCourses; i++) {
                traverse(graph, i, visited, onPath, postOrder);
            }

            if (hasCycle) {
                return new int[]{};
            }

            // 逆后序遍历结果即为拓扑排序结果
            Collections.reverse(postOrder);
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = postOrder.get(i);
            }
            return res;
        }

        private void traverse(List<Integer>[] graph, int index, boolean[] visited, boolean[] onPath, List<Integer> postOrder) {
            if (onPath[index]) {
                hasCycle = true;
                return;
            }
            if (visited[index]) {
                return;
            }
            visited[index] = true;
            onPath[index] = true;
            for (int t : graph[index]) {
                traverse(graph, t, visited, onPath, postOrder);
            }
            onPath[index] = false;
            postOrder.add(index);
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
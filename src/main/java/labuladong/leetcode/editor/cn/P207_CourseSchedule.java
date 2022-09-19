//<p>There are a total of <code>numCourses</code> courses you have to take, labeled from <code>0</code> to <code>numCourses - 1</code>. You are given an array <code>prerequisites</code> where <code>prerequisites[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that you <strong>must</strong> take course <code>b<sub>i</sub></code> first if you want to take course <code>a<sub>i</sub></code>.</p>
//
//<ul> 
// <li>For example, the pair <code>[0, 1]</code>, indicates that to take course <code>0</code> you have to first take course <code>1</code>.</li> 
//</ul>
//
//<p>Return <code>true</code> if you can finish all courses. Otherwise, return <code>false</code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> numCourses = 2, prerequisites = [[1,0]]
//<strong>Output:</strong> true
//<strong>Explanation:</strong> There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0. So it is possible.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> numCourses = 2, prerequisites = [[1,0],[0,1]]
//<strong>Output:</strong> false
//<strong>Explanation:</strong> There are a total of 2 courses to take. 
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= numCourses &lt;= 2000</code></li> 
// <li><code>0 &lt;= prerequisites.length &lt;= 5000</code></li> 
// <li><code>prerequisites[i].length == 2</code></li> 
// <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; numCourses</code></li> 
// <li>All the pairs prerequisites[i] are <strong>unique</strong>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 图 | 拓扑排序</details><br>
//
//<div>👍 1423, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * Course Schedule
 *
 * @author DY
 * @date 2022-09-19 16:36:15
 */
public class P207_CourseSchedule {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P207_CourseSchedule().new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 记录图中是否有环
        boolean hasCycle = false;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites); // 构建图

            boolean[] onPath = new boolean[numCourses]; // 记录一次 traverse 递归经过的节点
            boolean[] visited = new boolean[numCourses]; // 记录遍历过的节点，防止走回头路
            for (int i = 0; i < numCourses; i++) { // 遍历所有节点
                traverse(graph, i, visited, onPath);
            }
            return !hasCycle;
        }

        private void traverse(List<Integer>[] graph, int index, boolean[] visited, boolean[] onPath) {
            if (onPath[index]) { // 选中的路径中包换该节点，有环
                hasCycle = true;
                return;
            }
            if (visited[index]) { // 访问过该节点，直接返回，避免重复计算(不一定有环)
                return;
            }
            visited[index] = true; // 标记访问过
            onPath[index] = true; // 标记选中该节点
            for (int t : graph[index]) {  // 遍历每个邻居
                traverse(graph, t, visited, onPath);
            }
            onPath[index] = false; // 回溯取消选中该节点
        }

        private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int to = edge[0];
                int from = edge[1];
                graph[from].add(to);
            }
            return graph;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
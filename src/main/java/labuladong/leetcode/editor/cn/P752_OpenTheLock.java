//<p>You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: <code>&#39;0&#39;, &#39;1&#39;, &#39;2&#39;, &#39;3&#39;, &#39;4&#39;, &#39;5&#39;, &#39;6&#39;, &#39;7&#39;, &#39;8&#39;, &#39;9&#39;</code>. The wheels can rotate freely and wrap around: for example we can turn <code>&#39;9&#39;</code> to be <code>&#39;0&#39;</code>, or <code>&#39;0&#39;</code> to be <code>&#39;9&#39;</code>. Each move consists of turning one wheel one slot.</p>
//
//<p>The lock initially starts at <code>&#39;0000&#39;</code>, a string representing the state of the 4 wheels.</p>
//
//<p>You are given a list of <code>deadends</code> dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.</p>
//
//<p>Given a <code>target</code> representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> deadends = [&quot;0201&quot;,&quot;0101&quot;,&quot;0102&quot;,&quot;1212&quot;,&quot;2002&quot;], target = &quot;0202&quot;
//<strong>Output:</strong> 6
//<strong>Explanation:</strong> 
//A sequence of valid moves would be &quot;0000&quot; -&gt; &quot;1000&quot; -&gt; &quot;1100&quot; -&gt; &quot;1200&quot; -&gt; &quot;1201&quot; -&gt; &quot;1202&quot; -&gt; &quot;0202&quot;.
//Note that a sequence like &quot;0000&quot; -&gt; &quot;0001&quot; -&gt; &quot;0002&quot; -&gt; &quot;0102&quot; -&gt; &quot;0202&quot; would be invalid,
//because the wheels of the lock become stuck after the display becomes the dead end &quot;0102&quot;.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> deadends = [&quot;8888&quot;], target = &quot;0009&quot;
//<strong>Output:</strong> 1
//<strong>Explanation:</strong> We can turn the last wheel in reverse to move from &quot;0000&quot; -&gt; &quot;0009&quot;.
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> deadends = [&quot;8887&quot;,&quot;8889&quot;,&quot;8878&quot;,&quot;8898&quot;,&quot;8788&quot;,&quot;8988&quot;,&quot;7888&quot;,&quot;9888&quot;], target = &quot;8888&quot;
//<strong>Output:</strong> -1
//<strong>Explanation:</strong> We cannot reach the target without getting stuck.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= deadends.length &lt;= 500</code></li>
//	<li><code>deadends[i].length == 4</code></li>
//	<li><code>target.length == 4</code></li>
//	<li>target <strong>will not be</strong> in the list <code>deadends</code>.</li>
//	<li><code>target</code> and <code>deadends[i]</code> consist of digits only.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>广度优先搜索 | 数组 | 哈希表 | 字符串</details><br>
//
//<div>👍 524, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Open the Lock
 *
 * @author DY
 * @date 2022-08-12 14:23:51
 */
public class P752_OpenTheLock {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P752_OpenTheLock().new Solution();


        System.out.println(solution.openLock1(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(solution.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            Queue<String> q = new LinkedList<>();
            Set<String> dead = new HashSet<>(Arrays.asList(deadends));
            Set<String> visited = new HashSet<>();
            q.offer("0000");
            visited.add("0000");
            return bfs(target, q, dead, visited);
        }

        private int bfs(String target, Queue<String> q, Set<String> dead, Set<String> visited) {
            int depth = 0;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();
                    if (dead.contains(cur)) {
                        continue;
                    }
                    if (target.equals(cur)) {
                        return depth;
                    }
                    for (int j = 0; j < 4; j++) {
                        String up = plus(cur, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                            visited.add(up);
                        }
                        String down = minus(cur, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                            visited.add(down);
                        }
                    }
                }
                ++depth;
            }
            return -1;
        }

        private String plus(String cur, int j) {
            char[] chars = cur.toCharArray();
            if (chars[j] == '9') {
                chars[j] = '0';
            } else {
                chars[j] += 1;
            }
            return new String(chars);
        }

        private String minus(String cur, int j) {
            char[] chars = cur.toCharArray();
            if (chars[j] == '0') {
                chars[j] = '9';
            } else {
                chars[j] -= 1;
            }
            return new String(chars);
        }

        /*public int openLock(String[] deadends, String target) {
            Set<String> visited = new HashSet<>();
            Set<String> deads = new HashSet<>(Arrays.asList(deadends));
            LinkedList<String> queue = new LinkedList<>();
            visited.add("0000");
            queue.add("0000");
            return bfs(target, queue, visited, deads);
        }

        private int bfs(String target, LinkedList<String> queue, Set<String> visited, Set<String> deads) {
            int depth = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.removeFirst();
                    if (deads.contains(cur)) {
                        continue;
                    }
                    if (cur.equals(target)) {
                        return depth;
                    }
                    for (int j = 0; j < 4; j++) {
                        String up = plus(cur, j);
                        if (!visited.contains(up)) {
                            visited.add(up);
                            queue.add(up);
                        }
                        String down = minus(cur, j);
                        if (!visited.contains(down)) {
                            visited.add(down);
                            queue.add(down);
                        }
                    }
                }
                depth++;
            }
            return -1;
        }

        private String plus(String cur, int j) {
            char[] chars = cur.toCharArray();
            if (chars[j] == '9') {
                chars[j] = '0';
            } else {
                chars[j] += 1;
            }
            return new String(chars);
        }

        private String minus(String cur, int j) {
            char[] chars = cur.toCharArray();
            if (chars[j] == '0') {
                chars[j] = '9';
            } else {
                chars[j] -= 1;
            }
            return new String(chars);
        }*/

        int openLock1(String[] deadends, String target) {
            // 记录需要跳过的死亡密码
            Set<String> deads = new HashSet<>();
            for (String s : deadends) deads.add(s);
            // 记录已经穷举过的密码，防止走回头路
            Set<String> visited = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            // 从起点开始启动广度优先搜索
            int step = 0;
            q.offer("0000");
            visited.add("0000");

            while (!q.isEmpty()) {
                int sz = q.size();
                /* 将当前队列中的所有节点向周围扩散 */
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();

                    /* 判断是否到达终点 */
                    if (deads.contains(cur))
                        continue;
                    if (cur.equals(target))
                        return step;

                    /* 将一个节点的未遍历相邻节点加入队列 */
                    for (int j = 0; j < 4; j++) {
                        String up = plus(cur, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                            visited.add(up);
                        }
                        String down = minus(cur, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                            visited.add(down);
                        }
                    }
                }
                /* 在这里增加步数 */
                step++;
            }
            // 如果穷举完都没找到目标密码，那就是找不到了
            return -1;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
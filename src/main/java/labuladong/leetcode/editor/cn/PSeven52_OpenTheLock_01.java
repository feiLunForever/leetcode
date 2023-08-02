/**
 * <p>You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: <code>'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'</code>. The wheels can rotate freely and wrap around: for example we can turn <code>'9'</code> to be <code>'0'</code>, or <code>'0'</code> to be <code>'9'</code>. Each move consists of turning one wheel one slot.</p>
 *
 * <p>The lock initially starts at <code>'0000'</code>, a string representing the state of the 4 wheels.</p>
 *
 * <p>You are given a list of <code>deadends</code> dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.</p>
 *
 * <p>Given a <code>target</code> representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * <strong>Output:</strong> 6
 * <strong>Explanation:</strong>
 * A sequence of valid moves would be "0000" -&gt; "1000" -&gt; "1100" -&gt; "1200" -&gt; "1201" -&gt; "1202" -&gt; "0202".
 * Note that a sequence like "0000" -&gt; "0001" -&gt; "0002" -&gt; "0102" -&gt; "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> deadends = ["8888"], target = "0009"
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> We can turn the last wheel in reverse to move from "0000" -&gt; "0009".
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> We cannot reach the target without getting stuck.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= deadends.length &lt;= 500</code></li>
 * <li><code>deadends[i].length == 4</code></li>
 * <li><code>target.length == 4</code></li>
 * <li>target <strong>will not be</strong> in the list <code>deadends</code>.</li>
 * <li><code>target</code> and <code>deadends[i]</code> consist of digits only.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>广度优先搜索 | 数组 | 哈希表 | 字符串</details><br>
 *
 * <div>👍 619, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Open the Lock
 *
 * @author DY
 * @date 2023-08-02 17:30:47
 */
public class PSeven52_OpenTheLock_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven52_OpenTheLock_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int openLock(String[] deadends, String target) {
            Set<String> visited = new HashSet<>(Arrays.asList(deadends));
            Queue<String> q = new LinkedList<>();
            if (!visited.contains("0000")) {
                visited.add("0000");
                q.offer("0000");
            }
            int step = 0;
            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    String cur = q.poll();
                    if (cur.equals(target)) {
                        return step;
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
                ++step;
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}

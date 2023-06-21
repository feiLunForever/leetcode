/**
 * <p>In the video game Fallout 4, the quest <strong>"Road to Freedom"</strong> requires players to reach a metal dial called the <strong>"Freedom Trail Ring"</strong> and use the dial to spell a specific keyword to open the door.</p>
 *
 * <p>Given a string <code>ring</code> that represents the code engraved on the outer ring and another string <code>key</code> that represents the keyword that needs to be spelled, return <em>the minimum number of steps to spell all the characters in the keyword</em>.</p>
 *
 * <p>Initially, the first character of the ring is aligned at the <code>"12:00"</code> direction. You should spell all the characters in <code>key</code> one by one by rotating <code>ring</code> clockwise or anticlockwise to make each character of the string key aligned at the <code>"12:00"</code> direction and then by pressing the center button.</p>
 *
 * <p>At the stage of rotating the ring to spell the key character <code>key[i]</code>:</p>
 *
 * <ol>
 * <li>You can rotate the ring clockwise or anticlockwise by one place, which counts as <strong>one step</strong>. The final purpose of the rotation is to align one of <code>ring</code>'s characters at the <code>"12:00"</code> direction, where this character must equal <code>key[i]</code>.</li>
 * <li>If the character <code>key[i]</code> has been aligned at the <code>"12:00"</code> direction, press the center button to spell, which also counts as <strong>one step</strong>. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.</li>
 * </ol>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img src="https://assets.leetcode.com/uploads/2018/10/22/ring.jpg" style="width: 450px; height: 450px;" />
 * <pre>
 * <strong>Input:</strong> ring = "godding", key = "gd"
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong>
 * For the first key character 'g', since it is already in place, we just need 1 step to spell this character.
 * For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
 * Also, we need 1 more step for spelling.
 * So the final output is 4.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> ring = "godding", key = "godding"
 * <strong>Output:</strong> 13
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= ring.length, key.length &lt;= 100</code></li>
 * <li><code>ring</code> and <code>key</code> consist of only lower case English letters.</li>
 * <li>It is guaranteed that <code>key</code> could always be spelled by rotating <code>ring</code>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 字符串 | 动态规划</details><br>
 *
 * <div>👍 269, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.*;

/**
 * Freedom Trail
 *
 * @author DY
 * @date 2023-06-21 13:59:51
 */
public class PFive14_FreedomTrail {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PFive14_FreedomTrail().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRotateSteps(String ring, String key) {
            int m = ring.length(), n = key.length();
            int[][] memo = new int[m][n];
            Map<Character, List<Integer>> index = new HashMap<>();
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            for (int i = 0; i < m; i++) {
                List<Integer> data = index.computeIfAbsent(ring.charAt(i), k -> new LinkedList<Integer>());
                data.add(i);
            }
            return dp(index, 0, key, 0, memo);
        }

        /**
         * 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
         *
         * @param index
         * @param i
         * @param key
         * @param j
         * @param memo
         * @return
         */
        private int dp(Map<Character, List<Integer>> index, int i, String key, int j, int[][] memo) {
            if (j == key.length()) return 0; // key 走完了
            if (memo[i][j] != -1) return memo[i][j];
            int n = memo.length;
            int res = Integer.MAX_VALUE;

            for (int k : index.get(key.charAt(j))) { // ring 上可能有多个字符 key[j]
                int delta = Math.abs(k - i); // 指针波动次数
                delta = Math.min(delta, n - delta); // 取顺时针，逆时针最小值
                int subProblem = dp(index, k, key, j + 1, memo); // 将指针拨到 ring[k]，继续输入 key[j+1..]
                res = Math.min(res, subProblem + delta + 1); // 选择「整体」操作次数最少的, 加一是因为按动按钮也是一次操作
            }

            memo[i][j] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

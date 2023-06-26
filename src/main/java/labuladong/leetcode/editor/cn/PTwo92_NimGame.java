/**
 * <p>You are playing the following Nim Game with your friend:</p>
 *
 * <ul>
 * <li>Initially, there is a heap of stones on the table.</li>
 * <li>You and your friend will alternate taking turns, and <strong>you go first</strong>.</li>
 * <li>On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.</li>
 * <li>The one who removes the last stone is the winner.</li>
 * </ul>
 *
 * <p>Given <code>n</code>, the number of stones in the heap, return <code>true</code><em> if you can win the game assuming both you and your friend play optimally, otherwise return </em><code>false</code>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 4
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> These are the possible outcomes:
 * 1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
 * 2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
 * 3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
 * In all outcomes, your friend wins.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 1
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p><strong class="example">Example 3:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> n = 2
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>脑筋急转弯 | 数学 | 博弈</details><br>
 *
 * <div>👍 683, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Nim Game
 *
 * @author DY
 * @date 2023-06-26 17:03:47
 */
public class PTwo92_NimGame {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PTwo92_NimGame().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canWinNim(int n) {
			return n % 4 != 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

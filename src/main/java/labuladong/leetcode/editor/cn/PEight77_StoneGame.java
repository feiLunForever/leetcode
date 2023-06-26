/**
 * <p>Alice and Bob play a game with piles of stones. There are an <strong>even</strong> number of piles arranged in a row, and each pile has a <strong>positive</strong> integer number of stones <code>piles[i]</code>.</p>
 *
 * <p>The objective of the game is to end with the most stones. The <strong>total</strong> number of stones across all the piles is <strong>odd</strong>, so there are no ties.</p>
 *
 * <p>Alice and Bob take turns, with <strong>Alice starting first</strong>. Each turn, a player takes the entire pile of stones either from the <strong>beginning</strong> or from the <strong>end</strong> of the row. This continues until there are no more piles left, at which point the person with the <strong>most stones wins</strong>.</p>
 *
 * <p>Assuming Alice and Bob play optimally, return <code>true</code><em> if Alice wins the game, or </em><code>false</code><em> if Bob wins</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> piles = [5,3,4,5]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong>
 * Alice starts first, and can only take the first 5 or the last 5.
 * Say she takes the first 5, so that the row becomes [3, 4, 5].
 * If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
 * If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
 * This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> piles = [3,7,2,3]
 * <strong>Output:</strong> true
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>2 &lt;= piles.length &lt;= 500</code></li>
 * <li><code>piles.length</code> is <strong>even</strong>.</li>
 * <li><code>1 &lt;= piles[i] &lt;= 500</code></li>
 * <li><code>sum(piles[i])</code> is <strong>odd</strong>.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>数组 | 数学 | 动态规划 | 博弈</details><br>
 *
 * <div>👍 504, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Stone Game
 *
 * @author DY
 * @date 2023-06-26 17:08:54
 */
public class PEight77_StoneGame {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PEight77_StoneGame().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean stoneGame(int[] piles) {
			return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

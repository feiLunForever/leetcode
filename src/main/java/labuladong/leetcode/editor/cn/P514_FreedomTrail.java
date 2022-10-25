//<p>In the video game Fallout 4, the quest <strong>"Road to Freedom"</strong> requires players to reach a metal dial called the <strong>"Freedom Trail Ring"</strong> and use the dial to spell a specific keyword to open the door.</p>
//
//<p>Given a string <code>ring</code> that represents the code engraved on the outer ring and another string <code>key</code> that represents the keyword that needs to be spelled, return <em>the minimum number of steps to spell all the characters in the keyword</em>.</p>
//
//<p>Initially, the first character of the ring is aligned at the <code>"12:00"</code> direction. You should spell all the characters in <code>key</code> one by one by rotating <code>ring</code> clockwise or anticlockwise to make each character of the string key aligned at the <code>"12:00"</code> direction and then by pressing the center button.</p>
//
//<p>At the stage of rotating the ring to spell the key character <code>key[i]</code>:</p>
//
//<ol> 
// <li>You can rotate the ring clockwise or anticlockwise by one place, which counts as <strong>one step</strong>. The final purpose of the rotation is to align one of <code>ring</code>'s characters at the <code>"12:00"</code> direction, where this character must equal <code>key[i]</code>.</li> 
// <li>If the character <code>key[i]</code> has been aligned at the <code>"12:00"</code> direction, press the center button to spell, which also counts as <strong>one step</strong>. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.</li> 
//</ol>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img src="https://assets.leetcode.com/uploads/2018/10/22/ring.jpg" style="width: 450px; height: 450px;" /> 
//<pre>
//<strong>Input:</strong> ring = "godding", key = "gd"
//<strong>Output:</strong> 4
//<strong>Explanation:</strong>
//For the first key character 'g', since it is already in place, we just need 1 step to spell this character. 
//For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
//Also, we need 1 more step for spelling.
//So the final output is 4.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> ring = "godding", key = "godding"
//<strong>Output:</strong> 13
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= ring.length, key.length &lt;= 100</code></li> 
// <li><code>ring</code> and <code>key</code> consist of only lower case English letters.</li> 
// <li>It is guaranteed that <code>key</code> could always be spelled by rotating <code>ring</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 广度优先搜索 | 字符串 | 动态规划</details><br>
//
//<div>👍 251, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Freedom Trail
 *
 * @author DY
 * @date 2022-10-25 20:49:33
 */
public class P514_FreedomTrail {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P514_FreedomTrail().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findRotateSteps(String ring, String key) {
            Map<Character, List<Integer>> char2Index = new HashMap<>();
            for (int i = 0; i < ring.length(); i++) {
                char ch = ring.charAt(i);
                if (!char2Index.containsKey(ch)) {
                    char2Index.put(ch, new LinkedList<>());
                }
                char2Index.get(ch).add(i);
            }
            int[][] dp = new int[ring.length()][key.length()];

            return dp(ring, 0, key, 0, char2Index, dp);
        }

        private int dp(String ring, int i, String key, int j, Map<Character, List<Integer>> char2Index, int[][] dp) {
            if (j == key.length()) return 0;
            if (dp[i][j] != 0) return dp[i][j];
            int res = Integer.MAX_VALUE;
            for (int k : char2Index.get(key.charAt(j))) {
                int distance = Math.min(Math.abs(k - i), ring.length() - Math.abs(k - i));
                int subProblem = dp(ring, k, key, j + 1, char2Index, dp);
                res = Math.min(res, distance + subProblem + 1);
            }
            dp[i][j] = res;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
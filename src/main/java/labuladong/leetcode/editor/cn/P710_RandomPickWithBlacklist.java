//<p>You are given an integer <code>n</code> and an array of <strong>unique</strong> integers <code>blacklist</code>. Design an algorithm to pick a random integer in the range <code>[0, n - 1]</code> that is <strong>not</strong> in <code>blacklist</code>. Any integer that is in the mentioned range and not in <code>blacklist</code> should be <strong>equally likely</strong> to be returned.</p>
//
//<p>Optimize your algorithm such that it minimizes the number of calls to the <strong>built-in</strong> random function of your language.</p>
//
//<p>Implement the <code>Solution</code> class:</p>
//
//<ul>
//	<li><code>Solution(int n, int[] blacklist)</code> Initializes the object with the integer <code>n</code> and the blacklisted integers <code>blacklist</code>.</li>
//	<li><code>int pick()</code> Returns a random integer in the range <code>[0, n - 1]</code> and not in <code>blacklist</code>.</li>
//</ul>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//[&quot;Solution&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;, &quot;pick&quot;]
//[[7, [2, 3, 5]], [], [], [], [], [], [], []]
//<strong>Output</strong>
//[null, 0, 4, 1, 6, 1, 0, 4]
//
//<strong>Explanation</strong>
//Solution solution = new Solution(7, [2, 3, 5]);
//solution.pick(); // return 0, any integer from [0,1,4,6] should be ok. Note that for every call of pick,
//                 // 0, 1, 4, and 6 must be equally likely to be returned (i.e., with probability 1/4).
//solution.pick(); // return 4
//solution.pick(); // return 1
//solution.pick(); // return 6
//solution.pick(); // return 1
//solution.pick(); // return 0
//solution.pick(); // return 4
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>1 &lt;= n &lt;= 10<sup>9</sup></code></li>
//	<li><code>0 &lt;= blacklist.length &lt;= min(10<sup>5</sup>, n - 1)</code></li>
//	<li><code>0 &lt;= blacklist[i] &lt; n</code></li>
//	<li>All the values of <code>blacklist</code> are <strong>unique</strong>.</li>
//	<li>At most <code>2 * 10<sup>4</sup></code> calls will be made to <code>pick</code>.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>哈希表 | 数学 | 二分查找 | 排序 | 随机化</details><br>
//
//<div>👍 210, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Random Pick with Blacklist
 *
 * @author DY
 * @date 2022-09-01 15:03:52
 */
public class P710_RandomPickWithBlacklist {
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new P710_RandomPickWithBlacklist().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Random random = new Random();

        private final Map<Integer, Integer> mappings;

        private final int sz;

        public Solution(int n, int[] blacklist) {
            sz = n - blacklist.length;
            mappings = new HashMap<>(blacklist.length);
            for (int black : blacklist) {
                mappings.put(black, -1);
            }
            int last = n - 1;
            for (int black : blacklist) {
                if (black >= sz) { // 如果已经在 [sz, n) 区间内，则忽略
                    continue;
                }
                while (mappings.containsKey(last)) { // 从后往前找到第一个不是黑名单的元素
                    --last;
                }
                mappings.put(black, last); // 更新角标映射
                --last;
            }
        }

        public int pick() {
            int index = random.nextInt(sz);
            return mappings.getOrDefault(index, index); // 如果映射到黑名单，则返回映射值，否则直接返回
        }

        /*Random random = new Random();

        Map<Integer, Integer> black;

        int sz;

        public Solution(int n, int[] blacklist) {
            sz = n - blacklist.length;
            black = new HashMap<>(blacklist.length);
            for (int item : blacklist) {
                black.put(item, 666);
            }
            int last = n - 1;
            for (int item : blacklist) {
                if (item >= sz) { // 在 [ n-m, n)中，无需替换
                    continue;
                }
                while (black.containsKey(last)) { // 从后往前找到第一个不在黑名单中的值，替换[0,n-m)中的下标
                    last--;
                }
                black.put(item, last);
                last--;
            }
        }

        public int pick() {
            int index = random.nextInt(sz);
            if (black.containsKey(index)) {
                return black.get(index);
            }
            return index;
        }*/
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
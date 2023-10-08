/**
 * You are given an integer n and an array of unique integers blacklist. Design an
 * algorithm to pick a random integer in the range [0, n - 1] that is not in
 * blacklist. Any integer that is in the mentioned range and not in blacklist should be
 * equally likely to be returned.
 * <p>
 * Optimize your algorithm such that it minimizes the number of calls to the
 * built-in random function of your language.
 * <p>
 * Implement the Solution class:
 * <p>
 * <p>
 * Solution(int n, int[] blacklist) Initializes the object with the integer n and
 * the blacklisted integers blacklist.
 * int pick() Returns a random integer in the range [0, n - 1] and not in
 * blacklist.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
 * [[7, [2, 3, 5]], [], [], [], [], [], [], []]
 * Output
 * [null, 0, 4, 1, 6, 1, 0, 4]
 * <p>
 * Explanation
 * Solution solution = new Solution(7, [2, 3, 5]);
 * solution.pick(); // return 0, any integer from [0,1,4,6] should be ok. Note
 * that for every call of pick,
 * // 0, 1, 4, and 6 must be equally likely to be returned (i.e.,
 * with probability 1/4).
 * solution.pick(); // return 4
 * solution.pick(); // return 1
 * solution.pick(); // return 6
 * solution.pick(); // return 1
 * solution.pick(); // return 0
 * solution.pick(); // return 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= n <= 10⁹
 * 0 <= blacklist.length <= min(10⁵, n - 1)
 * 0 <= blacklist[i] < n
 * All the values of blacklist are unique.
 * At most 2 * 10⁴ calls will be made to pick.
 * <p>
 * <p>
 * Related Topics数组 | 哈希表 | 数学 | 二分查找 | 排序 | 随机化
 * <p>
 * 👍 232, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Random Pick with Blacklist
 *
 * @author DY
 * @date 2023-09-27 16:10:55
 */
public class PSeven10_RandomPickWithBlacklist {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven10_RandomPickWithBlacklist().new Solution(0, null);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Map<Integer, Integer> mappings;

        private final int sz;

        private final Random random = new Random();

        public Solution(int n, int[] blacklist) {
            mappings = new HashMap<>(blacklist.length);
            for (int black : blacklist) {
                mappings.put(black, -1);
            }
            sz = n - blacklist.length;
            int last = n - 1;
            for (int black : blacklist) {
                if (black >= sz) continue;
                while (mappings.containsKey(last)) {
                    --last;
                }
                mappings.put(black, last);
                --last;
            }
        }

        public int pick() {
            int index = random.nextInt(sz);
            return mappings.getOrDefault(index, index);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}

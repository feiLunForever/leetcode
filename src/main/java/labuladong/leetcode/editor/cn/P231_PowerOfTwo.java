//<p>Given an integer <code>n</code>, return <em><code>true</code> if it is a power of two. Otherwise, return <code>false</code></em>.</p>
//
//<p>An integer <code>n</code> is a power of two, if there exists an integer <code>x</code> such that <code>n == 2<sup>x</sup></code>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1
//<strong>Output:</strong> true
//<strong>Explanation: </strong>2<sup>0</sup> = 1
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 16
//<strong>Output:</strong> true
//<strong>Explanation: </strong>2<sup>4</sup> = 16
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 3
//<strong>Output:</strong> false
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup> - 1</code></li> 
//</ul>
//
//<p>&nbsp;</p> 
//<strong>Follow up:</strong> Could you solve it without loops/recursion?
//
//<details><summary><strong>Related Topics</strong></summary>位运算 | 递归 | 数学</details><br>
//
//<div>👍 549, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Power of Two
 *
 * @author DY
 * @date 2022-11-11 20:32:51
 */
public class P231_PowerOfTwo {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P231_PowerOfTwo().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) return false;
            return (n & (n - 1)) == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
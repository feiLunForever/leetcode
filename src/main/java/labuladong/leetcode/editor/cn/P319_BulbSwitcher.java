//<p>There are <code>n</code> bulbs that are initially off. You first turn on all the bulbs, then&nbsp;you turn off every second bulb.</p>
//
//<p>On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the <code>i<sup>th</sup></code> round, you toggle every <code>i</code> bulb. For the <code>n<sup>th</sup></code> round, you only toggle the last bulb.</p>
//
//<p>Return <em>the number of bulbs that are on after <code>n</code> rounds</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/05/bulb.jpg" style="width: 421px; height: 321px;" /> 
//<pre>
//<strong>Input:</strong> n = 3
//<strong>Output:</strong> 1
//<strong>Explanation:</strong> At first, the three bulbs are [off, off, off].
//After the first round, the three bulbs are [on, on, on].
//After the second round, the three bulbs are [on, off, on].
//After the third round, the three bulbs are [on, off, off]. 
//So you should return 1 because there is only one bulb is on.</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 0
//<strong>Output:</strong> 0
//</pre>
//
//<p><strong class="example">Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> n = 1
//<strong>Output:</strong> 1
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>0 &lt;= n &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>脑筋急转弯 | 数学</details><br>
//
//<div>👍 338, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Bulb Switcher
 *
 * @author DY
 * @date 2022-11-13 13:18:44
 */
public class P319_BulbSwitcher {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P319_BulbSwitcher().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bulbSwitch(int n) {
            return (int) Math.sqrt(n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
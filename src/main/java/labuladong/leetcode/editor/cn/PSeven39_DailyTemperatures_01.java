/**
 * <p>Given an array of integers <code>temperatures</code> represents the daily temperatures, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is the number of days you have to wait after the</em> <code>i<sup>th</sup></code> <em>day to get a warmer temperature</em>. If there is no future day for which this is possible, keep <code>answer[i] == 0</code> instead.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <pre><strong>Input:</strong> temperatures = [73,74,75,71,69,72,76,73]
 * <strong>Output:</strong> [1,1,4,2,1,1,0,0]
 * </pre>
 * <p><strong class="example">Example 2:</strong></p>
 * <pre><strong>Input:</strong> temperatures = [30,40,50,60]
 * <strong>Output:</strong> [1,1,1,0]
 * </pre>
 * <p><strong class="example">Example 3:</strong></p>
 * <pre><strong>Input:</strong> temperatures = [30,60,90]
 * <strong>Output:</strong> [1,1,0]
 * </pre>
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
 * <li><code>30 &lt;=&nbsp;temperatures[i] &lt;= 100</code></li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>栈 | 数组 | 单调栈</details><br>
 *
 * <div>👍 1570, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.Stack;

/**
 * Daily Temperatures
 *
 * @author DY
 * @date 2023-08-14 22:30:18
 */
public class PSeven39_DailyTemperatures_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PSeven39_DailyTemperatures_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] res = new int[n];
            Stack<Integer> stack = new Stack<>(); // 这里放元素索引，而不是元素
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? 0 : stack.peek() - i; // 得到索引间距
                stack.push(i); // 将索引入栈，而不是元素
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

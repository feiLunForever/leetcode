//<p>There are <code>n</code> gas stations along a circular route, where the amount of gas at the <code>i<sup>th</sup></code> station is <code>gas[i]</code>.</p>
//
//<p>You have a car with an unlimited gas tank and it costs <code>cost[i]</code> of gas to travel from the <code>i<sup>th</sup></code> station to its next <code>(i + 1)<sup>th</sup></code> station. You begin the journey with an empty tank at one of the gas stations.</p>
//
//<p>Given two integer arrays <code>gas</code> and <code>cost</code>, return <em>the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return</em> <code>-1</code>. If there exists a solution, it is <strong>guaranteed</strong> to be <strong>unique</strong></p>
//
//<p>&nbsp;</p> 
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//<strong>Output:</strong> 3
//<strong>Explanation:</strong>
//Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//Travel to station 4. Your tank = 4 - 1 + 5 = 8
//Travel to station 0. Your tank = 8 - 2 + 1 = 7
//Travel to station 1. Your tank = 7 - 3 + 2 = 6
//Travel to station 2. Your tank = 6 - 4 + 3 = 5
//Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
//Therefore, return 3 as the starting index.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> gas = [2,3,4], cost = [3,4,3]
//<strong>Output:</strong> -1
//<strong>Explanation:</strong>
//You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
//Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
//Travel to station 0. Your tank = 4 - 3 + 2 = 3
//Travel to station 1. Your tank = 3 - 3 + 3 = 3
//You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
//Therefore, you can't travel around the circuit once no matter where you start.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>n == gas.length == cost.length</code></li> 
// <li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li> 
// <li><code>0 &lt;= gas[i], cost[i] &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>贪心 | 数组</details><br>
//
//<div>👍 1074, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Gas Station
 *
 * @author DY
 * @date 2022-11-02 21:46:05
 */
public class P134_GasStation {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P134_GasStation().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (gas[i] - cost[i]);
            }
            if (sum < 0) return -1;
            int start = 0;
            int tank = 0;
            for (int i = 0; i < n; i++) {
                tank += (gas[i] - cost[i]);
                if (tank < 0) {
                    tank = 0;
                    start = i + 1;
                }
            }
            return start == n ? 0 : start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
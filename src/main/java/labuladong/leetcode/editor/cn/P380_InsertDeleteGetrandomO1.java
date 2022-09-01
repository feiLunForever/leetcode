//<p>Implement the <code>RandomizedSet</code> class:</p>
//
//<ul>
//	<li><code>RandomizedSet()</code> Initializes the <code>RandomizedSet</code> object.</li>
//	<li><code>bool insert(int val)</code> Inserts an item <code>val</code> into the set if not present. Returns <code>true</code> if the item was not present, <code>false</code> otherwise.</li>
//	<li><code>bool remove(int val)</code> Removes an item <code>val</code> from the set if present. Returns <code>true</code> if the item was present, <code>false</code> otherwise.</li>
//	<li><code>int getRandom()</code> Returns a random element from the current set of elements (it&#39;s guaranteed that at least one element exists when this method is called). Each element must have the <b>same probability</b> of being returned.</li>
//</ul>
//
//<p>You must implement the functions of the class such that each function works in&nbsp;<strong>average</strong>&nbsp;<code>O(1)</code>&nbsp;time complexity.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//[&quot;RandomizedSet&quot;, &quot;insert&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;]
//[[], [1], [2], [2], [], [1], [2], []]
//<strong>Output</strong>
//[null, true, false, true, 2, true, false, 2]
//
//<strong>Explanation</strong>
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
//randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
//randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
//randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
//randomizedSet.insert(2); // 2 was already in the set, so return false.
//randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
//	<li>At most <code>2 *&nbsp;</code><code>10<sup>5</sup></code> calls will be made to <code>insert</code>, <code>remove</code>, and <code>getRandom</code>.</li>
//	<li>There will be <strong>at least one</strong> element in the data structure when <code>getRandom</code> is called.</li>
//</ul>
//<details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 哈希表 | 数学 | 随机化</details><br>
//
//<div>👍 591, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Insert Delete GetRandom O(1)
 *
 * @author DY
 * @date 2022-08-31 19:47:39
 */
public class P380_InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        //测试代码
//	 	 Solution solution = new P380_InsertDeleteGetrandomO1().new Solution();
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    static class RandomizedSet {

        Map<Integer, Integer> map;
        ArrayList<Integer> data;

        public RandomizedSet() {
            map = new HashMap<>();
            data = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, data.size());
                data.add(val);
                return true;
            }
            return false;
        }

        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.get(val);
                Integer last = data.get(data.size() - 1);
//                data.remove(index);
                data.set(index, last);
                data.remove(data.size() - 1);
                map.put(last, index);
                map.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            Random random = new Random();
            return data.get(random.nextInt(data.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
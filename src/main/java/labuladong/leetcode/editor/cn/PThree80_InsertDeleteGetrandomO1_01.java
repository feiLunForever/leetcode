/**
 * <p>Implement the <code>RandomizedSet</code> class:</p>
 *
 * <ul>
 * <li><code>RandomizedSet()</code> Initializes the <code>RandomizedSet</code> object.</li>
 * <li><code>bool insert(int val)</code> Inserts an item <code>val</code> into the set if not present. Returns <code>true</code> if the item was not present, <code>false</code> otherwise.</li>
 * <li><code>bool remove(int val)</code> Removes an item <code>val</code> from the set if present. Returns <code>true</code> if the item was present, <code>false</code> otherwise.</li>
 * <li><code>int getRandom()</code> Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the <b>same probability</b> of being returned.</li>
 * </ul>
 *
 * <p>You must implement the functions of the class such that each function works in&nbsp;<strong>average</strong>&nbsp;<code>O(1)</code>&nbsp;time complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * <strong>Output</strong>
 * [null, true, false, true, 2, true, false, 2]
 *
 * <strong>Explanation</strong>
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
 * <li>At most <code>2 *&nbsp;</code><code>10<sup>5</sup></code> calls will be made to <code>insert</code>, <code>remove</code>, and <code>getRandom</code>.</li>
 * <li>There will be <strong>at least one</strong> element in the data structure when <code>getRandom</code> is called.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 数组 | 哈希表 | 数学 | 随机化</details><br>
 *
 * <div>👍 728, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Insert Delete GetRandom O(1)
 * @author DY
 * @date 2023-10-08 16:34:32
 */
public class PThree80_InsertDeleteGetrandomO1_01 {
    public static void main(String[] args) {
        //测试代码
        RandomizedSet solution = new PThree80_InsertDeleteGetrandomO1_01().new RandomizedSet();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {

        private final ArrayList<Integer> data = new ArrayList<>(); // 存放元素的值

        private final Map<Integer, Integer> val2Index = new HashMap<>(); // key -> item, value -> index

        private final Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (!val2Index.containsKey(val)) {  // 若val不存在，插入到nums尾部，并记录val对应的索引值
                val2Index.put(val, data.size());
                data.add(val);
                return true;
            }
            return false; // 若 val 已存在，不用再插入
        }

        public boolean remove(int val) {
            if (val2Index.containsKey(val)) {
                int index = val2Index.get(val); // 需要删除节点的下标
                int last = data.get(data.size() - 1); // 当前最后一个值
                data.set(index, last); // 将最后一个值的下标替换成要删除节点的下标
                val2Index.put(last, index); // 更新索引映射
                data.remove(data.size() - 1); // 删除最后一个值
                val2Index.remove(val); // 删除索引映射
                return true;
            }
            return false;
        }

        public int getRandom() {
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

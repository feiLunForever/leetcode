/**
 * <p>Design and implement a data structure for a <a href="https://en.wikipedia.org/wiki/Least_frequently_used" target="_blank">Least Frequently Used (LFU)</a> cache.</p>
 *
 * <p>Implement the <code>LFUCache</code> class:</p>
 *
 * <ul>
 * <li><code>LFUCache(int capacity)</code> Initializes the object with the <code>capacity</code> of the data structure.</li>
 * <li><code>int get(int key)</code> Gets the value of the <code>key</code> if the <code>key</code> exists in the cache. Otherwise, returns <code>-1</code>.</li>
 * <li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if present, or inserts the <code>key</code> if not already present. When the cache reaches its <code>capacity</code>, it should invalidate and remove the <strong>least frequently used</strong> key before inserting a new item. For this problem, when there is a <strong>tie</strong> (i.e., two or more keys with the same frequency), the <strong>least recently used</strong> <code>key</code> would be invalidated.</li>
 * </ul>
 *
 * <p>To determine the least frequently used key, a <strong>use counter</strong> is maintained for each key in the cache. The key with the smallest <strong>use counter</strong> is the least frequently used key.</p>
 *
 * <p>When a key is first inserted into the cache, its <strong>use counter</strong> is set to <code>1</code> (due to the <code>put</code> operation). The <strong>use counter</strong> for a key in the cache is incremented either a <code>get</code> or <code>put</code> operation is called on it.</p>
 *
 * <p>The functions&nbsp;<code data-stringify-type="code">get</code>&nbsp;and&nbsp;<code data-stringify-type="code">put</code>&nbsp;must each run in <code>O(1)</code> average time complexity.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input</strong>
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * <strong>Output</strong>
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * <strong>Explanation</strong>
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 * &nbsp;                // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 * // cache=[4,3], cnt(4)=2, cnt(3)=3
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= capacity&nbsp;&lt;= 10<sup>4</sup></code></li>
 * <li><code>0 &lt;= key &lt;= 10<sup>5</sup></code></li>
 * <li><code>0 &lt;= value &lt;= 10<sup>9</sup></code></li>
 * <li>At most <code>2 * 10<sup>5</sup></code>&nbsp;calls will be made to <code>get</code> and <code>put</code>.</li>
 * </ul>
 *
 * <p>&nbsp;</p>
 * <span style="display: none;">&nbsp;</span>
 *
 * <details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 链表 | 双向链表</details><br>
 *
 * <div>👍 658, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * LFU Cache
 *
 * @author DY
 * @date 2023-06-13 14:44:15
 */
public class PFour60_LfuCache {
    public static void main(String[] args) {
        //测试代码
        LFUCache solution = new PFour60_LfuCache().new LFUCache(2);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        private int minFreq;
        private int capacity;

        private Map<Integer, Integer> data; // (key, value)
        private Map<Integer, Integer> key2Freq; // (key, freq)
        private Map<Integer, LinkedHashSet<Integer>> freq2Keys; // (freq, [keys]])

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFreq = 0;
            data = new HashMap<>(capacity);
            key2Freq = new HashMap<>(capacity);
            freq2Keys = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (data.containsKey(key)) {
                increaseFreq(key);
                return data.get(key);
            }
            return -1;
        }

        public void put(int key, int value) {
            if (data.containsKey(key)) {
                data.put(key, value);
                increaseFreq(key);
                return;
            }
            if (data.size() >= capacity) {
                removeMinFreq();
            }
            data.put(key, value);
            key2Freq.put(key, 1);
            LinkedHashSet<Integer> keys = freq2Keys.computeIfAbsent(1, k -> new LinkedHashSet<>());
            keys.add(key);
            minFreq = 1;
        }

        private void removeMinFreq() {
            LinkedHashSet<Integer> keys = freq2Keys.get(minFreq);
            int removeKey = keys.iterator().next();
            keys.remove(removeKey);
            if (keys.isEmpty()) {
                freq2Keys.remove(minFreq);
            }
            data.remove(removeKey);
            key2Freq.remove(removeKey);
        }

        private void increaseFreq(int key) {
            int freq = key2Freq.getOrDefault(key, 0);
            key2Freq.put(key, freq + 1); // key -> freq + 1

            freq2Keys.get(freq).remove(key); // 之前freq -> keys 中，去掉之前的key

            if (freq2Keys.get(freq).isEmpty()) { // 如果该freq已空
                freq2Keys.remove(freq);
                if (minFreq == freq) {
                    minFreq = freq + 1;
                }
            }

            LinkedHashSet<Integer> freqKeys = freq2Keys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<Integer>());

            freqKeys.add(key); // freq+1 -> keys 中新增key
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

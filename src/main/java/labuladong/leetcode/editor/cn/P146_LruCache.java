//<p>Design a data structure that follows the constraints of a <strong><a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU" target="_blank">Least Recently Used (LRU) cache</a></strong>.</p>
//
//<p>Implement the <code>LRUCache</code> class:</p>
//
//<ul> 
// <li><code>LRUCache(int capacity)</code> Initialize the LRU cache with <strong>positive</strong> size <code>capacity</code>.</li> 
// <li><code>int get(int key)</code> Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li> 
// <li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if the <code>key</code> exists. Otherwise, add the <code>key-value</code> pair to the cache. If the number of keys exceeds the <code>capacity</code> from this operation, <strong>evict</strong> the least recently used key.</li> 
//</ul>
//
//<p>The functions <code>get</code> and <code>put</code> must each run in <code>O(1)</code> average time complexity.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input</strong>
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//<strong>Output</strong>
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//<strong>Explanation</strong>
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= capacity &lt;= 3000</code></li> 
// <li><code>0 &lt;= key &lt;= 10<sup>4</sup></code></li> 
// <li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li> 
// <li>At most <code>2 * 10<sup>5</sup></code> calls will be made to <code>get</code> and <code>put</code>.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>设计 | 哈希表 | 链表 | 双向链表</details><br>
//
//<div>👍 2416, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

import java.util.LinkedHashMap;

/**
 * LRU Cache
 *
 * @author DY
 * @date 2022-09-28 21:22:36
 */
public class P146_LruCache {
    public static void main(String[] args) {
        //测试代码
        LRUCache solution = new P146_LruCache().new LRUCache(2);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        private final int capacity;

        private final LinkedHashMap<Integer, Integer> data;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.data = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (!data.containsKey(key)) {
                return -1;
            }
            makeRecently(key);
            return data.get(key);
        }

        private void makeRecently(int key) {
            data.put(key, data.remove(key));
        }

        public void put(int key, int value) {
            if (data.containsKey(key)) {
                data.remove(key);
                data.put(key, value);
                return;
            }
            if (data.size() >= this.capacity) {
                int removeKey = data.keySet().iterator().next();
                data.remove(removeKey);
            }
            data.put(key, value);
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
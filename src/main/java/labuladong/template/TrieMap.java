package labuladong.template;

import java.util.LinkedList;
import java.util.List;

public class TrieMap<V> {
    // ASCII 码个数
    private static final int R = 256;

    // 当前存在 Map 中的键值对个数
    private int size = 0;

    // Trie 树的根节点
    private TrieNode<V> root = null;

    private class TrieNode<V> {
        V value = null;
        TrieNode<V>[] children = new TrieNode[R];
    }

    public int size() {
        return size;
    }

    /**
     * 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
     *
     * @param node
     * @param key
     * @return
     */
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        for (int i = 0; i < key.length(); i++) {
            if (p == null) return null; // 无法往下搜索
            p = p.children[key.charAt(i)]; // 向下搜索
        }
        return p;
    }

    /**
     * 搜索 key 对应的值，不存在则返回 null
     *
     * @param key
     * @return
     */
    public V get(String key) {
        TrieNode<V> x = getNode(root, key);
        // x 为空或 x 的 val 字段为空都说明 key 没有对应的值
        if (x == null || x.value == null) return null;
        return x.value;
    }

    /**
     * 判断 key 是否存在在 Map 中
     *
     * @param key
     * @return
     */
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    /**
     * 判断是和否存在前缀为 prefix 的键
     *
     * @param prefix
     * @return
     */
    public boolean hasKeyWithPrefix(String prefix) {
        return getNode(root, prefix) != null;
    }

    /**
     * 在所有键中寻找 query 的最短前缀
     *
     * @param query
     * @return
     */
    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) return null; // 无法向下搜索
            if (p.value != null) {
                return query.substring(0, i); // 找到一个键是 query 的前缀
            }
            p = p.children[query.charAt(i)]; // 向下搜索
        }
        if (p != null && p.value != null) { // 如果 query 本身就是一个键
            return query;
        }
        return "";
    }

    /**
     * 在所有键中寻找 query 的最长前缀
     *
     * @param query
     * @return
     */
    public String longestPrefixOf(String query) {
        TrieNode<V> p = root;
        // 记录前缀的最大长度
        int max_len = 0;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) return null; // 无法向下搜索
            if (p.value != null) {
                max_len = i;
            }
            p = p.children[query.charAt(i)]; // 向下搜索
        }
        if (p != null && p.value != null) { // 如果 query 本身就是一个键
            return query;
        }
        return query.substring(0, max_len);
    }

    /**
     * 搜索前缀为 prefix 的所有键
     *
     * @param prefix
     * @return
     */
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new LinkedList<>();
        TrieNode<V> x = getNode(root, prefix);
        if (x == null) {
            return res;
        }
        traverse(x, new StringBuilder(prefix), res); // DFS 遍历以 x 为根的这棵 Trie 树
        return res;
    }

    /**
     * 遍历以 node 节点为根的 Trie 树，找到所有键
     *
     * @param node
     * @param path
     * @param res
     */
    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null) return; // 到达 Trie 树底部叶子结点
        if (node.value != null) {
            res.add(path.toString()); // 找到一个 key，添加到结果列表中
        }
        for (char c = 0; c < R; c++) { // 回溯算法遍历框架
            path.append(c); // 做选择
            if (node.children[c] != null) {
                traverse(node.children[c], path, res);
            }
            path.deleteCharAt(path.length() - 1); // 撤销选择
        }
    }

    /**
     * 通配符 . 匹配任意字符
     *
     * @param pattern
     * @return
     */
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        traverse(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    /**
     * 遍历函数，尝试在「以 node 为根的 Trie 树中」匹配 pattern[i..]
     *
     * @param root
     * @param path
     * @param pattern
     * @param i
     * @param res
     */
    private void traverse(TrieNode<V> root, StringBuilder path, String pattern, int i, List<String> res) {
        if (root == null) return; // 树枝不存在，即字符 pattern[i-1] 匹配失败
        if (i == pattern.length() && root.value != null) { //pattern 匹配完成
            res.add(path.toString()); // 如果这个节点存储着 val，则找到一个匹配的键
            return;
        }
        char ch = pattern.charAt(i);
        if (ch == '.') {
            // pattern[i] 是通配符，可以变化成任意字符
            // 多叉树（回溯算法）遍历框架
            for (char c = 0; c < R; c++) {
                path.append(c);
                if (root.children[c] != null) {
                    traverse(root.children[c], path, pattern, i + 1, res);
                }
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            path.append(ch); // pattern[i] 是普通字符 c
            if (root.children[ch] != null) {
                traverse(root.children[ch], path, pattern, i + 1, res);
            }
            path.deleteCharAt(path.length() - 1);
        }
    }

    /**
     * 在 map 中添加或修改键值对
     *
     * @param key
     * @param val
     */
    public void put(String key, V val) {
        if (!containsKey(key)) {
            size++;
        }
        root = put(root, key, val, 0);
    }

    /**
     * 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
     *
     * @param node
     * @param key
     * @param val
     * @param i
     */
    private TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
        if (node == null) {
            node = new TrieNode<>(); // 如果树枝不存在，新建
        }
        if (i == key.length()) { // key 的路径已插入完成，将值 val 存入节点
            node.value = val;
            return node;
        }
        char ch = key.charAt(i);
        node.children[ch] = put(node.children[ch], key, val, i + 1); // 递归插入子节点，并接收返回值
        return node;
    }

    /**
     * 在 Map 中删除 key
     *
     * @param key
     */
    public void remove(String key) {
        if (!containsKey(key)) {
            return;
        }
        remove(root, key, 0);
        size--;
    }

    /**
     * 定义：在以 node 为根的 Trie 树中删除 key[i..]，返回删除后的根节点
     *
     * @param node
     * @param key
     * @param i
     */
    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if (node == null) return null;
        if (i == key.length()) { // 找到了 key 对应的 TrieNode，删除 val
            node.value = null;
        } else {
            char ch = key.charAt(i);
            node.children[ch] = remove(node.children[ch], key, i + 1); // 递归去子树进行删除
        }
        if (node.value != null) { // 如果该 TireNode 存储着 val，不需要被清理
            return node;
        } else {
            for (char ch = 0; ch < R; ch++) { // 检查该 TrieNode 是否还有后缀
                if (node.children[ch] != null) { // 只要存在一个子节点（后缀树枝），就不需要被清理
                    return node;
                }
            }
            return null; // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
        }
    }
}

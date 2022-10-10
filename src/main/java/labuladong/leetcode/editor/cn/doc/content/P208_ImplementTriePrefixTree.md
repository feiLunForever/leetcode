<p>A <a href="https://en.wikipedia.org/wiki/Trie" target="_blank"><strong>trie</strong></a> (pronounced as "try") or <strong>prefix tree</strong> is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.</p>

<p>Implement the Trie class:</p>

<ul> 
 <li><code>Trie()</code> Initializes the trie object.</li> 
 <li><code>void insert(String word)</code> Inserts the string <code>word</code> into the trie.</li> 
 <li><code>boolean search(String word)</code> Returns <code>true</code> if the string <code>word</code> is in the trie (i.e., was inserted before), and <code>false</code> otherwise.</li> 
 <li><code>boolean startsWith(String prefix)</code> Returns <code>true</code> if there is a previously inserted string <code>word</code> that has the prefix <code>prefix</code>, and <code>false</code> otherwise.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input</strong>
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
<strong>Output</strong>
[null, null, true, false, true, null, true]

<strong>Explanation</strong>
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= word.length, prefix.length &lt;= 2000</code></li> 
 <li><code>word</code> and <code>prefix</code> consist only of lowercase English letters.</li> 
 <li>At most <code>3 * 10<sup>4</sup></code> calls <strong>in total</strong> will be made to <code>insert</code>, <code>search</code>, and <code>startsWith</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 字典树 | 哈希表 | 字符串</details><br>

<div>👍 1319, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，第 12 期刷题打卡 [开始报名](https://aep.xet.tech/s/XhcRc)，点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=208" target="_blank">⭐️labuladong 题解</a></strong></p>
</div>




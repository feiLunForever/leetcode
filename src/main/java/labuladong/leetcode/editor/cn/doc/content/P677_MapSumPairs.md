<p>Design a map that allows you to do the following:</p>

<ul> 
 <li>Maps a string key to a given value.</li> 
 <li>Returns the sum of the values that have a key with a prefix equal to a given string.</li> 
</ul>

<p>Implement the <code>MapSum</code> class:</p>

<ul> 
 <li><code>MapSum()</code> Initializes the <code>MapSum</code> object.</li> 
 <li><code>void insert(String key, int val)</code> Inserts the <code>key-val</code> pair into the map. If the <code>key</code> already existed, the original <code>key-value</code> pair will be overridden to the new one.</li> 
 <li><code>int sum(string prefix)</code> Returns the sum of all the pairs' value whose <code>key</code> starts with the <code>prefix</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
<strong>Output</strong>
[null, null, 3, null, 5]

<strong>Explanation</strong>
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (<u>ap</u>ple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (<u>ap</u>ple + <u>ap</u>p = 3 + 2 = 5)
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= key.length, prefix.length &lt;= 50</code></li> 
 <li><code>key</code> and <code>prefix</code> consist of only lowercase English letters.</li> 
 <li><code>1 &lt;= val &lt;= 1000</code></li> 
 <li>At most <code>50</code> calls will be made to <code>insert</code> and <code>sum</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>设计 | 字典树 | 哈希表 | 字符串</details><br>

<div>👍 221, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，第 12 期刷题打卡 [开始报名](https://aep.xet.tech/s/XhcRc)，点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=677" target="_blank">⭐️labuladong 题解</a></strong></p>
</div>




<p>Design a data structure that supports adding new words and finding if a string matches any previously added string.</p>

<p>Implement the <code>WordDictionary</code> class:</p>

<ul> 
 <li><code>WordDictionary()</code>&nbsp;Initializes the object.</li> 
 <li><code>void addWord(word)</code> Adds <code>word</code> to the data structure, it can be matched later.</li> 
 <li><code>bool search(word)</code>&nbsp;Returns <code>true</code> if there is any string in the data structure that matches <code>word</code>&nbsp;or <code>false</code> otherwise. <code>word</code> may contain dots <code>'.'</code> where dots can be matched with any letter.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong class="example">Example:</strong></p>

<pre>
<strong>Input</strong>
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
<strong>Output</strong>
[null,null,null,null,false,true,true,true]

<strong>Explanation</strong>
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= word.length &lt;= 25</code></li> 
 <li><code>word</code> in <code>addWord</code> consists of lowercase English letters.</li> 
 <li><code>word</code> in <code>search</code> consist of <code>'.'</code> or lowercase English letters.</li> 
 <li>There will be at most <code>3</code> dots in <code>word</code> for <code>search</code> queries.</li> 
 <li>At most <code>10<sup>4</sup></code> calls will be made to <code>addWord</code> and <code>search</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>深度优先搜索 | 设计 | 字典树 | 字符串</details><br>

<div>👍 464, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0，第 12 期刷题打卡 [开始报名](https://aep.xet.tech/s/XhcRc)，点击这里体验 [刷题全家桶](https://labuladong.gitee.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg)。**



<p><strong><a href="https://labuladong.github.io/article?qno=211" target="_blank">⭐️labuladong 题解</a></strong></p>
</div>




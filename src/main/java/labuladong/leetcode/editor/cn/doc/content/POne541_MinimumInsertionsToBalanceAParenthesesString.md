<p>Given a parentheses string <code>s</code> containing only the characters <code>'('</code> and <code>')'</code>. A parentheses string is <strong>balanced</strong> if:</p>

<ul> 
 <li>Any left parenthesis <code>'('</code> must have a corresponding two consecutive right parenthesis <code>'))'</code>.</li> 
 <li>Left parenthesis <code>'('</code> must go before the corresponding two consecutive right parenthesis <code>'))'</code>.</li> 
</ul>

<p>In other words, we treat <code>'('</code> as an opening parenthesis and <code>'))'</code> as a closing parenthesis.</p>

<ul> 
 <li>For example, <code>"())"</code>, <code>"())(())))"</code> and <code>"(())())))"</code> are balanced, <code>")()"</code>, <code>"()))"</code> and <code>"(()))"</code> are not balanced.</li> 
</ul>

<p>You can insert the characters <code>'('</code> and <code>')'</code> at any position of the string to balance it if needed.</p>

<p>Return <em>the minimum number of insertions</em> needed to make <code>s</code> balanced.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = "(()))"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = "())"
<strong>Output:</strong> 0
<strong>Explanation:</strong> The string is already balanced.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = "))())("
<strong>Output:</strong> 3
<strong>Explanation:</strong> Add '(' to match the first '))', Add '))' to match the last '('.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>s</code> consists of <code>'('</code> and <code>')'</code> only.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>栈 | 贪心 | 字符串</details><br>

<div>👍 66, 👎 0<span style='float: right;'></span></div>

<div id="labuladong"><hr>

</div>




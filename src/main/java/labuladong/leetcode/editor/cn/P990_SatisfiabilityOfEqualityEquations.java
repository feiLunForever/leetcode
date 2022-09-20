//<p>You are given an array of strings <code>equations</code> that represent relationships between variables where each string <code>equations[i]</code> is of length <code>4</code> and takes one of two different forms: <code>"x<sub>i</sub>==y<sub>i</sub>"</code> or <code>"x<sub>i</sub>!=y<sub>i</sub>"</code>.Here, <code>x<sub>i</sub></code> and <code>y<sub>i</sub></code> are lowercase letters (not necessarily different) that represent one-letter variable names.</p>
//
//<p>Return <code>true</code><em> if it is possible to assign integers to variable names so as to satisfy all the given equations, or </em><code>false</code><em> otherwise</em>.</p>
//
//<p>&nbsp;</p> 
//<p><strong>Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> equations = ["a==b","b!=a"]
//<strong>Output:</strong> false
//<strong>Explanation:</strong> If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
//There is no way to assign the variables to satisfy both equations.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> equations = ["b==a","a==b"]
//<strong>Output:</strong> true
//<strong>Explanation:</strong> We could assign a = 1 and b = 1 to satisfy both equations.
//</pre>
//
//<p>&nbsp;</p> 
//<p><strong>Constraints:</strong></p>
//
//<ul> 
// <li><code>1 &lt;= equations.length &lt;= 500</code></li> 
// <li><code>equations[i].length == 4</code></li> 
// <li><code>equations[i][0]</code> is a lowercase letter.</li> 
// <li><code>equations[i][1]</code> is either <code>'='</code> or <code>'!'</code>.</li> 
// <li><code>equations[i][2]</code> is <code>'='</code>.</li> 
// <li><code>equations[i][3]</code> is a lowercase letter.</li> 
//</ul>
//
//<details><summary><strong>Related Topics</strong></summary>并查集 | 图 | 数组 | 字符串</details><br>
//
//<div>👍 256, 👎 0</div>
//
//
//
//

package labuladong.leetcode.editor.cn;

/**
 * Satisfiability of Equality Equations
 *
 * @author DY
 * @date 2022-09-20 19:22:26
 */
public class P990_SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P990_SatisfiabilityOfEqualityEquations().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            UnionFind un = new UnionFind(26); // 26个字母
            for (String temp : equations) {
                if (temp.contains("==")) {
                    un.union(temp.charAt(0) - 'a', temp.charAt(3) - 'a'); // 先让相等的字母形成连通分量
                }
            }
            for (String temp : equations) {
                if (temp.contains("!")) {
                    if (un.connected(temp.charAt(0) - 'a', temp.charAt(3) - 'a')) { // 如果相等关系成立，就是逻辑冲突
                        return false;
                    }
                }
            }
            return true;
        }

		public class UnionFind {
			private int count; // 连通分量的个数
			private int[] parent; // 每个节点的父节点

			public UnionFind(int count) {
				this.count = count;
				this.parent = new int[count];
				for (int i = 0; i < count; i++) {
					parent[i] = i;
				}
			}

			public int find(int x) {
				if (x != parent[x]) {
					parent[x] = find(parent[x]);
				}
				return parent[x];
			}

			public void union(int p, int q) {
				int rootP = find(p);
				int rootQ = find(q);
				if (rootP != rootQ) {
					parent[rootP] = rootQ;
					count--;
				}
			}

			public boolean connected(int p, int q) {
				return find(p) == find(q);
			}

			public int count() {
				return count;
			}

		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}
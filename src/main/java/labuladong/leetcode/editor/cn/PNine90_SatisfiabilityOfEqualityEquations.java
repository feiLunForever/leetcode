/**
 * <p>You are given an array of strings <code>equations</code> that represent relationships between variables where each string <code>equations[i]</code> is of length <code>4</code> and takes one of two different forms: <code>"x<sub>i</sub>==y<sub>i</sub>"</code> or <code>"x<sub>i</sub>!=y<sub>i</sub>"</code>.Here, <code>x<sub>i</sub></code> and <code>y<sub>i</sub></code> are lowercase letters (not necessarily different) that represent one-letter variable names.</p>
 *
 * <p>Return <code>true</code><em> if it is possible to assign integers to variable names so as to satisfy all the given equations, or </em><code>false</code><em> otherwise</em>.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> equations = ["a==b","b!=a"]
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 * </pre>
 *
 * <p><strong class="example">Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> equations = ["b==a","a==b"]
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> We could assign a = 1 and b = 1 to satisfy both equations.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= equations.length &lt;= 500</code></li>
 * <li><code>equations[i].length == 4</code></li>
 * <li><code>equations[i][0]</code> is a lowercase letter.</li>
 * <li><code>equations[i][1]</code> is either <code>'='</code> or <code>'!'</code>.</li>
 * <li><code>equations[i][2]</code> is <code>'='</code>.</li>
 * <li><code>equations[i][3]</code> is a lowercase letter.</li>
 * </ul>
 *
 * <details><summary><strong>Related Topics</strong></summary>并查集 | 图 | 数组 | 字符串</details><br>
 *
 * <div>👍 297, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * Satisfiability of Equality Equations
 *
 * @author DY
 * @date 2023-06-07 17:18:10
 */
public class PNine90_SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PNine90_SatisfiabilityOfEqualityEquations().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class UF {
            private int count;
            private int[] parent;

            public UF(int n) {
                this.count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
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
                    --count;
                }
            }

            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }
        }

        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(26);
            for (String it : equations) {
                if ('=' == it.charAt(1)) {
                    char x = it.charAt(0);
                    char y = it.charAt(3);
                    uf.union(x - 'a', y - 'a');
                }
            }

            for (String it : equations) {
                if ('!' == it.charAt(1)) {
                    char x = it.charAt(0);
                    char y = it.charAt(3);
                    if (uf.connected(x - 'a', y - 'a')) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

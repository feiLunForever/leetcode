/**
English description is not available for the problem. Please switch to Chinese.
<details><summary><strong>Related Topics</strong></summary>位运算 | 数学</details><br>

<div>👍 409, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>




*/

package labuladong.leetcode.editor.cn;

/**
 * 不用加减乘除做加法 LCOF
 * @author DY
 * @date 2023-04-04 12:34:43
 */
public class PJianZhiOffer65_BuYongJiaJianChengChuZuoJiaFaLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new PJianZhiOffer65_BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
	 }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
		while (b != 0){
			int c = (a & b) << 1; // 进位
			a ^= b; // 异或，非进位相加
			b = c;
		}
		return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

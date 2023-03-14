/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>栈 | 树 | 二叉搜索树 | 递归 | 二叉树 | 单调栈</details><br>
 *
 * <div>👍 678, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 二叉搜索树的后序遍历序列 LCOF
 *
 * @author DY
 * @date 2023-03-13 14:03:49
 */
public class PJianZhiOffer33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PJianZhiOffer33_ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }

        private boolean recur(int[] postorder, int start, int end) {
            if (start >= end) return true; // 当左子树为空的时候，start > end
            // 从start节点往右遍历，找到root的左子树分界点（第一个比root节点大的节点）
            int leftEndIndex = start;
            while (postorder[leftEndIndex] < postorder[end]) ++leftEndIndex;
            // 判断右子树是否都比root节点大
            for (int i = leftEndIndex; i < end; i++) if (postorder[i] < postorder[end]) return false;

            return recur(postorder, start, leftEndIndex - 1) && recur(postorder, leftEndIndex, end - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

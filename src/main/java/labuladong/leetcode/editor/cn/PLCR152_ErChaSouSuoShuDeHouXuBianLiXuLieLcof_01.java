/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>栈 | 树 | 二叉搜索树 | 递归 | 二叉树 | 单调栈</details><br>
 *
 * <div>👍 766, 👎 0<span style='float: right;'></span></div>
 */

package labuladong.leetcode.editor.cn;

/**
 * 验证二叉搜索树的后序遍历序列
 *
 * @author DY
 * @date 2023-11-06 16:06:01
 */
public class PLCR152_ErChaSouSuoShuDeHouXuBianLiXuLieLcof_01 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR152_ErChaSouSuoShuDeHouXuBianLiXuLieLcof_01().new Solution();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyTreeOrder(int[] postorder) {
            return verifyTreeOrder(postorder, 0, postorder.length - 1);
        }

        private boolean verifyTreeOrder(int[] postorder, int start, int end) {
            if (start >= end) return true;
            int rightStartIndex = start;
            while (postorder[rightStartIndex] < postorder[end]) ++rightStartIndex;
            for (int i = rightStartIndex; i < end; i++) {
                if (postorder[i] < postorder[end]) return false;
            }
            return verifyTreeOrder(postorder, start, rightStartIndex - 1) && verifyTreeOrder(postorder, rightStartIndex, end - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

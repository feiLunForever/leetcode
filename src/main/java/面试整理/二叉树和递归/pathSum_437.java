package 面试整理.二叉树和递归;

public class pathSum_437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = dfs(root, sum); // 递归遍历 完整路径是否存在满足条件的节点
        res += pathSum(root.left, sum);  // 从左子树开始递归遍历（舍弃掉当前节点），查看是否存在满足条件的节点
        res += pathSum(root.right, sum); // 从右子树开始递归遍历（舍弃掉当前节点），查看是否存在满足条件的节点
        return res;
    }

    /**
     * 递归遍历 完整路径是否存在满足条件的节点
     *
     * @param root
     * @param sum
     * @return
     */
    private int dfs(TreeNode root, int sum) {
        int res = 0;
        if (root == null)
            return 0;
        if (root.val == sum) // 找到节点后，不能直接返回，因为子节点可能为负数，要继续递归查找
            res++;
        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);
        return res;
    }
}

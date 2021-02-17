package org.example.算法;

public class DFS {
    public static void treeDFS(TreeNode root) {
        //当前节点为空直接返回
        if (root == null)
            return;
        //打印当前节点的值
        System.out.println(root.val);
        //然后递归遍历左右子节点
        treeDFS(root.left);
        treeDFS(root.right);
    }
}

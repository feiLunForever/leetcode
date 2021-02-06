package 中级.树和图;

import java.util.Deque;
import java.util.LinkedList;

public class buildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        int inIndex = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = deque.peek();
            if (node.val != inorder[inIndex]) {
                node.left = new TreeNode(preorder[i]);
                deque.push(node.left);
            } else {
                while (!deque.isEmpty() && inorder[inIndex] == deque.peek().val) {
                    node = deque.pop();
                    inIndex++;
                }
                node.right = new TreeNode(preorder[i]);
                deque.push(node.right);
            }
        }
        return root;
    }
}

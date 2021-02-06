package 中级.树和图;

import java.util.*;

public class inorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

}

package org.example.剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class maxDepth_55_I {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepth1(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> treeNodeList = new ArrayList<>(), temp;
        int high = 0;
        treeNodeList.add(root);
        while (treeNodeList.size() > 0) {
            temp = new ArrayList<>();
            for (TreeNode node : treeNodeList) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            treeNodeList = temp;
            high++;
        }
        return high;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        node.left = node1;

        TreeNode node2 = new TreeNode(20);
        node.right = node2;

        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        node2.left = node3;
        node2.right = node4;
        System.out.println(maxDepth1(node));
    }
}

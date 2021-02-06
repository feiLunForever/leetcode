package org.example.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder_32_II {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rootList = new ArrayList<>();
        if (root == null) {
            return rootList;
        }
        List<TreeNode> treeNodeList = new ArrayList<>(), temp;
        treeNodeList.add(root);
        List<Integer> childNodeList = new ArrayList<>();
        childNodeList.add(root.val);
        rootList.add(childNodeList);
        while (!treeNodeList.isEmpty()) {
            temp = new ArrayList<>();
            childNodeList = new ArrayList<>();
            for (TreeNode node : treeNodeList) {
                if (null != node.left) {
                    temp.add(node.left);
                    childNodeList.add(node.left.val);
                }
                if (null != node.right) {
                    temp.add(node.right);
                    childNodeList.add(node.right.val);
                }
                treeNodeList = temp;
            }
            if (!childNodeList.isEmpty()) {
                rootList.add(childNodeList);
            }
        }
        return rootList;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for (int i = treeNodeQueue.size() - 1; i >= 0; i--) {
                TreeNode node = treeNodeQueue.poll();
                tempList.add(node.val);
                if (null != node.left) treeNodeQueue.add(node.left);
                if (null != node.right) treeNodeQueue.add(node.right);
            }
            res.add(tempList);
        }
        return res;
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
        System.out.println(levelOrder1(node));
    }
}

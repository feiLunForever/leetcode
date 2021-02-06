package org.example.算法;

import 初级.树.isValidBST;

import java.util.Deque;
import java.util.LinkedList;

public class ZX {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int[] zx(TreeNode root) {
        int[] ret = new int[100];
        Deque<TreeNode> stack = new LinkedList<>();
        int i = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ret[i++] = root.val;
            root = root.right;
        }
        return ret;
    }

    public static void main(String[] args) {
        // [1,2,3,4,null,null,5]
        TreeNode h = new TreeNode(2);
        TreeNode h2 = new TreeNode(1);
        TreeNode h3 = new TreeNode(3);
        h.left = h2;
        h.right = h3;
        int[] zx = zx(h);
        System.out.println();
    }
}

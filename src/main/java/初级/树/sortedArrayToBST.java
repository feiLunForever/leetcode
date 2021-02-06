package 初级.树;

public class sortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private static TreeNode help(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, left, mid - 1);
        node.right = help(nums, mid + 1, right);
        return node;
    }


}

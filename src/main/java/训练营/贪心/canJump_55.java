package 训练营.贪心;

public class canJump_55 {
    public boolean canJump(int[] nums) {
        if (nums == null)
            return false;
        int endReachableIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endReachableIndex) {
                endReachableIndex = i;
            }
        }
        return endReachableIndex == 0;
    }
}

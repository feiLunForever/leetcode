package review;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target)
                i++;
            else if (nums[i] + nums[j] > target)
                j--;
            else
                return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
}

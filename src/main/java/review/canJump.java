package review;

public class canJump {
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) { // num[i] >= end - i
            if (nums[i] >= end - i) {
                end = i;
            }
        }
        return end == 0;
    }
}

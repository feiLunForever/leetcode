package 面试整理.数组;

public class moveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int k = 0;// nums中[0,k]中都是非0元素
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                if (i != k) // 防止自己跟自己空操作
                    swap(nums, k++, i);
                else
                    k++;
            }
        }
    }
    private static void swap(int[] nums, int k, int i) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }
}

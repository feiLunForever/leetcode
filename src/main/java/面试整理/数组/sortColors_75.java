package 面试整理.数组;

public class sortColors_75 {
    public static void sortColors(int[] nums) {
        int zero = -1; // nums[0,zero]  -》 0
        int two = nums.length;  // nums[two,n-1]  -》 2
        int i = 0; // nums[zero+1,i-1]  -》 1
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i++);
            } else if (nums[i] == 1) {
                i++;
            } else { // nums[i] == 2
                swap(nums, --two, i);  // 此时nums[i] 交换后，还未处理，所有i不需要+1
            }
        }
    }

    private static void swap(int[] nums, int k, int i) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }
}

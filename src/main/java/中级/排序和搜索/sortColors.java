package 中级.排序和搜索;

public class sortColors {
    public static void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        int index = 0;
        if (two < 1)
            return;
        while (index <= two) {
            if (nums[index] == 0) {
                swap(nums, index, zero);
                zero++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, two);
                two--;
            }
        }

    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 1};
        sortColors(nums);
        System.out.println();
    }
}

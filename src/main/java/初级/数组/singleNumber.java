package 初级.数组;

public class singleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(singleNumber(nums));
    }
}

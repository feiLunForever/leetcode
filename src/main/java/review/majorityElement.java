package review;

public class majorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null)
            return 0;
        int temp = nums[0];
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                num++;
            } else {
                num--;
            }
            if (num == 0) {
                temp = nums[i];
                num = 1;
            }
        }
        return temp;
    }
}

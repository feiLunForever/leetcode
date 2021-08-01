package 训练营.递归_分支_回溯;

public class majorityElement_169 {
    public static int majorityElement(int[] nums) {
        int result = nums[0]; // 将数组的第一位假设为结果
        int count = 1; // 计数
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++; // 计数 +1
            } else {
                count--; // 计数 -1
                if (count == 0) { // 如果计数为0，则表示出现了比现在更多次数的元素
                    result = nums[i]; // 重置新的元素
                    count = 1; // 重置计数为 1
                }
            }
        }
        return result;
    }
}

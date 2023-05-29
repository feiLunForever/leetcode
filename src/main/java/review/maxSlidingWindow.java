package review;

import java.util.LinkedList;

public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 1)
            return nums;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> indexQueue = new LinkedList<>();
        for (int right = 0; right < nums.length; right++) { // 滑动窗口的右边界
            while (!indexQueue.isEmpty() && nums[right] > nums[indexQueue.peekLast()]) {
                indexQueue.pollLast(); // 维护单调递减队列
            }
            int left = right - k + 1; // 左边界
            indexQueue.offerLast(right);
            // 判断左边界是否有效
            if (indexQueue.peekFirst() < left) {
                indexQueue.pollFirst();
            }
            // 行成窗口
            if (right + 1 >= k) {
                res[left] = nums[indexQueue.peekFirst()];
            }
        }
        return res;
    }
}

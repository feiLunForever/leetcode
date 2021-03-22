package 面试整理.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class eraseOverlapIntervals_435 {
    /**
     * 动态规划版本
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        // 根据区间开始点排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[intervals.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] >= intervals[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return intervals.length - max;
    }

    /**
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        // 根据区间结束点倒排
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int pre = intervals[0][1]; //以第一个区间的结束点作为pre
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= pre){
                res++;
                pre = intervals[i][1];
            }
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(ints));
    }
}

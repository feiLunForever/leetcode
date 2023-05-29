package review;

import java.util.Arrays;

public class eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        int count = 1;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int lastEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > lastEnd) {
                count++;
                lastEnd = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}

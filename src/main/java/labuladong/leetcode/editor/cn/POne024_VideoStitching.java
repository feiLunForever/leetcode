/**
 * You are given a series of video clips from a sporting event that lasted time
 * seconds. These video clips can be overlapping with each other and have varying
 * lengths.
 * <p>
 * Each video clip is described by an array clips where clips[i] = [starti, endi]
 * indicates that the ith clip started at starti and ended at endi.
 * <p>
 * We can cut these clips into segments freely.
 * <p>
 * <p>
 * For example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
 * <p>
 * <p>
 * Return the minimum number of clips needed so that we can cut the clips into
 * segments that cover the entire sporting event [0, time]. If the task is impossible,
 * return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], time = 10
 * Output: 3
 * Explanation: We take the clips [0,2], [8,10], [1,9]; a total of 3 clips.
 * Then, we can reconstruct the sporting event as follows:
 * We cut [1,9] into segments [1,2] + [2,8] + [8,9].
 * Now we have segments [0,2] + [2,8] + [8,10] which cover the sporting event [0, 1
 * 0].
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: clips = [[0,1],[1,2]], time = 5
 * Output: -1
 * Explanation: We cannot cover [0,5] with only [0,1] and [1,2].
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: clips = [[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5
 * ],[2,6],[3,4],[4,5],[5,7],[6,9]], time = 9
 * Output: 3
 * Explanation: We can take clips [0,4], [4,7], and [6,9].
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= clips.length <= 100
 * 0 <= starti <= endi <= 100
 * 1 <= time <= 100
 * <p>
 * <p>
 * Related Topics贪心 | 数组 | 动态规划
 * <p>
 * 👍 334, 👎 0bug 反馈 | 使用指南 | 更多配套插件
 */

package labuladong.leetcode.editor.cn;

import java.util.Arrays;

/**
 * Video Stitching
 *
 * @author DY
 * @date 2023-06-23 22:08:53
 */
public class POne024_VideoStitching {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new POne024_VideoStitching().new Solution();
        System.out.println(solution.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int videoStitching(int[][] clips, int time) {
            if (time == 0) return 0;
            int n = clips.length;
            Arrays.sort(clips, (a, b) -> {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            });
            int res = 0;
            int end = 0, nextEnd = 0;
            int i = 0;
            while (i < n && clips[i][0] <= end) {
                while (i < n && clips[i][0] <= end) {
                    nextEnd = Math.max(nextEnd, clips[i][1]);
                    i++;
                }
                ++res;
                end = nextEnd;
                if (end >= time) {
                    return res;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

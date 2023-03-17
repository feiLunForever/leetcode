/**
 * English description is not available for the problem. Please switch to Chinese.
 * <details><summary><strong>Related Topics</strong></summary>设计 | 双指针 | 数据流 | 排序 | 堆（优先队列）</details><br>
 *
 * <div>👍 419, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>
 */

package labuladong.leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数  LCOF
 *
 * @author DY
 * @date 2023-03-17 14:47:59
 */
public class PJianZhiOffer41_ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        //测试代码
        MedianFinder solution = new PJianZhiOffer41_ShuJuLiuZhongDeZhongWeiShuLcof().new MedianFinder();
        solution.addNum(1);
        solution.addNum(2);
        solution.addNum(3);
        solution.findMedian();


        PriorityQueue<Integer> a1 = new PriorityQueue<>();
        PriorityQueue<Integer> a2 = new PriorityQueue<>((a, b) -> b - a);

        a1.offer(1);
        a1.offer(2);
        a1.offer(3);


        a2.offer(1);
        a2.offer(2);
        a2.offer(3);
        System.out.println();
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        /**
         * initialize your data structure here.
         */

        private final PriorityQueue<Integer> small;
        private final PriorityQueue<Integer> large;

        public MedianFinder() {
            small = new PriorityQueue<>();
            large = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }

        public double findMedian() {
            if (small.size() < large.size()) return large.peek();
            if (small.size() > large.size()) return small.peek();
            return (large.peek() + small.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}

package labuladong.template;

import java.util.HashMap;

public class SlidingWindow {

    /* 滑动窗口算法框架 */
    void slidingWindow(String s) {
        HashMap<Character, Integer> window;

        int left = 0, right = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 增大窗口
            right++;
            // TODO: 2022/8/15  进行窗口内数据的一系列更新

            /*** debug 输出的位置 ***/
            System.out.println("left is " + left + " , right is " + right);
            /********************/

            // 判断左侧窗口是否要收缩
            while (true
                //window needs shrink
            ) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // TODO: 2022/8/15 进行窗口内数据的一系列更新
            }
        }
    }
}

package org.example.算法.排序;

public class InsertionSort {

    public static void InsertionSort(int[] array) {
        if (array.length == 0 || array.length == 1)
            return;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            // 将 i+1 位置的数插入 0 到 i 之间的数组，从后往前遍历
            // current 指 i+1 的位置元素，pre 指 0 到 i 中依次向前遍历的指针
            int current = array[i + 1];
            int pre = i;
            while (pre >= 0 && array[pre] > current) {
                array[pre + 1] = array[pre];
                pre--;
            }
            // 最后将原来 i+1 位置的元素放入现在 0 到 i+1 之间数组中正确的位置上
            // pre+1 是因为刚才循环结束时又自减了一次
            array[pre + 1] = current;
        }
    }
}

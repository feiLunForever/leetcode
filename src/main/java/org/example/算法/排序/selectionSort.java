package org.example.算法.排序;

/**
 * 选择排序
 * <p>
 * 最佳情况：T(n) = O(n2)  最差情况：T(n) = O(n2)  平均情况：T(n) = O(n2)
 */
public class selectionSort {
    public static void selectionSort(int[] array) {
        if (array.length == 0 || array.length == 1)
            return;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
    }
}

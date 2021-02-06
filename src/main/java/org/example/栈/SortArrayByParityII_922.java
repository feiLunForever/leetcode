package org.example.栈;

public class SortArrayByParityII_922 {
    public static int[] sortArrayByParityII(int[] A) {
        int j = 1, n = A.length;
        for (int i = 0; i < n; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }


    public static void main(String[] args) {
        int[] a = new int[]{888,505,627,846};
        int[] ints = sortArrayByParityII(a);
        System.out.println();
    }
}


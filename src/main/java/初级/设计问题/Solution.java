package 初级.设计问题;

import java.util.Random;

public class Solution {

    private int[] arrays;

    private int[] originals;

    Random random = new Random();

    private int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public Solution(int[] nums) {
        arrays = nums;
        originals = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        arrays = originals;
        originals = originals.clone();
        return originals;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < arrays.length; i++) {
            swapAt(i, randRange(i, arrays.length));
        }
        return arrays;
    }

}

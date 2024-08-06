package 面试整理.栈和队列;

import java.util.*;

public class topKFrequent_347 {
    /**
     * 快排变形
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>(); // 记录元素出现的次数
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int[][] array = new int[2][map.size()]; // 第一行是原数组，第二行是出现的次数
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[0][i] = entry.getKey();
            array[1][i++] = entry.getValue();
        }
        return quickSort(array, 0, array[0].length - 1, k - 1);
    }

    /**
     * 快速排序
     *
     * @param originArray 原数组
     * @param start       开始下标
     * @param end         结束下标
     * @param target      目标下标
     * @return
     */
    private static int[] quickSort(int[][] originArray, int start, int end, int target) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数
        int k = partition(originArray, start, end);
        if (k == target)
            return Arrays.copyOfRange(originArray[0], 0, k + 1);
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return k > target ? quickSort(originArray, start, k - 1, target)
                : quickSort(originArray, k + 1, end, target);
    }

    /**
     * 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
     *
     * @param originArray
     * @param startIndex
     * @param endIndex
     * @return
     */
    private static int partition(int[][] originArray, int startIndex, int endIndex) {
        int freq = originArray[1][startIndex];
        int start = startIndex;
        int end = endIndex;
        // 以起点作为基准
        while (start < end) {
            while (start < end && originArray[1][end] <= freq) // 从后往前找，找比基准值大的值为止
                end--;
            while (start < end && originArray[1][start] >= freq) // 从前往后找，找到比基准值小的值为止
                start++;
            if (start < end)
                swap(originArray, start, end); // 交换位置
        }
        swap(originArray, start, startIndex); // 基准点和重合点交换位置
        return start;
    }


    private static void swap(int[][] originArray, int start, int end) {
        for (int i = 0; i < originArray.length; i++) {
            int temp = originArray[i][start];
            originArray[i][start] = originArray[i][end];
            originArray[i][end] = temp;
        }
    }

    /**
     * 堆排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent1(int[] nums, int k) {
        // 构造 HashMap。Key：nums 中的每个元素；Value：对应元素出现的次数（即频率）
        HashMap<Integer, Integer> store = new HashMap<>();
        for (Integer num : nums)
            store.put(num, store.getOrDefault(num, 0) + 1);
        // 构造小根堆（即最小堆），用于保存前 k 个出现频率最高的元素
        // 目的是让 minHeap 根据数字出现的频率进行升序排序（因为是小根堆，所以是升序）
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(store::get));
        for (Integer key : store.keySet()) {
            if (minHeap.size() < k)  // 填充 minHeap
                minHeap.offer(key);
            else if (store.get(key) > store.get(minHeap.peek())) {  // 只要满了，则推出最小值
                minHeap.poll();
                minHeap.offer(key);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!minHeap.isEmpty())
            res[i++] = minHeap.poll();
        return res;
    }

    /**
     * 桶排序
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent2(int[] nums, int k) {
        // 构造 HashMap。Key：nums 中的每个元素；Value：对应元素出现的次数（即频率）
        HashMap<Integer, Integer> store = new HashMap<>();
        for (Integer num : nums)
            store.put(num, store.getOrDefault(num, 0) + 1);

        // 构造一个桶的集合（即一系列桶），桶的个数为 nums 的长度 +1，因为 buckets[0] 没有意义
        // 目的是将出现频率为 i 的数放到第 i 个桶里（即 buckets[i]）
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : store.entrySet()) {
            if (buckets[entry.getValue()] == null) // 如果某个桶还未放入过数字（即未初始化），则初始化其为一个数组
                buckets[entry.getValue()] = new ArrayList<>();
            buckets[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0; i--) { // 遍历每个桶
            if (buckets[i] != null) { // 如果桶里有数字
                for (int j = 0; j < buckets[i].size() && index < k; j++) {
                    res[index++] = buckets[i].get(j); // 依次将桶里的数字填充进 res 数组中
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] ints = topKFrequent2(new int[]{3,2,3,1,2,4,5,5,6}, 4);
        System.out.println(Arrays.toString(ints));
    }


}

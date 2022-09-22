package labuladong.template;

import java.util.*;

public class Dijkstra {
    // 输入一幅图和一个起点 start，计算 start 到其他节点的最短距离
    public int[] dijkstra(int start, List<int[]>[] graph) {
        int n = graph.length;
        int[] disTo = new int[n]; // disTo[i] ==> start -> to 的最短距离
        Arrays.fill(disTo, Integer.MAX_VALUE);  // 初始化为最大值
        // 二元组 int[] {id, disToId}
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        disTo[start] = 0; // start => start 距离为0
        queue.add(new int[]{start, disTo[start]});

        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int id = item[0];
            int disToId = item[1];

            if (disToId > disTo[id]) {
                continue;
            }

            for (int[] neighbor : graph[id]) { // 遍历邻居
                int neighborId = neighbor[0];
                int disToNeighborId = disTo[id] + neighbor[1];
                if (disToNeighborId < disTo[neighborId]) { // 距离更小，则更新
                    disTo[neighborId] = disToNeighborId;
                    queue.offer(new int[]{neighborId, disToNeighborId});
                }
            }
        }
        return disTo;
    }
}

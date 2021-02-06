package 中级.回溯算法;

import java.util.*;

public class permute {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null)
            return list;
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            queue.offer(num);
        }
        dfs(list, queue, deque);
        return list;
    }

    private static void dfs(List<List<Integer>> list, Queue<Integer> queue, LinkedList<Integer> deque) {
        // 队列为空，则说明排列完成
        if (queue.isEmpty()) {
            list.add(new LinkedList<>(deque));
            return;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            deque.add(queue.poll());
            dfs(list, queue, deque);
            queue.offer(deque.removeLast());
        }
    }

    public static void main(String[] args) {
        String hello="hello world!";
        String hello1=new String("hello world!");
        System.out.println(hello==hello1); //1 f
        String hello2="hello world!";
        System.out.println(hello==hello2); //2 t
        String append="hello"+" world!";
        System.out.println(hello==append); //3 t
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println(pig==dog); //4 f
        final String dog1 = ("length: " + pig.length()).intern();
        System.out.println(pig==dog1); //5 t
        System.out. println("Animals are equal: "+ pig == dog);//6 f
    }


}

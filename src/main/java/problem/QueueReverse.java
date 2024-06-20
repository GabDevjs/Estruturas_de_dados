package problem;

import java.util.Queue;

public class QueueReverse {
    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k) {
        solveQueue(queue, k);
        int n = queue.size() - k;
        while (n-- > 0) {
            int temp = queue.remove();
            queue.add(temp);
        }
        return queue;
    }

    public static void solveQueue(Queue<Integer> queue, int k) {
        if (k == 0) {
            return;
        }
        int temp = queue.remove();
        solveQueue(queue, k - 1);
        queue.add(temp);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new java.util.LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println(reverseFirstK(queue, 3)); // [30, 20, 10, 40, 50]
    }
}

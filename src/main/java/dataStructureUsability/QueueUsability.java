package dataStructureUsability;

import  dataStructure.Node;
import  dataStructure.Queue;

public class QueueUsability {
    public  static  void main(String[] args) {
        System.out.println("Hello World!");

        String[] datas = {"1", "2", "3", "4", "5"};

        Queue queue = new Queue(datas[0]);
        System.out.println("Enqueue: " + datas[0]);
        for (int i = 1; i < datas.length; i++) {
            queue.enqueue(datas[i]);
            System.out.println("Enqueue: " + datas[i]);
        }

        var node = queue.dequeue();
        while (node != null) {
            System.out.println("Dequeue: " + node.getData());
            node = queue.dequeue();
        }

    }
}

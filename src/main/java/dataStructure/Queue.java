package dataStructure;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(String data) {
        Node newNode = new Node(data);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void getFirst() {
        if (this.first == null) {
            System.out.println("First vazio");
        } else {
            System.out.println("First" + first.data);
        }
    }

    public void getLast() {
        if (this.last == null) {
            System.out.println("Last vazio");
        } else {
            System.out.println("Last" + last.data);
        }
    }

    public void getLength() {
        System.out.println("Length" + this.length);
    }

    public void print() {
        Node temp = this.first;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if (length == 0) return null;
        Node temp = first;
        if (length == 1) {
            last = null;
            first = null;
        } else {
            first = first.next;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public Node peek() {
        return first;
    }

    public static void main(String[] args) {
        Queue queue = new Queue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");

        queue.print();

        queue.dequeue();
        queue.dequeue();

        queue.print();
    }
}

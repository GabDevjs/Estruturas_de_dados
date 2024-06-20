package dataStructure;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);

        head = newNode;
        tail = newNode;
    }

    // get metodos
    public void getHead() {
        if (this.head == null) {
            System.out.println("Head vazio");
        } else {
            System.out.println("Head" + head.data);
        }
    }


    public void getTail() {
        if (this.tail == null) {
            System.out.println("Tail vazio");
        } else {
            System.out.println("tail" + tail.data);
        }
    }

    public void getLength() {
        System.out.println("Leagth" + this.length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node pre = head;
        Node temp = null;

        while (pre.next != tail) {
            pre = pre.next;
        }

        temp = tail;
        tail = pre;
        tail.next = null;

        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }


    public void prepend(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
            head = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert(String data, int index) {
        if (index < 0 || index >= length) return false;
        if (index == 0) {
            prepend(data);
            return true;
        }
        if (index == length - 1) {
            append(data);
            return true;
        }
        Node newNode = new Node(data);
        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
        length++;
        return true;
    }

    public boolean set(String data, int index) {
        if (index < 0 || index >= length) return false;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = data;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return  removeFirst();
        if (index == length - 1) return removeLast();

        Node pre = head;
        for (int i = 0; i < index - 1; i++) {
            pre = pre.next;
        }
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList("primeiro");
        list.append("segundo");
        list.append("terceiro");
        list.append("quarto");
        list.append("quinto");
        list.append("sexto");
        list.append("setimo");
        list.append("oitavo");
        list.append("nono");
        list.append("decimo");
        list.print();
        System.out.println(" ");
        list.remove(5);
        list.print();
        System.out.println(" ");
        list.remove(0);
        list.print();
        System.out.println(" ");
        list.remove(7);
        list.print();
        System.out.println(" ");
        list.remove(0);
        list.print();
        System.out.println(" ");
    }
}


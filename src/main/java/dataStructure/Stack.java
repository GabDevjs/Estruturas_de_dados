package dataStructure;

public class Stack {
    private Node top;
    private int height;

    public Stack(String data) {
        height = 1;
        Node newNode = new Node(data);

        top = newNode;
    }

    public void getTop() {
        if (this.top == null) {
            System.out.println("Top vazio");
        } else {
            System.out.println("Top" + top.data);
        }
    }

    public void getHeight() {
        System.out.println("Height" + this.height);
    }

    public void print() {
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void push(String data) {
        Node newNode = new Node(data);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (height == 0)  return null;

        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }

    public Node peek() {
        return top;
    }

    public static void main(String[] args) {
        Stack stack = new Stack("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.print();
        stack.pop();
        stack.print();
        stack.getTop();
        stack.getHeight();
    }
}

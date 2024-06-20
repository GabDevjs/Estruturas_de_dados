package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public NodeTree root;

    public void insert(int value) {
        if (root == null) root = new NodeTree(value);
        else {
            NodeTree newNode = new NodeTree(value);
            Queue<NodeTree> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                NodeTree currentNode = queue.remove();

                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }

                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void preOrder( ) {
        preOrder(root);
    }

    private void preOrder(NodeTree node) {
        // root, left, right
        if (node == null) return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder( ) {
        inOrder(root);
    }

    private void inOrder(NodeTree node) {
        // left, root, right
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void postOrder( ) {
        postOrder(root);
    }

    private void postOrder(NodeTree node) {
        // left, right, root
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public void BFS() {
        if (root == null) return;
        Queue<NodeTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            NodeTree currentNode = queue.remove();
            System.out.println(currentNode.data);

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.preOrder();
    }
}

package dataStructure;

public class NodeTree {
    public int data;

    public NodeTree left;
    public NodeTree right;

    public NodeTree(int data) {
        this.data = data;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}

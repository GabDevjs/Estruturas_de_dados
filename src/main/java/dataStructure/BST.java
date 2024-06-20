package dataStructure;

public class BST {
    public NodeTree root;

    public void insert(int value) {
        if (root == null) {
            root = new NodeTree(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(final NodeTree node,final int value) {
        if (node == null) return;
        if (value == node.data) return;
        if (value < node.data) {
            if (node.left == null) {
                node.left = new NodeTree(value);
            } else {
                insert(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new NodeTree(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final NodeTree node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(final NodeTree node, final int value) {
        if (node == null) return false;
        if (value == node.data) return true;
        if (value < node.data) {
            return contains(node.left, value);
        } else {
            return contains(node.right, value);
        }
    }

    public int minValue(NodeTree current) {
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public void deleteNode(int value) {
       root = deleteNode(root, value);
    }

    private NodeTree deleteNode(NodeTree root, int value) {
        if (root == null) return null;
        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);

        bst.inOrder();
    }
}

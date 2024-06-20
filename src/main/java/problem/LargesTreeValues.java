package problem;

import dataStructure.NodeTree;
import  dataStructure.Tree;
import java.util.List;

public class LargesTreeValues {
    public static List<Integer> largestValues(Tree tree) {
        var list = new java.util.ArrayList<Integer>();
        solveTree(tree.root, list, 0);
        return list;
    }

    public static void solveTree(NodeTree node, List<Integer> list, int level) {
        if (node == null) {
            return;
        }
        if (list.size() == level) {
            list.add(node.data);
        } else {
            list.set(level, Math.max(list.get(level), node.data));
        }

        solveTree(node.left, list, level + 1);
        solveTree(node.right, list, level + 1);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(3);
        tree.insert(9);

        System.out.println(largestValues(tree)); // [1, 3, 9]
    }
}

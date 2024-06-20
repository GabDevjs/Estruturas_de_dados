package dataStructureUsability;

import dataStructure.Node;
import dataStructure.Stack;

public class StackUsability {
    public static dataStructure.Stack invertStack(dataStructure.Stack stack) {
        dataStructure.Stack invertedStack = new dataStructure.Stack(stack.peek().getData());
        stack.pop();
        while (stack.peek() != null) {
            invertedStack.push(stack.peek().getData());
            stack.pop();
        }
        return invertedStack;
    };

    public static dataStructure.Stack createStack(String[] datas) {
        dataStructure.Stack stack = new dataStructure.Stack(datas[0]);
        for (int i = 1; i < datas.length; i++) {
            stack.push(datas[i]);
        }
        return stack;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] datas = {"1", "2", "3", "4", "5"};

        dataStructure.Stack stack = createStack(datas);

        stack.print();
        stack = invertStack(stack);
        stack.print();
    }
}

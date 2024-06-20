package problem;

import java.util.Set;
import java.util.Stack;

public class BalanceamentoDeParenteses {
    public static boolean solve(String expression) {
        Set<Character> openSymbols = Set.of('(', '[', '{');
        Set<Character> closeSymbols = Set.of(')', ']', '}');

        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (openSymbols.contains(c)) {
                stack.push(c);
            } else if (closeSymbols.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char openSymbol = stack.pop();
                if (openSymbol == '(' && c != ')') {
                    return false;
                }
                if (openSymbol == '[' && c != ']') {
                    return false;
                }
                if (openSymbol == '{' && c != '}') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solve("()")); // true
        System.out.println(solve("()[]{}")); // true
        System.out.println(solve("(]")); // false
        System.out.println(solve("([)]")); // false
        System.out.println(solve("{[]}")); // true
    }
}

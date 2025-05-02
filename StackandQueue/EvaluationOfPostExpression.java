package StackandQueue;
import java.util.*;

public class EvaluationOfPostExpression {
    static int evaluate(String[] arr) {
        Stack<Integer> s = new Stack<>();
        for (String str : arr) {
            if (str.matches("-?\\d+")) {
                s.push(Integer.parseInt(str));
            } else {
                int val1 = s.pop();
                int val2 = s.pop();
                switch (str) {
                    case "+":
                        s.push(val2 + val1);
                        break;

                    case "-":
                        s.push(val2 - val1);
                        break;

                    case "*":
                        s.push(val2 * val1);
                        break;

                    case "/":
                        s.push(val2 / val1);
                        break;

                }
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String[] arr = { "2", "3", "1", "*", "+", "9", "-" };
        System.out.println(evaluate(arr));
    }
}

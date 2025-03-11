package String;

// https://leetcode.com/problems/valid-parentheses/description/
import java.util.*;

public class ValidParenthesis {
    public static boolean isparenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty() ||
                        c == ')' && st.pop() != '(' ||
                        c == ']' && st.pop() != '[' ||
                        c == '}' && st.pop() != '{') {

                            return false;
                }
            }
        }
        return st.isEmpty();

    }

    public static void main(String[] args) {

        String str="([]))";
        System.out.println(isparenthesis(str));
    }
}

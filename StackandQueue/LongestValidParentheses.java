package StackandQueue;

public class LongestValidParentheses {
    public static int longestLength(String str) {

        int open = 0;
        int close = 0;
        int max = 0;
        // left to right traveral
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                open++;
            } else if(ch==')') {
                close++;
            }
            if (open == close) {
               max= Math.max(max, close * 2);
            } else if (close > open) {
                open = close = 0;
            }

        }
 
        // right to left traversal
        open = close = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '(') {
                open++;
            } else if(ch==')') {
                close++;
            }
            if (open == close) {
              max=  Math.max(max, close * 2);
            } else if (open > close) {
                open = close = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestLength(s));

    }
}

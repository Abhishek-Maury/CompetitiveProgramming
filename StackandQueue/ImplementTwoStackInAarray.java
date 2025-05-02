package StackandQueue;

import java.util.*;

public class ImplementTwoStackInAarray {
    static class Twostack {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static void push1(int data) {

            s1.push(data);
        }

        public static void push2(int data) {

            s2.push(data);
        }

        public static int pop1() {
            if (s1.isEmpty()) {
                // System.out.println("Stack 1 is Empty");
                return -1;
            } else {
                return s1.pop();

            }
        }

        public static int pop2() {
            if (s2.isEmpty()) {
                // System.out.println("Stack 2 is Empty");
                return -1;
            } else {
                return s2.pop();

            }
        }
    }

    public static void main(String[] args) {
        Twostack ts = new Twostack();
        ts.push1(2);
        ts.push1(3);
        ts.push2(4);

        System.out.print(ts.pop1() + " ");
        System.out.print(ts.pop2() + " ");
        System.out.print(ts.pop2() + " ");
    }
}

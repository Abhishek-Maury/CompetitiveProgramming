package StackandQueue;

import java.util.*;

public class CelibrityProblem {
    public static int cele(int[][] arr){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        for (int i = 0; i < n; i++) {
            s.push(i);
        }
        while (s.size()>1) {
            int i=s.pop();
            int j=s.pop();
            if (arr[i][j]==0) {
                s.push(i);
            }else{
                s.push(j);
            }
        }
        int celeb=s.peek();
        for (int i = 0; i < n; i++) {
            if ((i!=celeb) && (arr[i][celeb]==0 || arr[celeb][i]==1)) {
                return -1;
            }
        }
        return celeb;
    }
    public static void main(String[] args) {
        int[][] arr={
            {0,1,0},
            {0,0,0},
            {0,1,0}
        };
        System.out.println(cele(arr));

    }
}

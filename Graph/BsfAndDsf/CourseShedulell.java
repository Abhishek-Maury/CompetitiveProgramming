package Graph.BsfAndDsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseShedulell {
     public static boolean findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        int[] indeg =new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i]=new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            indeg[edge[0]]++; //edge 0 is the dest 
        }
        Queue<Integer> q =new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]==0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr=q.remove();
            for (int i : graph[curr]) {
               indeg[i]--;
               if (indeg[i]==0) {
                q.add(i);
               }
            }
        }

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]!=0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int  numCourses = 4;
        int[][]prerequisites = {
            {1,0},
            {2,0},
            {3,1},
            {3,2}
        };
        System.out.println(findOrder(numCourses, prerequisites));
    }
                
}

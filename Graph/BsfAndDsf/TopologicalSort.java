package Graph.BsfAndDsf;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
      public static class Edge {
        int src;
        int des;
       

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
            
        }

    }

    // Make a Adjacency List from Scrach
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));



    }

    public static void topSort(ArrayList<Edge>[] graph){
        boolean[] vis=new boolean[graph.length];
        Stack<Integer> s= new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph,i,vis,s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis,Stack<Integer> s){
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            if (!vis[e.des]) {
                topSortUtil(graph, e.des, vis, s);
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
         int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}

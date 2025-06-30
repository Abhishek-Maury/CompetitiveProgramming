package Graph.BsfAndDsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBfs {
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
    public static void calIndeg( ArrayList<Edge>[] graph,int[] indeg){
        for (int i = 0; i < graph.length; i++) {
            int v=i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e=graph[v].get(j);
                indeg[e.des]++;
            }
        }
    }
    public static void topSortBfs(ArrayList<Edge>[] graph){
        int[] indeg=new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i]==0) {
                q.add(i);
            }
        }
        // bfs
        while (!q.isEmpty()) {
            int curr=q.remove();
            System.out.print(curr+" ");  //printing work of the topological sort
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e=graph[curr].get(i);
                indeg[e.des]--;
                if (indeg[e.des]==0) {
                    q.add(e.des);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
          int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSortBfs(graph);
    }
}

package Graph.BsfAndDsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Learning {
    public static class Edge{
        int src;
        int des;
        int wt;
        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
        
    }
    // Make a Adjacency List from Scrach
    public static void createGraph(ArrayList<Edge>[] graph){
      for (int i = 0; i < graph.length; i++) {
        graph[i]=new ArrayList<>();
      }
      graph[0].add(new Edge(0 ,1,1));
      graph[0].add(new Edge(0 ,2,1));

      graph[1].add(new Edge(1 ,0,1));
      graph[1].add(new Edge(1 ,3,1));

      graph[2].add(new Edge(2 ,0,1));
      graph[2].add(new Edge(2 ,4,1));

      graph[3].add(new Edge(3 ,1,1));
      graph[3].add(new Edge(3 ,4,1));
      graph[3].add(new Edge(3 ,5,1));

      graph[4].add(new Edge(4 ,2,1));
      graph[4].add(new Edge(4 ,3,1));
      graph[4].add(new Edge(4 ,5,1));

      graph[5].add(new Edge(5 ,3,1));
      graph[5].add(new Edge(5 ,4,1));
      graph[5].add(new Edge(5 ,6,1));

      graph[6].add(new Edge(6 ,5,1));
    }
//BFS for Connected comonents and also other   
     public static void bfs(ArrayList<Edge>[] graph){
      boolean[] vis=new boolean[graph.length];

      for (int i = 0; i < graph.length; i++) {
        if (!vis[i]) {
          bfsUtil(graph, vis);
        }
      }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph,boolean[] vis){
      Queue<Integer> q = new LinkedList<>();
      q.add(0);

      while (!q.isEmpty()) {
        int curr = q.remove();
        if (!vis[curr]) {
          vis[curr]=true;
          System.out.print(curr+" ");
          for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            q.add(e.des);
          }
        }
      }
    }

    // DFS for  all connected components
    public static void dfs(ArrayList<Edge>[] graph){
      boolean[] vis = new boolean[graph.length];
      for (int i = 0; i < graph.length; i++) {
        if (!vis[i]) {
          dfsUtil(graph, i, vis);
        }
      }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph,int curr,boolean[] vis){
      System.out.print(curr+" ");
      vis[curr]=true;
      for (int i = 0; i <graph[curr].size(); i++) {
        Edge e=graph[curr].get(i);
        if (!vis[e.des]) {
          dfsUtil(graph, e.des, vis);
        }
      }
    }
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        dfs(graph);
    }
}

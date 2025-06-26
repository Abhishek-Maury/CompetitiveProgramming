package Graph.BsfAndDsf;

import java.util.ArrayList;

public class CycleDecetionInUndirectedGraph {
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

    // Cycle detection For undirected graph (DFS)
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] =new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph,vis,i,-1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph,boolean[] vis,int curr,int par){
        vis[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e=graph[curr].get(i);
            // case 3
            if (!vis[e.des] && isCycleUtil(graph, vis, e.des, curr)) {
                return true;
            }
            // case 1
            else if(vis[e.des] && e.des!=par){
                return true;
            }
            // case 2
            // do nothing --> continue
        }
        return false;
    }
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}

package Graph.BsfAndDsf;

import java.util.ArrayList;

public class CycleDectectionOnDirectedGraph {
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

        // graph[1].add(new Edge(1, 0));

        // graph[2].add(new Edge(2, 0));

        // graph[3].add(new Edge(3, 0));
        // graph[3].add(new Edge(3, 2));
      
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));


    }

    public static boolean isCyclee(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleeUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    // DFS
    public static boolean isCycleeUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        // Make an boolean type of array of size of graph.length and store recurion calls 
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.des]) {
                return true;
            }
            if (!vis[e.des] && isCycleeUtil(graph, e.des, vis, stack)) {
                return true;
            }
        }
        // when backtrack calls make it false
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCyclee(graph));
    }
}

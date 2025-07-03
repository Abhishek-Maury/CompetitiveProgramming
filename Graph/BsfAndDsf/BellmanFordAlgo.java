package Graph.BsfAndDsf;

import java.util.ArrayList;

public class BellmanFordAlgo {
    public static class Edge {
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
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));

    }

    public static void bellman(ArrayList<Edge>[] graph,int src){
        int[] dis=new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i!=src) {
                dis[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        //O(V*E)
        for (int i = 0; i < V-1; i++) {
            //edge
            //(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e=graph[j].get(k);
                    int u=e.src;
                    int v=e.des;
                    int wt=e.wt;
                    if (dis[u]!=Integer.MAX_VALUE && dis[u]+wt<dis[v]) {
                        dis[v]=dis[u]+wt;
                    }
                }
            }
        }
        for (int i = 0; i < dis.length; i++) {
            System.out.print(dis[i]+" ");
        }
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        int src=0;
        bellman(graph, src);
    }
}

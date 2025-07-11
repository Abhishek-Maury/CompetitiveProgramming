package Graph.BsfAndDsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.des] == -1) {
                            int nextColor = col[curr] == 0 ? 1 : 0;
                            col[e.des] = nextColor;
                            q.add(e.des);
                        } else if (col[e.des] == col[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // using DFS (Bipartite graph)
    private static boolean dfs(ArrayList<Edge>[] graph, int curr, int col, int[] color) {
        color[curr] = col;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (color[e.des] == -1) {
                dfs(graph, e.des, 1 - col, color);
            } else if (color[e.des] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean dfsBipartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (dfs(graph, i, 0, color) == false) {
                    return false;
                }
                
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        // System.out.println(isBipartite(graph));
        System.out.println(dfsBipartite(graph));
    }
}

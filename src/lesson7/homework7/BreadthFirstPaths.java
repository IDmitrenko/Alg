package lesson7.homework7;

import lesson7.Graph;

import java.util.LinkedList;

public class BreadthFirstPaths extends FirstPaths {
    private int[] distTo;
    private final int INFINITY = Integer.MAX_VALUE;

    public BreadthFirstPaths(Graph g, int source) {
        super(g, source);
        distTo = new int[g.getVertexCount()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INFINITY;
        }
        bfs(g, source);
    }

    private void bfs(Graph g, int v) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(v);
        marked[v] = true;
        distTo[v] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int w : g.getAdjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] + 1;
                    queue.addLast(w);
                }
            }
        }
    }

    public int distTo(int v) {
        return distTo[v];
    }

}

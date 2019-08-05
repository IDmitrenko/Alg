package lesson7.homework7;

import lesson7.Graph;

import java.util.LinkedList;

public class FirstPaths {
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;

    public FirstPaths(Graph mg, int source) {
        this.source = source;
        edgeTo = new int[mg.getVertexCount()];
        marked = new boolean[mg.getVertexCount()];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

}

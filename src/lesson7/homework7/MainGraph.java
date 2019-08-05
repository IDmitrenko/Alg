package lesson7.homework7;

import lesson7.Graph;

public class MainGraph {

    public static void main(String[] args) {
        Graph mg = new Graph(10);
        mg.addEdge(0, 3);
        mg.addEdge(0, 6);
        mg.addEdge(0, 7);
        mg.addEdge(1, 2);
        mg.addEdge(1, 3);
        mg.addEdge(1, 4);
        mg.addEdge(1, 5);
        mg.addEdge(1, 6);
        mg.addEdge(2, 1);
        mg.addEdge(2, 6);
        mg.addEdge(3, 0);
        mg.addEdge(3, 1);
        mg.addEdge(4, 1);
        mg.addEdge(4, 9);
        mg.addEdge(5, 1);
        mg.addEdge(5, 6);
        mg.addEdge(6, 0);
        mg.addEdge(6, 1);
        mg.addEdge(6, 2);
        mg.addEdge(6, 5);
        mg.addEdge(6, 7);
        mg.addEdge(6, 8);
        mg.addEdge(6, 9);
        mg.addEdge(7, 0);
        mg.addEdge(7, 6);
        mg.addEdge(7, 9);
        mg.addEdge(8, 6);
        mg.addEdge(9, 4);
        mg.addEdge(9, 6);
        mg.addEdge(9, 7);

        BreadthFirstPaths bfp = new BreadthFirstPaths(mg, 2);

        if (bfp.hasPathTo(9)) {
            System.out.println("Кратчайший путь от вершины 2 к вершине 9 - " + bfp.distTo(9));
            System.out.println("Путь от вершины 2 к вершине 9 - " + bfp.pathTo(9));
        }
        if (bfp.hasPathTo(5)) {
            System.out.println("Кратчайший путь от вершины 2 к вершине 5 - " + bfp.distTo(5));
            System.out.println("Путь от вершины 2 к вершине 5 - " + bfp.pathTo(5));
        }
        if (bfp.hasPathTo(7)) {
            System.out.println("Кратчайший путь от вершины 2 к вершине 7 - " + bfp.distTo(7));
            System.out.println("Путь от вершины 2 к вершине 7 - " + bfp.pathTo(7));
        }

    }
}

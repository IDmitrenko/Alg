package lesson7;

public class Main {
    public static void main(String[] args) {
        Graph graph= new Graph(10);
        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(3,4);
        graph.addEdge(7,8);

        System.out.println(graph.getAdjList(1));

//        DepthFirstPaths dfp = new DepthFirstPaths(graph,2);

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph,2);

        System.out.println(bfp.hasPathTo(2));
        System.out.println(bfp.pathTo(3));
        System.out.println(bfp.hasPathTo(7));

    }
}

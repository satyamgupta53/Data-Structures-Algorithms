package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversals {
    public static void createGraph(ArrayList<ArrayList<Edge>> graph) {
        graph.replaceAll(ignored -> new ArrayList<Edge>());
        /// for (int i = 0; i < graph.size(); i++) graph.set(i, new ArrayList<Edge>());

        graph.getFirst().add(new Edge(0, 1));
        graph.getFirst().add(new Edge(0, 2));

        graph.get(1).add(new Edge(1, 0));
        graph.get(1).add(new Edge(1, 3));

        graph.get(2).add(new Edge(2, 0));
        graph.get(2).add(new Edge(2, 4));

        graph.get(3).add(new Edge(3, 1));
        graph.get(3).add(new Edge(3, 4));
        graph.get(3).add(new Edge(3, 5));

        graph.get(4).add(new Edge(4, 2));
        graph.get(4).add(new Edge(4, 3));
        graph.get(4).add(new Edge(4, 5));

        graph.get(5).add(new Edge(5, 3));
        graph.get(5).add(new Edge(5, 4));
        graph.get(5).add(new Edge(5, 6));

        graph.getLast().add(new Edge(6, 5));
    }

    public static void breadthFirstSearch(ArrayList<ArrayList<Edge>> graph, int vertices, boolean[] visited, int startingPoint) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingPoint);

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (int i = 0; i < graph.get(curr).size(); i++)
                    queue.add(graph.get(curr).get(i).destination);
            }
        }
    }

    public static void depthFirstSearch(ArrayList<ArrayList<Edge>> graph, int curr, boolean[] visited) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge edge = graph.get(curr).get(i);
            if (!visited[edge.destination]) depthFirstSearch(graph, edge.destination, visited);
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        /*
                1 --- 3
              /       | \
             0        |  5 --- 6
              \       | /
               2 ---- 4
         */
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        createGraph(graph);

        // considering the possibility of disconnected components
        boolean[] visited = new boolean[vertices];
        System.out.println("Breadth First Search : ");
        for (int i = 0; i < visited.length; i++)
            if (!visited[i]) {
                breadthFirstSearch(graph, vertices, visited, i);
                System.out.println();
            }

        // depth-first search with re-initialising
        visited = new boolean[vertices];
        System.out.println("Depth First Search : ");
        for (int i = 0; i < visited.length; i++)
            if (!visited[i]) {
                depthFirstSearch(graph, i, visited);
                System.out.println();
            }
    }

    public static class Edge {
        int source, destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
}

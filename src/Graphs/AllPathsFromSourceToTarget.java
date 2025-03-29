package Graphs;

import java.util.ArrayList;

public class AllPathsFromSourceToTarget {
    public static void createGraph(ArrayList<ArrayList<Edge>> graph) {
        graph.replaceAll(ignored -> new ArrayList<Edge>());

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

    // time complexity = O(v ^ v)
    public static void printAllPaths
            (ArrayList<ArrayList<Edge>> graph, int curr, boolean[] visited, String currentPath, int target) {
        if (curr == target) {
            System.out.println(currentPath);
            return;
        }

        for (int i = 0; i < graph.get(curr).size(); i++) {
            Edge edge = graph.get(curr).get(i);
            if (!visited[edge.destination]) {
                visited[curr] = true;
                printAllPaths(graph, edge.destination, visited, currentPath + " " + edge.destination, target);
                visited[curr] = false;
            }
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
        for (int i = 0; i < vertices; i++) graph.add(new ArrayList<>());
        createGraph(graph);

        printAllPaths(graph, 0, new boolean[vertices], "0", 6);
    }

    public static class Edge {
        int source, destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
}

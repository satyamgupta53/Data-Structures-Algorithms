package Graphs;

import java.util.ArrayList;

public class WeightedGraph {
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<Edge>();

        graph[0].add(new Edge(0, 2, 2));
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));
        graph[3].add(new Edge(3, 2, -1));
        graph[3].add(new Edge(3, 1, 0));
    }

    public static void printNeighbor(ArrayList<Edge>[] graph, int nodeNumber) {
        for (int i = 0; i < graph[nodeNumber].size(); i++)
            System.out.println("Neighbor: " + graph[nodeNumber].get(i).destination + " and Weight: " + graph[nodeNumber].get(i).weight);
    }

    public static void main(String[] args) {
        int vertices = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph); // used adjacency list method to store graph
        printNeighbor(graph, 2);
    }

    public static class Edge {
        int source, destination, weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
}

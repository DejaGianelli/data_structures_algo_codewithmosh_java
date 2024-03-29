package com.codewithmosh.part2;

import java.util.List;

public class TopologicalSorting {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("X");
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("P");
        graph.addEdge("X", "A");
        graph.addEdge("X", "B");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        List<String> orderedNodes = graph.topologicalSort();
        System.out.println(orderedNodes);
    }
}

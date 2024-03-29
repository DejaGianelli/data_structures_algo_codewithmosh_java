package com.codewithmosh.part2;

import java.util.*;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException();
        }
        var toNode = nodes.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if (node == null) {
            return;
        }
        for (var n : adjacencyList.keySet()) {
            adjacencyList.get(n).remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(label);
    }


    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>(nodes.values());
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node, Set<Node> all,
                             Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);
        for (var neighbour : adjacencyList.get(node)) {
            if (visited.contains(neighbour)) {
                continue;
            }
            if (visiting.contains(neighbour)) {
                return true;
            }
            if (hasCycle(neighbour, all, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

    public List<String> topologicalSort() {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (var node : nodes.values()) {
            topologicalSort(node, visited, stack);
        }
        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty()) {
            sorted.add(stack.pop().label);
        }
        return sorted;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (var neighbour : adjacencyList.get(node)) {
            topologicalSort(neighbour, visited, stack);
        }
        stack.push(node);
    }

    // The reason this is breadth first is because of the Queue (FIFO)

    public void traverseBreadthFirst(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (visited.contains(current)) {
                continue;
            }
            System.out.println(current);
            visited.add(current);
            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
    }

    // The reason this is depth first is because of the Stack (LIFO)

    public void traverseDepthFirstRec(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;
        traverseDepthFirstRec(node, new HashSet<>());
    }

    public void traverseDepthFirst(String root) {
        var node = nodes.get(root);
        if (node == null)
            return;
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }
            System.out.println(current);
            visited.add(current);
            for (var neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
    }

    private void traverseDepthFirstRec(Node root, Set<Node> visited) {
        System.out.println(root);
        visited.add(root);
        for (var node : adjacencyList.get(root)) {
            if (!visited.contains(node)) {
                traverseDepthFirstRec(node, visited);
            }
        }
    }

    public void print() {
        for (var source : adjacencyList.keySet()) {
            var targets = adjacencyList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");

        //Traversing the graph with recursion
        graph.traverseDepthFirstRec("A");
        System.out.println("-------------");
        graph.traverseDepthFirstRec("C");

        //traversing the graph iteratively
        System.out.println("-------------");
        graph.traverseDepthFirst("A");

        System.out.println("-------------");
        graph.traverseBreadthFirst("A");

        System.out.println("-------------");
        System.out.println(graph.hasCycle());

        var cyclic = new Graph();
        cyclic.addNode("A");
        cyclic.addNode("B");
        cyclic.addNode("C");
        cyclic.addEdge("A", "B");
        cyclic.addEdge("B", "C");
        cyclic.addEdge("C", "A");
        System.out.println(cyclic.hasCycle());

//        graph.print();
//        graph.removeEdge("A", "C");
//        graph.print();
//        graph.removeNode("A");
//        graph.print();
//        graph.addEdge("B", "C");
//        graph.print();
    }
}

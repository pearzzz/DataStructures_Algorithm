package com.pearz.data_structure.graph;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import jdk.nashorn.internal.runtime.FindProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphByMatrix {
    private ArrayList<String> vertexList;
    private int[][] edges;
    private int numOfEdges;
    private boolean[] visited;

    public static void main(String[] args) {
        GraphByMatrix graph = new GraphByMatrix(5);
        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");

        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 4, 1);

        graph.showGraph();

        graph.dfs();
        System.out.println();
        graph.bfs();
    }

    public void bfs(int i) {
        LinkedList<Integer> queue = new LinkedList<>();
        int u, w;//u用来接受出队列的节点，w用来接收u的相邻节点
        queue.add(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            if (!visited[u]) {
                System.out.print(getValueByIndex(u) + "=>");
                visited[u] = true;
            }
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!visited[w]) {
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void bfs() {
        visited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); ++i) {
            if (!visited[i]) {
                bfs(i);
            }
        }
    }

    public void dfs(int i) {
        System.out.print(getValueByIndex(i) + "->");
        visited[i] = true;
        int j = getFirstNeighbor(i);
        while (j != -1) {
            if (!visited[j]) {
                dfs(j);
            }
            j = getNextNeighbor(i, j);
        }
    }

    public void dfs() {
        visited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); ++i) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public int getFirstNeighbor(int v) {
        for (int i = 0; i < vertexList.size(); ++i) {
            if (getWeight(v, i) > 0)
                return i;
        }
        return -1;
    }

    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); ++i) {
            if (getWeight(v1, i) > 0)
                return i;
        }
        return -1;
    }

    public GraphByMatrix(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        visited = new boolean[n];
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public void showGraph() {
        for (int[] arr : edges) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        ++numOfEdges;
    }
}

package com.pearz.algorithm.kruskal;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        char[] vertexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int[][] weight = new int[][]{
                {INF, 5, 7, INF, INF, INF, 2},
                {5, INF, INF, 9, INF, INF, 3},
                {7, INF, INF, INF, 8, INF, INF},
                {INF, 9, INF, INF, INF, 4, INF},
                {INF, INF, 8, INF, INF, 5, 4},
                {INF, INF, INF, 4, 5, INF, 6},
                {2, 3, INF, INF, 4, 6, INF},};
        Graph graph = new Graph(vertexs, weight);
        graph.numOfVertex = vertexs.length;

//        List<Edge> edges = getEdge(graph);
//        for (Edge edge : edges) {
//            System.out.println(edge);
//        }

        kruskal(graph);

    }

    public static void kruskal(Graph graph) {
        List<Edge> edges = getEdge(graph);
        List<Edge> edgesMin = new ArrayList<Edge>();

        //并查集
        int[] endVertex = new int[graph.numOfVertex];

        for (Edge edge : edges) {
            char start = edge.start;
            char end = edge.end;
            int weight = edge.weight;

            int v1 = getLocation(graph, start);
            int v2 = getLocation(graph, end);


            int v1e = getEnd(endVertex, v1);
            int v2e = getEnd(endVertex, v2);
            if (v1e != v2e) {
                edgesMin.add(edge);
                endVertex[v1e] = v2e;
            }
        }

        for (Edge edge : edgesMin) {
            System.out.println(edge);
        }
    }

    public static int getEnd(int[] end, int i) {
        while (end[i] != 0) {
            i = end[i];
        }
        return i;
    }

    public static int getLocation(Graph graph, char ch) {
        for (int i = 0; i < graph.numOfVertex; ++i) {
            if (graph.vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static List<Edge> getEdge(Graph graph) {
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < graph.numOfVertex; ++i) {
            for (int j = i + 1; j < graph.numOfVertex; ++j) {
                if (graph.edges[i][j] != INF) {
                    char v1 = graph.vertexs[i];
                    char v2 = graph.vertexs[j];
                    int weight = graph.edges[i][j];
                    Edge edge = new Edge(v1, v2, weight);
                    edges.add(edge);
                }
            }
        }
        Collections.sort(edges);
        return edges;
    }
}

class Edge implements Comparable<Edge> {
    char start;
    char end;
    int weight;

    public Edge() {
    }

    public Edge(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "<" + start + "," + end + "> weight=" + weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

class Graph {
    int numOfVertex;
    int numOfEdges;
    char[] vertexs;
    int[][] edges;

    public Graph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        vertexs = new char[numOfVertex];
        edges = new int[numOfVertex][numOfVertex];
    }

    public Graph(char[] vertexs, int[][] edges) {
        this.vertexs = vertexs;
        this.edges = edges;
    }

    public Graph(int numOfVertex, char[] vertexs, int[][] edges) {
        this.numOfVertex = numOfVertex;
        this.vertexs = vertexs;
        this.edges = edges;
    }
}
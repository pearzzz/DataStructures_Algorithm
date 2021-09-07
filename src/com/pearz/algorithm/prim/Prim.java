package com.pearz.algorithm.prim;

public class Prim {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};
        Graph graph = new Graph(data, weight);
        graph.numOfVertex = data.length;

        prim(graph, 0);
    }

    public static void prim(Graph graph, int v) {
        boolean vistied[] = new boolean[graph.numOfVertex];
        vistied[v] = true;

        int minEdge;
        int v1 = -1, v2 = -1;
        for (int m = 1; m < graph.numOfVertex; ++m) {
            minEdge = 10000;
            for (int i = 0; i < graph.numOfVertex; ++i) {
                for (int j = 0; j < graph.numOfVertex; ++j) {
                    if (vistied[i] && !vistied[j] && graph.edges[i][j] < minEdge) {
                        minEdge = graph.edges[i][j];
                        v1 = i;
                        v2 = j;
                    }
                }
            }
            vistied[v2] = true;
            System.out.println("<" + graph.data[v1] + "," + graph.data[v2] + "> " + "权值=" + graph.edges[v1][v2]);
        }
    }
}

class Graph {
    int numOfVertex;
    char[] data;
    int[][] edges;

    public Graph(int numOfVertex) {
        this.numOfVertex = numOfVertex;
        data = new char[numOfVertex];
        edges = new int[numOfVertex][numOfVertex];
    }

    public Graph(char[] data, int[][] edges) {
        this.data = data;
        this.edges = edges;
    }

    public Graph(int numOfVertex, char[] data, int[][] edges) {
        this.numOfVertex = numOfVertex;
        this.data = data;
        this.edges = edges;
    }
}

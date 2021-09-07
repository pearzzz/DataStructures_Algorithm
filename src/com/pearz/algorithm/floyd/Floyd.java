package com.pearz.algorithm.floyd;

import java.util.Arrays;

public class Floyd {
    public static final int INF = 999;

    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        matrix[0]=new int[]{0,5,7,INF,INF,INF,2};
        matrix[1]=new int[]{5,0,INF,9,INF,INF,3};
        matrix[2]=new int[]{7,INF,0,INF,8,INF,INF};
        matrix[3]=new int[]{INF,9,INF,0,INF,4,INF};
        matrix[4]=new int[]{INF,INF,8,INF,0,5,4};
        matrix[5]=new int[]{INF,INF,INF,4,5,0,6};
        matrix[6]=new int[]{2,3,INF,INF,4,6,0};

        Graph graph = new Graph(vertex, matrix);

        floyd(graph);
    }

    private static int[][] pre;

    public static void floyd(Graph graph) {
        int vertex = graph.vertexs.length;

        int[][] distance = new int[vertex][vertex];
        pre = new int[vertex][vertex];

        distance = graph.edges;
        for (int i = 0; i < vertex; ++i) {
            Arrays.fill(pre[i], i);
        }

        for (int k = 0; k < vertex; ++k) {
            for (int i = 0; i <vertex; ++i) {
                for (int j = 0; j < vertex; ++j) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }

        for (int i = 0; i <vertex; ++i) {
            for (int j = 0; j < vertex; ++j) {
                System.out.print(graph.vertexs[i] + "到" + graph.vertexs[j] + "的最短距离为：" + distance[i][j] + "    ");
            }
            System.out.println();
        }

        for (int i = 0; i <vertex; ++i) {
            for (int j = 0; j < vertex; ++j) {
                System.out.print(graph.vertexs[i] + "到" + graph.vertexs[j] + ":");
                int temp = j;
                while (pre[i][temp] != i) {
                    System.out.print(graph.vertexs[temp] + "=>");
                    temp = pre[i][temp];
                }
                System.out.print(graph.vertexs[temp] + "=>");
                System.out.println(graph.vertexs[i]);
            }

        }
    }
}

class Graph {
    int numOfVertex;
    int numOfEdge;
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
package com.pearz.algorithm.dijkstra;

public class Dijkstra {
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

        dijkstra(graph, 'E');
    }

    private static boolean[] visited;
    private static int[] pre;
    private static int[] distance;

    public static void dijkstra(Graph graph, char ch) {
        for (int i = 0; i < graph.vertexs.length; ++i) {
            if (graph.vertexs[i] == ch) {
                dijkstra(graph, i);
            }
        }
    }

    public static void dijkstra(Graph graph, int n) {
        int vertex = graph.vertexs.length;
        
        visited = new boolean[vertex];
        pre = new int[vertex];
        distance = new int[vertex];

        for (int i = 0; i < vertex; ++i) {
            visited[i] = false;
            pre[i] = -1;
            distance[i] = graph.edges[n][i];
        }

        visited[n] = true;
        int preVisited = n;

        for (int i = 1; i < vertex; ++i) {
            int min = INF;
            int temp = -1;
            for (int k = 0; k < vertex; ++k) {
                if (!visited[k] && distance[k] < min) {
                    min = distance[k];
                    temp = k;
                }
            }

            if (temp != -1) {
                visited[temp] = true;
                pre[temp] = preVisited;
                preVisited = temp;
            }

            for (int m = 0; m < vertex; ++m) {
                if (!visited[m] && (distance[temp] + graph.edges[temp][m] < distance[m])) {
                    distance[m] = distance[temp] + graph.edges[temp][m];
                }
            }
        }

        for (int i = 0; i < vertex; ++i) {
            System.out.println(graph.vertexs[n] + "点到" + graph.vertexs[i] + "点的最短距离为：" + distance[i]);
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
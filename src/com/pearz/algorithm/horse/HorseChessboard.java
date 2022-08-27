package com.pearz.algorithm.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessboard {

    public static int X;
    public static int Y;
    public static boolean[][] visited;
    public static boolean finished;

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        visited = new boolean[Y][X];

        int[][] chessboard = new int[Y][X];

        int row = 1;
        int column = 1;

        traverse(chessboard, row - 1, column - 1, 1);

        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }

    public static void traverse(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row][column] = true;
        ArrayList<Point> points = next(new Point(column, row));
        sort(points);

        while (!points.isEmpty()) {
            Point point = points.remove(0);
            if (!visited[point.y][point.x]) {
                traverse(chessboard, point.y, point.x, step + 1);
            }
        }

        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row][column] = finished;
        } else {
            finished = true;
        }
    }

    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();
        Point p = new Point();
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p));
        }
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p));
        }

        return points;
    }

    public static void sort(ArrayList<Point> points) {
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return (next(o1).size() - next(o2).size());
            }
        });
    }
}

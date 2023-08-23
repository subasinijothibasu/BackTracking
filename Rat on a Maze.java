/*Rat on Maze - Backtracking
Write a program to find in which path the rat will get out of the maze using backtracking.
Sample Input:

5

1 0 0 0 0

1 1 0 0 0

0 1 1 0 0

1 1 1 0 0

1 0 1 1 1



Sample Output:

Enter n value:

Path to get out of maze

1 0 0 0 0

1 1 0 0 0

0 1 0 0 0

0 1 1 0 0

0 0 1 1 1
*/

import java.util.Scanner;

public class Main{

    private static int N;
    private static int[][] maze;
    private static int[][] path;

    private static boolean isSafe(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
    }

    private static boolean solveMaze(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            path[x][y] = 1;
            return true;
        }

        if (isSafe(x, y)) {
            path[x][y] = 1;

            if (solveMaze(x + 1, y) || solveMaze(x, y + 1)) {
                return true;
            }

            path[x][y] = 0; // Backtrack
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n value:  ");
        N = scanner.nextInt();

        maze = new int[N][N];
        path = new int[N][N];

        System.out.println("  ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maze[i][j] = scanner.nextInt();
                path[i][j] = 0;
            }
        }

        if (solveMaze(0, 0)) {
            System.out.println("Path to get out of maze");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(" "+path[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No path found!");
        }
    }
}

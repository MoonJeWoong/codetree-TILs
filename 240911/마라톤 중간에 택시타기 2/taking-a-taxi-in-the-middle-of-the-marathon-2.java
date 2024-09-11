import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][];
        int[][] dist = new int[n][2];
        for (int iter = 0; iter < n; iter++) {
            grid[iter] = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        }
        
        for (int iter = 1; iter < n - 1; iter++) {
            dist[iter][0] = dist[iter - 1][0] + calculateDistance(grid[iter - 1], grid[iter]);
            dist[n - 1 - iter][1] = dist[n - iter][1] + calculateDistance(grid[n - 1 - iter], grid[n - iter]);
        }

        int answer = Integer.MAX_VALUE;
        for (int iter = 1; iter < n - 1; iter++) {
            int tmp = dist[iter - 1][0] + dist[iter + 1][1];
            tmp += calculateDistance(grid[iter - 1], grid[iter + 1]);
            answer = Math.min(answer, tmp);
        }

        System.out.println(answer);
    }

    private static int calculateDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
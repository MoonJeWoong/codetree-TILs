import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] grid = new int[n][];
        for (int iter = 0; iter < n; iter++) {
            grid[iter] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        
        int answer = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n - 2; col++) {
                answer = Math.max(answer, grid[row][col] + grid[row][col + 1] + grid[row][col + 2]);
            }
        }
        System.out.println(answer);
    }
}
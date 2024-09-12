import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];

        for (int iter=0; iter<n; iter++) {
            grid[iter] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }
        
        int answer = 0;
        for (int row1=0; row1<n; row1++) {
            for (int col1=0; col1<n-2; col1++) {
                for (int row2=0; row2<n; row2++) {
                    for (int col2=0; col2<n-2; col2++) {
                        if (!isOverlapped(row1, col1, row2, col2)) {
                            answer = Math.max(answer, calculateSum(row1, col1, row2, col2));
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }

    private static boolean isOverlapped(int row1, int col1, int row2, int col2) {
        if (row1 == row2 && Math.abs(col1-col2) < 3) {
            return true;
        }
        return false;
    }

    private static int calculateSum(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int idx=0; idx<3; idx++) {
            sum += grid[row1][col1 + idx];
            sum += grid[row2][col2 + idx];
        }
        return sum;
    }
}
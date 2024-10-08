import java.util.*;
import java.io.*;

public class Main {
    private static int[][] matrix;
    private static int[][] dp;
    private static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        dp = new int[n][n];

        for (int iter=0; iter<n; iter++) {
            matrix[iter] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
        
        // 역순으로 1행, 정순으로 n-1열 dp 초기화
        // 2행 n-2열 칸부터 순서대로 채워나가기

        dp[0][n-1] = matrix[0][n-1];
        for (int idx=1; idx<n; idx++) {
            dp[0][n-1-idx] = dp[0][n-idx] + matrix[0][n-1-idx];
            dp[idx][n-1] = dp[idx-1][n-1] + matrix[idx][n-1];
        }

        for (int row=1; row<n; row++) {
            for (int col=n-2; col>=0; col--) {
                int upper = dp[row-1][col] + matrix[row][col];
                int left = dp[row][col+1] + matrix[row][col];
                dp[row][col] = Math.min(upper, left);
            }
        }

        System.out.println(dp[n-1][0]);
    }
}
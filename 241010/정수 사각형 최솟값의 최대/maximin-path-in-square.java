import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] matrix;
    private static int[][] dp;

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
        
        // 1행 1열 dp 테이블 채우기
            // 이전 칸까지 기록된 최솟값보다 더 작은 경우 테이블에 기록
        // 2행 2열부터 계산하기
            // 윗 칸과 왼쪽 칸 각각 현재 matrix 칸 값이 더 작은 경우에는 matrix 값을 기록
            // 윗 칸과 왼쪽 칸 각각 현재 matrix 칸 값이 더 큰 경우에는 두 dp 테이블 값 중 더 큰 값을 기록한다.
        // n, n 칸의 dp 테이블 값을 반환한다.

        dp[0][0] = matrix[0][0];
        for (int idx=1; idx<n; idx++) {
            dp[0][idx] = Math.min(dp[0][idx-1], matrix[0][idx]);
            dp[idx][0] = Math.min(dp[idx-1][0], matrix[idx][0]);
        }

        for (int row=1; row<n; row++) {
            for (int col=1; col<n; col++) {
                int minMax = Math.max(dp[row-1][col], dp[row][col-1]);
                dp[row][col] = Math.min(minMax, matrix[row][col]);
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
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
        
        // dp 테이블 1행 1열 값들을 모두 초기화
        // 이후 2행 2열부터 n행 n열까지 계산 진행
        // n행 n열에 계산된 최대 값을 출력

        dp[0][0] = matrix[0][0];
        for (int idx=1; idx<n; idx++) {
            // 행계산
            dp[0][idx] = dp[0][idx-1] + matrix[0][idx];

            // 열계산
            dp[idx][0] = dp[idx-1][0] + matrix[idx][0];
        }

        for (int row=1; row<n; row++) {
            for (int col=1; col<n; col++) {
                int upper = dp[row-1][col] + matrix[row][col];
                int right = dp[row][col-1] + matrix[row][col];
                dp[row][col] = Math.max(upper, right);
            }
        }

        System.out.println(dp[n-1][n-1]);

    }
}
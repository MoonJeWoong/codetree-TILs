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
        
        
        // dp 테이블을 2차원 배열로 선언하고 1행 1열을 각각 초기화
        // 이후 왼쪽, 위쪽에서 넘어오는 값을 비교해서 더 작은 값을 선택
        // 그리고 그렇게 선택한 값과 현재 위치한 칸의 값과 비교해서 더 큰 값을 기록
        // 계산이 끝나고 dp 테이블의 n-1, n-1 값 반환
        
        dp[0][0] = matrix[0][0];
        for (int idx=1; idx<n; idx++) {
            dp[idx][0] = Math.max(dp[idx-1][0], matrix[idx][0]);
            dp[0][idx] = Math.max(dp[0][idx-1], matrix[0][idx]);
        }

        for (int row=1; row<n; row++) {
            for (int col=1; col<n; col++) {
                dp[row][col] = Math.max(Math.min(dp[row-1][col], dp[row][col-1]), matrix[row][col]);
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
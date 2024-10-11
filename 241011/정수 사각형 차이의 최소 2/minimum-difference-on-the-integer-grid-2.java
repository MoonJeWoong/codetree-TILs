import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] matrix;
    private static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];
        int[][][] dp = new int[n][n][2];

        if (n==1) {
            System.out.println(0);
            return;
        }

        for (int iter=0; iter<n; iter++) {
            matrix[iter] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        // DP[row][col] => 해당 칸까지 이를 때 고를 수 있는 최적의 최소 최대 값 조합
        // 1행 1열 초기화 해두고 2행 2열부터 dp테이블 채우기
        // 윗칸, 왼쪽칸까지의 최소 최대 값 조합에서 현재 칸 값을 포함했을 때 나오는 차이 값을 비교후 더 작은 쪽의 최소 최대 값 조합을 저장한다.
        // 계산 종료 후 n,n 칸의 값을 출력한다.

        dp[0][1] = new int[] {Math.min(matrix[0][0], matrix[0][1]), Math.max(matrix[0][0], matrix[0][1])};
        dp[1][0] = new int[] {Math.min(matrix[0][0], matrix[1][0]), Math.max(matrix[0][0], matrix[1][0])};

        for (int idx=2; idx<n; idx++) {
            dp[0][idx] = new int[] {Math.min(dp[0][idx-1][0], matrix[0][idx]), Math.max(dp[0][idx-1][1], matrix[0][idx])};
            dp[idx][0] = new int[] {Math.min(dp[idx-1][0][0], matrix[idx][0]), Math.max(dp[idx-1][0][1], matrix[idx][0])};
        }

        for (int row=1; row<n; row++) {
            for (int col=1; col<n; col++) {
                int[] upper = dp[row-1][col];
                int[] left = dp[row][col-1];

                int upperDifference = calculateDifferenceWithNewValue(upper, matrix[row][col]);
                int leftDifference = calculateDifferenceWithNewValue(left, matrix[row][col]);

                if (upperDifference <= leftDifference) {
                    dp[row][col][0] = Math.min(upper[0], matrix[row][col]);
                    dp[row][col][1] = Math.max(upper[1], matrix[row][col]);
                } else {
                    dp[row][col][0] = Math.min(left[0], matrix[row][col]);
                    dp[row][col][1] = Math.max(left[1], matrix[row][col]);
                }
            }
        }

        System.out.println(dp[n-1][n-1][1] - dp[n-1][n-1][0]);
    }

    private static int calculateDifferenceWithNewValue(int[] minMax, int newValue) {
        return Math.abs(Math.max(minMax[1], newValue) - Math.min(minMax[0], newValue));
    }
}
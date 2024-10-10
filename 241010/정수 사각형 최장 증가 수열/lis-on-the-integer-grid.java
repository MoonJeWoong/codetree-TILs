import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] matrix;
    private static int[][] memoTable;
    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        memoTable = new int[n][n];

        for (int iter=0; iter<n; iter++) {
            matrix[iter] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            Arrays.fill(memoTable[iter], -1);
        }

        
        // 백트래킹 함수로 주어진 좌표 위치에서 가장 칸을 많이 밟을 수 있는 수를 구한다.
            // 예전에 한 번 계산했던 적 있는 칸이라면 memoTable의 값을 바로 사용한다.
            // 재귀를 반복하며 더 이상 진행할 수 없게 되면, 해당 위치까지 밟아온 칸 개수를 반환한다.
            // 네 방향 모두 계산해서 그 중 최댓값을 memoTable에 저장한다.
        // memoTable에서 최대 값을 탐색해서 출력한다.
        int answer = 1;
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                memoTable[row][col] = findMaxStep(row, col);
                answer = Math.max(answer, memoTable[row][col]);
            }
        }

        System.out.println(answer);
    }

    private static int findMaxStep(int row, int col) {
        if (memoTable[row][col] != -1) {
            return memoTable[row][col];
        }

        int maxStep = 1;
        for (int iter=0; iter<4; iter++) {
            int nextRow = row + dx[iter];
            int nextCol = col + dy[iter];

            if (isValidPosition(nextRow, nextCol) && matrix[row][col] < matrix[nextRow][nextCol]) {
                memoTable[nextRow][nextCol] = findMaxStep(nextRow, nextCol);
                maxStep = Math.max(memoTable[nextRow][nextCol] + 1, maxStep);
            }
        }

        return maxStep;
    }

    private static boolean isValidPosition(int row, int col) {
        return row>=0 && row<n && col>=0 && col<n;
    }
}
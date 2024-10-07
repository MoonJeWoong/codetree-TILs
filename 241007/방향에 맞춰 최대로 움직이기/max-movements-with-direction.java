import java.util.*;
import java.io.*;

public class Main {
    private static int[][] matrix;
    private static int[][] dirMatrix;
    private static int[][] directions = {
        {},
        {-1, 0},
        {-1, 1},
        {0, 1},
        {1, 1},
        {1, 0},
        {1, -1},
        {0, -1},
        {-1, -1}
    };
    private static int n;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;

        matrix = new int[n][n];
        dirMatrix = new int[n][n];

        for (int iter=0; iter<n; iter++) {
            matrix[iter] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
        for (int iter=0; iter<n; iter++) {
            dirMatrix[iter] = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
        
        int[] startPos = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        // 시작 좌표 지점에서 백트래킹 시작
        // 입력된 좌표에서 해당하는 방향으로 끝에 다다르기 전까지 순회하면서
            // 현재 위치보다 숫자 값이 더 큰 위치를 만난다면 현재 count 값 + 1 해준 뒤, 거기에서 재귀 수행
            // 재귀 수행 이후 현재 count 값 -1 해준 뒤, 반복문 다시 순회
            // 재귀 종료 조건은 입력된 좌표 값이 행렬 밖의 값이라면 현재까지 세어진 count 값과 정답 값 중 큰 값으로 정답을 갱신하고 종료
        
        check(startPos[0]-1, startPos[1]-1, 0);

        System.out.println(answer);
    }

    private static void check(int row, int col, int currentCount) {
        // System.out.println(row + " " + col);

        if (!isValidPosition(row, col)) {
            answer = Math.max(answer, currentCount);
            return;
        }

        int[] currentDir = directions[dirMatrix[row][col]];
        int currentNum = matrix[row][col];
        
        while (isValidPosition(row, col)) {
            if (matrix[row][col] > currentNum) {
                check(row, col, currentCount + 1);
            }
            row += currentDir[0];
            col += currentDir[1];
            // System.out.println("nextRow: " + row + " nextCol: " + col);
        }
        check(row, col, currentCount);
    }

    private static boolean isValidPosition(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static final int n = 19;
    private static int[][] grid;
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    private static int answerDir;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        grid = new int[n][n];

        for (int iter=0; iter<n; iter++) {
            grid[iter] = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        }
        
        int answer = 0;
        int[] answerCoordinate = {-1, -1};
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                if (isWinner(row, col)) {
                    answer = grid[row][col];
                    answerCoordinate = getCenterCoordinate(row, col);
                    break;
                }
            }
            if (answer != 0) {
                break;
            }
        }
        
        System.out.println(answer);
        if (answer != 0) {
            System.out.println((answerCoordinate[0] + 1) + " " + (answerCoordinate[1] + 1));
        }
        
    }

    private static boolean isWinner(int row, int col) {
        int target = grid[row][col];
        if (target == 0) {
            return false;
        }
        for (int dir=0; dir<8; dir++) {
            int cnt = 0;
            int nextRow = row;
            int nextCol = col;
            while (true) {
                if (isValidCoordinate(nextRow, nextCol) && grid[nextRow][nextCol] == target) {
                    cnt++;
                    nextRow += dx[dir];
                    nextCol += dy[dir];

                    if (cnt == 5) {
                        answerDir = dir;
                        return true;
                    }
                    continue;
                }
                break;
            }
        }
        return false;
    }

    private static boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < n && col >= 0 && row < n;
    }

    private static int[] getCenterCoordinate(int row, int col) {
        return new int[] {row + dx[answerDir] * 2, col + dy[answerDir] * 2};
    }
}
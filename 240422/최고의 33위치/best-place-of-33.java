import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] maps = new int[n][n];
        for (int iter = 0; iter < n; iter++) {
            maps[iter] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // for 문 순회하면서 전체 탐색
        // 첫 for문으로 왼쪽 상단 가장자리 좌표를 선택
        // 이후 이중 for문으로 3 by 3 좌표들을 탐색하며 카운트
        // 최대 동전의 수 갱신

        int answer = Integer.MIN_VALUE;
        int tmpSum;
        for (int row = 0; row <= maps.length - 3; row++) {
            for (int col = 0; col <= maps.length - 3; col++) {
                tmpSum = 0;
                for (int windowRow = row; windowRow < row + 3; windowRow++) {
                    for (int windowCol = col; windowCol < col + 3; windowCol++) {
                        if (maps[windowRow][windowCol] == 1) {
                            tmpSum++;
                        }
                    }
                }
                answer = Math.max(answer, tmpSum);
            }
        }
        System.out.println(answer);
    }
}
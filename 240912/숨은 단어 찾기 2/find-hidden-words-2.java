import java.util.*;
import java.io.*;

public class Main {

    private static int[][][] dirs = {
        {{1, 0}, {2, 0}},
        {{1, 1}, {2, 2}},
        {{0, 1}, {0, 2}},
        {{-1, 1}, {-2, 2}},
        {{-1, 0}, {-2, 0}},
        {{-1, -1}, {-2, -2}},
        {{0, -1}, {0, -2}},
        {{1, -1}, {2, -2}}
    };
    private static int answer;
    private static String[][] inputs;
    private static int[] sizes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sizes = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        answer = 0;
        inputs = new String[sizes[0]][sizes[1]];

        for (int iter=0; iter<sizes[0]; iter++) {
            inputs[iter] = br.readLine().split("");
        }
        
        for (int row=0; row<sizes[0]; row++) {
            for (int col=0; col<sizes[1]; col++) {
                if (inputs[row][col].equals("L")) {
                    countLee(row, col);
                }
            }
        }

        System.out.println(answer);
        
    }

    private static void countLee(int row, int col) {
        for (int[][] points : dirs) {
            int[] point1 = {row + points[0][0], col + points[0][1]};
            int[] point2 = {row + points[1][0], col + points[1][1]};
            if (equalStr(point1, "E") && equalStr(point2, "E")) {
                answer++;
            }
        }
    }

    private static boolean equalStr(int[] point, String target) {
        if (point[0] >= 0 && point[0] < sizes[0] && point[1] >= 0 && point[1] < sizes[1]) {
            return inputs[point[0]][point[1]].equals(target);
        }
        return false;
    }
}
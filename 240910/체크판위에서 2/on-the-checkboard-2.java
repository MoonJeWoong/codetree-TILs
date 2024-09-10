import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] sizes = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int n = sizes[0];
        int m = sizes[1];

        String[][] grid = new String[n][];

        for (int iter = 0; iter < n; iter++) {
            grid[iter] = br.readLine().split(" ");
        }

        String firstStep = getNextStep(grid[0][0]);
        String secondStep = getNextStep(firstStep);
        int answer = 0;

        for (int row1 = 1; row1 < n - 2; row1++) {
            for (int col1 = 1; col1 < m - 2; col1++) {
                if (firstStep.equals(grid[row1][col1])) {
                    for (int row2 = row1 + 1; row2 < n - 1; row2++) {
                        for (int col2 = col1 + 1; col2 < m - 1; col2++) {
                            if (secondStep.equals(grid[row2][col2])) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(answer);
    }

    private static String getNextStep(String current) {
        if (current.equals("W")) {
            return "B";
        } else {
            return "W";
        }
    }
}
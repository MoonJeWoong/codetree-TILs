import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] plane = new int[2001][2001];
        
        for (int i=0; i<2; i++) {
            int[] square = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            checkSquare(plane, square, 1);
        }

        int[] square = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        checkSquare(plane, square, 0);

        int sum = 0;
        for (int i=0; i<plane.length; i++) {
            for (int j=0; j<plane[0].length; j++) {
                sum += plane[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void checkSquare(int[][] plane, int[] square, int unit) {
        int offset = 1000;

        int x1 = square[0] + offset;
        int y1 = square[1] + offset;
        int x2 = square[2] + offset;
        int y2 = square[3] + offset;

        for (int row = x1; row < x2; row++) {
            for (int col = y1; col < y2; col++) {
                plane[row][col] = unit;
            }
        }
    }
}
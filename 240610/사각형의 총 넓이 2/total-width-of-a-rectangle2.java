import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        
        int[][] plane = new int[201][201];

        for (int i=0; i<n; i++) {
            int[] inputSquare = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            checkSquare(plane, inputSquare);
        }

        int sum = 0;
        for (int i = 0; i<plane.length; i++) {
            for (int j = 0; j<plane[0].length; j++) {
                sum += plane[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void checkSquare(int[][] plane, int[] inputSquare) {
        int offset = 100;

        int x1 = inputSquare[0] + offset;
        int y1 = inputSquare[1] + offset;
        int x2 = inputSquare[2] + offset;
        int y2 = inputSquare[3] + offset;

        for (int row = x1; row < x2; row++) {
            for (int col = y1; col < y2; col++) {
                plane[row][col] = 1;
            }
        }
    }
}
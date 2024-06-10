import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] plane = new int[201][201];

        for (int i=0; i<n; i++) {
            int[] inputPoint = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            checkSquare(plane, inputPoint);
        }

        int sum = 0;
        for (int row=0; row<plane.length; row++) {
            for (int col=0; col<plane[0].length; col++) {
                sum += plane[row][col];
            }
        }

        System.out.println(sum);
    }

    public static void checkSquare(int[][] plane, int[] inputPoint) {
        int offset = 100;
        
        int x1 = inputPoint[0] + offset;
        int y1 = inputPoint[1] + offset;
        int x2 = x1 + 8;
        int y2 = y1 + 8;

        for (int row=x1; row<x2; row++) {
            for (int col=y1; col<y2; col++) {
                plane[row][col] = 1;
            }
        }
    }
}
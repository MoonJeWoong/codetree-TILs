import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputLine = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] moveA = new int[inputLine[0]];
        int[] moveB = new int[inputLine[1]];

        readMoving(br, moveA);
        readMoving(br, moveB);

        int sum = Arrays.stream(moveA)
                .map(num -> Math.abs(num))
                .sum();
        
        int[] traceA = new int[sum + 1];
        int[] traceB = new int[sum + 1];

        recordMoving(traceA, moveA);
        recordMoving(traceB, moveB);

        for (int i = 1; i < traceA.length; i++) {
            if (traceA[i] == traceB[i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void readMoving(BufferedReader br, int[] move) throws Exception {
        for (int i=0; i<move.length; i++) {
            String[] inputLine = br.readLine().split(" ");
            if (inputLine[0].equals("R")) {
                move[i] = Integer.parseInt(inputLine[1]);
            } else {
                move[i] = -1 * Integer.parseInt(inputLine[1]);
            }
        }
    }

    public static void recordMoving(int[] trace, int[] move) {
        int cur = 1;
        for (int num : move) {
            if (num > 0) {
                for (int i = 0; i < num; i++) {
                    trace[cur] = trace[cur - 1] + 1;
                    cur++;
                }
            } else {
                for (int i = 0; i < num * -1; i++) {
                    trace[cur] = trace[cur - 1] - 1;
                    cur++;
                }
            }
        }
    }
}
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final int MAX_TIME = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstInputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int[] traceA = new int[MAX_TIME + 1];
        int[] traceB = new int[MAX_TIME + 1];

        int timeA = 1;
        for (int i=0; i<firstInputs[0]; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            for (int t=0; t<inputs[1]; t++) {
                traceA[timeA] = traceA[timeA - 1] + inputs[0];
                timeA++;
            }
        }

        int timeB = 1;
        for (int i=0; i<firstInputs[1]; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            
            for (int t=0; t<inputs[1]; t++) {
                traceB[timeB] = traceB[timeB - 1] + inputs[0];
                timeB++;
            }
        }

        String firstRunner = "";
        int answer = 0;
        for (int i=1; i<timeA; i++) {
            if (firstRunner.equals("")) {
                if (traceA[i] > traceB[i]) {
                    firstRunner = "A";
                } else if (traceA[i] < traceB[i]) {
                    firstRunner = "B";
                } else {
                    continue;
                }
            }

            if (traceA[i] > traceB[i] && firstRunner.equals("B")) {
                firstRunner = "A";
                answer++;
            } else if (traceA[i] < traceB[i] && firstRunner.equals("A")) {
                firstRunner = "B";
                answer++;
            }
        }

        System.out.println(answer);
    }
}
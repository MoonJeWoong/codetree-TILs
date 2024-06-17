import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0], t = inputs[1];
        int answer = 0, count = 0;

        for (int i=0; i<n; i++) {
            int inputNum = seq[i];
            if (t < inputNum) {
                count++;
            } else {
                count = 0;
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
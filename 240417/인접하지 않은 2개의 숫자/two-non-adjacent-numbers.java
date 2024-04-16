import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int answer = 0;
        for (int idx1 = 0; idx1 < inputs.length - 2; idx1++) {
            for (int idx2 = idx1 + 2; idx2 < inputs.length; idx2++) {
                answer = Math.max(answer, inputs[idx1] + inputs[idx2]);
            }
        }
        System.out.println(answer);
    }
}
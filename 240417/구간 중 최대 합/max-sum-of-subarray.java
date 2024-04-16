import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputLine = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputLine[0], k = inputLine[1];
        int[] sequence = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int answer, sum = 0;
        for (int idx1 = 0; idx1 < k; idx1++) {
            sum += sequence[idx1];
        }
        answer = sum;

        for (int rt = k; rt < n; rt++) {
            sum = sum - sequence[rt - k] + sequence[rt];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inputNums = new int[n];
        for (int iter = 0; iter < n; iter++) {
            inputNums[iter] = Integer.parseInt(br.readLine());
        }
        
        int answer = Integer.MAX_VALUE;
        for (int idx1 = 0; idx1 < n; idx1++) {
            int dist = 1;
            int idx2 = (idx1 + dist) % n;
            int tmp = 0;
            while (idx2 != idx1) {
                tmp += dist * inputNums[idx2];
                dist++;
                idx2 = (idx1 + dist) % n;
            }
            answer = Math.min(answer, tmp);
        }

        System.out.println(answer);
    }
}
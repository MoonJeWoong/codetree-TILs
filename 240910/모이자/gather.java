import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inputNums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int answer = Integer.MAX_VALUE;
        for (int idx = 0; idx < inputNums.length; idx++) {
            int tmp = 0;
            for (int iter = 0; iter < inputNums.length; iter++) {
                if (iter == idx) continue;
                tmp += Math.abs(idx - iter) * inputNums[iter];
            }
            answer = Math.min(answer, tmp);
        }

        System.out.println(answer);
    }
}
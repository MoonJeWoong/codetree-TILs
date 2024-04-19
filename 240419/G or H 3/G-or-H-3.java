import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0], k = inputs[1];
        int[] locations = new int[10_001];

        for (int iter = 0; iter < n; iter++) {
            String[] inputLine = br.readLine().split(" ");
            int idx = Integer.parseInt(inputLine[0]);
            if (inputLine[1].equals("G")) {
                locations[idx] = 1;
            } else {
                locations[idx] = 2;
            }
        }

        int lt = 1,  rt = lt + k + 1;
        int answer = 0;
        for (int idx = lt; idx < rt; idx++) {
            answer += locations[idx];
        }

        int tmpSum = answer;
        for (int idx = rt; idx < locations.length - k; idx++) {
            tmpSum = tmpSum - locations[lt] + locations[rt];
            answer = Math.max(tmpSum, answer);
        }
        System.out.println(answer);
    }
}
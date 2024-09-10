import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] inputNums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int answer = 0;
        for (int idx1 = 0; idx1 < inputNums.length - 2; idx1++) {
            for (int idx2 = idx1 + 1; idx2 < inputNums.length - 1; idx2++) {
                if (inputNums[idx1] <= inputNums[idx2]) {
                    for (int idx3 = idx2 + 1; idx3 < inputNums.length; idx3++) {
                        if (inputNums[idx2] <= inputNums[idx3]) {
                            answer++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
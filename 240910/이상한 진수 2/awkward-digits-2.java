import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputNums = Arrays.stream(br.readLine().split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int answer = 0;
        for (int idx = 0; idx < inputNums.length; idx++) {
            inputNums[idx] = Math.abs(inputNums[idx] - 1);
            answer = Math.max(answer, convertToDecimal(inputNums));
            inputNums[idx] = Math.abs(inputNums[idx] - 1);
        }
        System.out.println(answer);
    }

    private static int convertToDecimal(int[] inputNums) {
        int multiplier = 1;
        int sum = 0;
        for (int idx = inputNums.length - 1; idx >= 0; idx--) {
            sum += inputNums[idx] * multiplier;
            multiplier *= 2;
        }
        return sum;
    }
}
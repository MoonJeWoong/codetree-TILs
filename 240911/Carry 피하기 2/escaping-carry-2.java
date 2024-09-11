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

        int answer = -1;
        for (int idx1 = 0; idx1 < n-2; idx1++) {
            for (int idx2 = idx1+1; idx2 < n-1; idx2++) {
                for (int idx3 = idx2+1; idx3 < n; idx3++) {
                    if (notCarry(inputNums[idx1], inputNums[idx2], inputNums[idx3])) {
                        answer = Math.max(answer, inputNums[idx1] + inputNums[idx2] + inputNums[idx3]);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean notCarry(int num1, int num2, int num3) {
        for (int iter = 0; iter < 5; iter++) {
            int counter = num1 % 10;
            counter += num2 % 10;
            counter += num3 % 10;
            if (counter >= 10) {
                return false;
            }
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }
        return true;
    }
}
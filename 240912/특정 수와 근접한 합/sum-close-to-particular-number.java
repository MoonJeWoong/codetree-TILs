import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] firstLine = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int n = firstLine[0];
        int target = firstLine[1];
        
        int[] inputNums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        int originSum = Arrays.stream(inputNums)
                            .sum();

        int answer = Integer.MAX_VALUE;
        for (int idx1=0; idx1<n-1; idx1++) {
            for (int idx2=idx1+1; idx2<n; idx2++) {
                answer = Math.min(answer, Math.abs(target - (originSum - inputNums[idx1] - inputNums[idx2])));
            }
        }
        System.out.println(answer);
    }
}
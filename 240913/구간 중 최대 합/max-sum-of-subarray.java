import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" "))
                            . mapToInt(Integer::parseInt)
                            .toArray();
        
        int[] inputNums = Arrays.stream(br.readLine().split(" "))
            . mapToInt(Integer::parseInt)
            .toArray();

        int answer = 0;
        for (int idx=0; idx<firstLine[1]; idx++) {
            answer += inputNums[idx];
        }
        int tmp = answer;
        for (int idx=firstLine[1]; idx<inputNums.length; idx++) {
            tmp += inputNums[idx] - inputNums[idx - firstLine[1]];
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}
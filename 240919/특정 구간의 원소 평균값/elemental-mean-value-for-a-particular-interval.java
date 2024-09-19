import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] inputNums = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        int answer = num;

        for (int size=2; size<=inputNums.length; size++) {
            for (int i=0; i<=inputNums.length - size; i++) {
                int tmpSum = 0;
                for (int j=i; j<i+size; j++) {
                    tmpSum += inputNums[j];
                }
                if (tmpSum % size != 0) {
                    continue;
                }
                int avg = tmpSum / size;
                for (int j=i; j<i+size; j++) {
                    if (inputNums[j] == avg) {
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
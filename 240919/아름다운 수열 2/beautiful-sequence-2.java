import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        
        int[] inputNums1 = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int[] inputNums2 = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        Map<Integer, Integer> beautiful = count(inputNums2);
        int answer = 0;
        for (int i=0; i<=inputNums1.length-inputNums2.length; i++) {
            int[] tmp = new int[inputNums2.length];
            int tmpIdx = 0;
            for (int j=i; j<i+inputNums2.length; j++) {
                tmp[tmpIdx] = inputNums1[j];
                tmpIdx++;
            }
            if (beautiful.equals(count(tmp))) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        return counter;
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> tmpList;
        int tmpSum, answer = 0;
        for (int start = 0; start < seq.length; start++) {
            for (int end = start; end < seq.length; end++) {
                tmpList = new ArrayList<>();
                tmpSum = 0;
                for (int idx = start; idx <= end; idx++) {
                    tmpList.add(seq[idx]);
                    tmpSum += seq[idx];
                }
                if (tmpSum % tmpList.size() == 0 && tmpList.contains(tmpSum / tmpList.size())) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> inputs = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        inputs.sort(Comparator.naturalOrder());

        int answer = Integer.MIN_VALUE;
        for (int i=0; i<inputs.size()/2; i++) {
            int tempSum = inputs.get(i) + inputs.get(inputs.size() - 1 - i);
            answer = Math.max(tempSum, answer);
        }
        System.out.println(answer);
    }
}
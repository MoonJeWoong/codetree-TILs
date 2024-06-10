import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> nums = new ArrayList<>();
        int num = inputs[0];
        int target = inputs[1];

        while(true) {
            if (num < target) {
                nums.add(num);
                break;
            }

            nums.add(num % target);
            num /= target;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=nums.size()-1; i>=0; i--) {
            sb.append(nums.get(i));
        }
        System.out.println(sb);
    }
}
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        List<Integer> answers = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int val : inputs) {
            temp.add(val);
            if (temp.size() % 2 == 1) {
                temp.sort(Comparator.naturalOrder());
                answers.add(temp.get(temp.size() / 2));
            }
        }

        String result = answers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
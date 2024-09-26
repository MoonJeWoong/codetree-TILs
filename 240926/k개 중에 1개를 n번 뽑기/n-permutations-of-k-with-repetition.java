import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    private static int n;
    private static int k;
    private static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputLine = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        k = inputLine[0];
        n = inputLine[1];

        recur(0);
    }

    private static void recur(int cur) {
        if (cur == n) {
            String output = selected.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
            System.out.println(output);
            return;
        }

        for (int num=1; num<=k; num++) {
            selected.add(num);
            recur(cur+1);
            selected.remove(selected.size()-1);
        }
    }
}
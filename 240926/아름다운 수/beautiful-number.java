import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static String[] beautifulNumbers = {"1", "22", "333", "4444"};
    private static List<String> selected = new ArrayList<>();
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;

        recur(0);
        System.out.println(answer);
    }

    private static void recur(int count) {
        if (count >= n) {
            if (count == n) {
                answer++;
            }
            return;
        }

        for (String num : beautifulNumbers) {
            selected.add(num);
            recur(count + num.length());
            selected.remove(selected.size() - 1);
        }
    }
}
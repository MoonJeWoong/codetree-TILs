import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    private static List<Integer> selected = new ArrayList<>();
    private static int k;
    private static int n;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputLine = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::valueOf)
                            .toArray();
        
        k = inputLine[0];
        n = inputLine[1];

        select(0);
    }

    public static void select(int idx) {
        if (idx == n) {
            String output = selected.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining(" "));
            System.out.println(output);
            return;
        }

        for (int num=1; num<=k; num++) {
            if (idx < 2 
                || selected.get(idx - 1) != selected.get(idx - 2)
                || (num != selected.get(idx - 1) && num != selected.get(idx - 2))
                ) {
                    selected.add(num);
            } else {
                continue;
            }
            select(idx + 1);
            selected.remove(selected.size() - 1);
        }
    }
}
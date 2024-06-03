import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> listA = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(br.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        
        listA.sort(Comparator.naturalOrder());
        listB.sort(Comparator.naturalOrder());

        for (int i=0; i<n; i++) {
            if (listA.get(i) != listB.get(i)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
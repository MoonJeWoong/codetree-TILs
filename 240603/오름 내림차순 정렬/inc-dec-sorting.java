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

        Arrays.sort(inputs);

        Integer[] boxed = Arrays.stream(inputs)
                            .boxed()
                            .toArray(Integer[]::new);
        Arrays.sort(boxed, Collections.reverseOrder());

        for (int num : inputs) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num : boxed) {
            System.out.print(num + " ");
        }
    }
}
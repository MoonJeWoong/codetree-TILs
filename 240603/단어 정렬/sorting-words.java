import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputs.add(br.readLine());
        }
        inputs.sort(Comparator.naturalOrder());

        for (String value : inputs) {
            System.out.println(value);
        }
    }
}
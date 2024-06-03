import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        String subStr = inputs[2];

        List<String> strList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            String input = br.readLine();
            if (input.startsWith(subStr)) {
                strList.add(input);
            }
        }

        strList.sort(Comparator.naturalOrder());

        System.out.println(strList.get(k-1));
    }
}
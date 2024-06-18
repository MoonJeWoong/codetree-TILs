import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int n = firstLine[0], m = firstLine[1], k = firstLine[2];
        int[] records = new int[n+1];

        int answer = 0;
        for (int i=0; i<m; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            records[inputNum] += 1;
            if (answer == 0 && records[inputNum] == k) {
                answer = inputNum;
            }
        }

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}
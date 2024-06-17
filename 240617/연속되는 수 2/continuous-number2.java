import java.util.*;
import java.util.stream.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 1, count = 1;
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < n-1; i++) {
            int inputNum = Integer.parseInt(br.readLine());
            if (num == inputNum) {
                count++;
                continue;
            }
            answer = Math.max(answer, count);
            count = 1;
            num = inputNum;
        }

        System.out.println(answer);
    }
}
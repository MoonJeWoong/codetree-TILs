import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n];
        for (int iter = 0; iter < n; iter++) {
            people[iter] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;
        for (int room = 0; room < n; room++) {
            int tempValue = 0, tempRoom = room;
            for (int dist = 0; dist < n; dist++) {
                tempValue += dist * people[tempRoom];
                tempRoom = (tempRoom + 1) % n;
            }
            answer = Math.min(answer, tempValue);
        }
        System.out.println(answer);
    }
}
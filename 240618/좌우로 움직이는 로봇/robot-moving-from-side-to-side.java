import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static final int MAX_SIZE = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int n = inputs[0], m = inputs[1];

        int[] posA = new int[MAX_SIZE];
        int[] posB = new int[MAX_SIZE];

        int timeA = 0;
        int timeB = 0;

        for (int i=0; i<n; i++) {
            String[] inputLine = br.readLine().split(" ");
            int time = Integer.parseInt(inputLine[0]);
            recordPos(posA, timeA+1, time, inputLine[1]);
            timeA += time;
        }

        for (int i=0; i<m; i++) {
            String[] inputLine = br.readLine().split(" ");
            int time = Integer.parseInt(inputLine[0]);
            recordPos(posB, timeB+1, time, inputLine[1]);
            timeB += time;
        }

        boolean checkFlag = false;
        int cursorA = 0;
        int cursorB = 0;
        int answer = 0;

        while (cursorA != timeA || cursorB != timeB) {
            if (checkFlag && posA[cursorA] == posB[cursorB]) {
                answer++;
                checkFlag = false;
            }

            if (cursorA != timeA) {
                cursorA++;
            }
            if (cursorB != timeB) {
                cursorB++;
            }
            if (posA[cursorA] != posB[cursorB]) {
                checkFlag = true;
            }
        }

        System.out.println(answer);
    }

    private static void recordPos(int[] pos, int cursor, int time, String direction) {
        while (time-- > 0) {
            if (direction.equals("L")) {
                pos[cursor] = pos[cursor - 1] - 1;
            } else {
                pos[cursor] = pos[cursor - 1] + 1;
            }
        }
        
    }
}
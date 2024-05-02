import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0], m = inputs[1];

        int[] seqA = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] seqB = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int answer = 0;
        
        Map<Integer, Integer> beautifulSeq = new HashMap<>();
        initMap(beautifulSeq);
        for (int number : seqB) {
            beautifulSeq.put(number, beautifulSeq.get(number) + 1);
        }

        if (seqB.length > seqA.length) {
            System.out.println(answer);
            return;
        }

        Map<Integer, Integer> tempSeq = new HashMap<>();
        initMap(tempSeq);
        for (int idx = 0; idx < m; idx++) {
            tempSeq.put(seqA[idx], tempSeq.get(seqA[idx]) + 1);
        }
        if (tempSeq.equals(beautifulSeq)) {
            answer++;
        }

        for (int ptr = m; ptr < seqA.length; ptr++) {
            tempSeq.put(seqA[ptr - m], tempSeq.get(seqA[ptr - m]) - 1);
            tempSeq.put(seqA[ptr], tempSeq.get(seqA[ptr]) + 1);
            if (tempSeq.equals(beautifulSeq)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static void initMap(Map<Integer, Integer> obj) {
        for (int number = 1; number <= 100; number++) {
            obj.put(number, 0);
        }
    }
}
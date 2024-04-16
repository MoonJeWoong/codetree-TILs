import java.io.*;
import java.util.*;

public class Main {
    private static String OPEN_BRACKET = "(";
    private static String CLOSE_BRACKET = ")";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        int answer = 0;
        // for (int idx1 = 0; idx1 < input.length - 3; idx1++) {
        //     if (input[idx1].equals(OPEN_BRACKET)) {
        //         for (int idx2 = idx1 + 1; idx2 < input.length - 2; idx2++) {
        //             if (input[idx2].equals(OPEN_BRACKET)) {
        //                 for (int idx3 = idx2 + 1; idx3 < input.length - 1; idx3++) {
        //                     if (input[idx3].equals(CLOSE_BRACKET)) {
        //                         for (int idx4 = idx3 + 1; idx4 < input.length; idx4++) {
        //                             if (input[idx4].equals(CLOSE_BRACKET)) {
        //                                 answer++;
        //                             }
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        for (int idx1 = 0; idx1 < input.length - 3; idx1++) {
            if (input[idx1].equals(OPEN_BRACKET) && input[idx1 + 1].equals(OPEN_BRACKET)) {
                for (int idx2 = idx1 + 2; idx2 < input.length - 1; idx2++) {
                    if (input[idx2].equals(CLOSE_BRACKET) && input[idx2 + 1].equals(CLOSE_BRACKET)) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
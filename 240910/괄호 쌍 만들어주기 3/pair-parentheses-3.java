import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split("");

        int answer = 0;
        for (int idx1 = 0; idx1 < inputs.length - 1; idx1++) {
            if (inputs[idx1].equals("(")) {
                for (int idx2 = idx1 + 1; idx2 < inputs.length; idx2++) {
                    if (inputs[idx2].equals(")")) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
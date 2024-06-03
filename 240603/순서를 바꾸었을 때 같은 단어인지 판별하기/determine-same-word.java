import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] firstWord = br.readLine().toCharArray();
        char[] secondWord = br.readLine().toCharArray();

        if (firstWord.length != secondWord.length) {
            System.out.println("No");
            return;
        }

        Arrays.sort(firstWord);
        Arrays.sort(secondWord);

        for (int i=0; i<firstWord.length; i++) {
            if (firstWord[i] != secondWord[i]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
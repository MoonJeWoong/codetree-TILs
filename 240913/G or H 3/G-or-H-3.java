import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] firstLine = Arrays.stream(br.readLine().split(" "))
                            . mapToInt(Integer::parseInt)
                            .toArray();
        int[] inputIndexes = new int[firstLine[0]];
        String[] inputChars = new String[firstLine[0]];

        int maxLength = 0;
        for (int iter=0; iter<firstLine[0]; iter++) {
            String[] inputLine = br.readLine().split(" ");
            inputIndexes[iter] = Integer.parseInt(inputLine[0]);
            maxLength = Math.max(maxLength, inputIndexes[iter]);
            inputChars[iter] = inputLine[1];
        }
        
        int[] locations = new int[maxLength + 1];
        for (int iter=0; iter < firstLine[0]; iter++) {
            locations[inputIndexes[iter]] = convertToScore(inputChars[iter]);
        }

        if (maxLength - 1 <= firstLine[1]) {
            int sum = Arrays.stream(locations).sum();
            System.out.println(sum);
            return;
        }

        int answer = 0;
        for (int iter=1; iter<=firstLine[1]+1; iter++) {
            answer += locations[iter];
        }

        int tmp = answer;
        for (int iter=firstLine[1]+2; iter < maxLength+1; iter++) {
            tmp += locations[iter] - locations[iter - firstLine[1] - 1];
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }

    private static int convertToScore(String input) {
        if (input == null) {
            return 0;
        }
        if (input.equals("G")) {
            return 1;
        }
        return 2;
    }
}
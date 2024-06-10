import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] binaryNum = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int decimalNum = 0;
        for(int i=0; i<binaryNum.length; i++) {
            decimalNum = decimalNum * 2 + binaryNum[i];
        }
        decimalNum *= 17;

        List<Integer> finalBinaryNum = new ArrayList<>();
        while (true) {
            if (decimalNum < 2) {
                finalBinaryNum.add(decimalNum);
                break;
            }
            finalBinaryNum.add(decimalNum % 2);
            decimalNum /= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=finalBinaryNum.size()-1; i>=0; i--) {
            sb.append(finalBinaryNum.get(i));
        }

        System.out.println(sb);
    }
}
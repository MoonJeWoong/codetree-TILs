import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] n = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int decimalNum = 0;
        for (int i=0; i<n.length; i++) {
            decimalNum = decimalNum * inputs[0] + n[i];
        }

        List<Integer> finalConvertedNum = new ArrayList<>();
        while(true) {
            if (decimalNum < inputs[1]) {
                finalConvertedNum.add(decimalNum);
                break;
            }
            finalConvertedNum.add(decimalNum % inputs[1]);
            decimalNum /= inputs[1];
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=finalConvertedNum.size()-1; i>=0; i--) {
            sb.append(finalConvertedNum.get(i));
        }
        System.out.println(sb);
    }
}
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] binaryNum = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int num = 0;
        for (int i=0; i<binaryNum.length; i++) {
            num = num * 2 + binaryNum[i];
        }
        System.out.println(num);
    }
}
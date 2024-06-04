import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        System.out.println(calculateMinute(inputs[0], inputs[1], inputs[2]) - calculateMinute(11, 11, 11));
        
    }

    public static int calculateMinute(int day, int hour, int minute) {
        int sum = minute;
        return day * 24 * 60
                + hour * 60
                + minute;
    }
}
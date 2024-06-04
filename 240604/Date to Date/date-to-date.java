import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static int[] dayOfMonth = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        System.out.println(countDay(inputs[2], inputs[3]) - countDay(inputs[0], inputs[1]) + 1);
    }

    public static int countDay(int month, int day) {
        int sum = day;
        for (int i=1; i<month; i++) {
            sum += dayOfMonth[i];
        }
        return sum;
    }
}
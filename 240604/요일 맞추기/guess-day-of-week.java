import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    private static int[] dayOfMonth = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] days = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int difference = calculateDate(inputs[2], inputs[3]) - calculateDate(inputs[0], inputs[1]);

        if (difference < 0) {
            System.out.println(days[7 + (difference % 7)]);
        } else {
            System.out.println(days[difference % 7]);
        }
        
    }

    public static int calculateDate(int month, int day) {
        int sum = day;
        for (int i=1; i<month; i++) {
            sum += dayOfMonth[i];
        }
        return sum;
    }
}
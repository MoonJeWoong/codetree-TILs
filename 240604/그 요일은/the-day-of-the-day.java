import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    private static int[] dayOfMonths = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] days = new String[] {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputDates = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String inputDay = br.readLine();

        int firstMonth = inputDates[0];
        int firstDay = inputDates[1] + Arrays.asList(days).indexOf(inputDay);

        int difference;
        if (firstDay <= dayOfMonths[firstMonth]) {
            difference = calculateDay(inputDates[2], inputDates[3]) - calculateDay(firstMonth, firstDay);            
        } else {
            difference = calculateDay(inputDates[2], inputDates[3]) - calculateDay(firstMonth+1, firstDay-dayOfMonths[firstMonth]);
        }

        if (difference < 0) {
            System.out.println(0);
            return;
        }

        System.out.println(difference / 7 + 1);
    }

    public static int calculateDay(int month, int day) {
        int sum = day;
        for (int i=1; i<month; i++) {
            sum += dayOfMonths[i];
        }
        return sum;
    }
}
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int timeDifference = inputs[2] - inputs[0];
        int minuteDifference;
        
        if (inputs[1] <= inputs[3]) {
            minuteDifference = inputs[3] - inputs[1];
        } else {
            minuteDifference = inputs[3] - inputs[1] + 60;
            timeDifference -= 1;
        }
        
        System.out.println(timeDifference * 60 + minuteDifference);
    }
}
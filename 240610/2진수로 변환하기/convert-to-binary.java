import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        List nums = new ArrayList<>();
        while(true) {
            if (n == 1) {
                nums.add(1);
                break;
            }
            nums.add(n % 2);
            n /= 2;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = nums.size() - 1; i >= 0; i--) {
            sb.append(nums.get(i));
        }
        System.out.println(sb);
    }
}
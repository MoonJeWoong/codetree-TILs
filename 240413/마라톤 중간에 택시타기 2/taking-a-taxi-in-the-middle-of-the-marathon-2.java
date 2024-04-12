import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int iter = 0; iter < n; iter++) {
            int[] inputLine = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            points.add(new Point(inputLine[0], inputLine[1]));
        }

        int answer = Integer.MAX_VALUE;
        for (int excludedIdx = 1; excludedIdx < n - 1; excludedIdx++) {
            int totalDistance = 0;
            for (int idx = 0; idx < n - 1; idx++) {
                if (idx == excludedIdx) {
                    continue;
                }
                if (idx == excludedIdx - 1) {
                    totalDistance += calculateDistance(points.get(idx), points.get(idx+2));
                } else {
                    totalDistance += calculateDistance(points.get(idx), points.get(idx+1));
                }
            }
            answer = Math.min(answer, totalDistance);
        }
        System.out.println(answer);
    }

    private static int calculateDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
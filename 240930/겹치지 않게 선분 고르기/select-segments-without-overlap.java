import java.util.*;
import java.io.*;

public class Main {
    private static List<Line> inputLines = new ArrayList<>();
    private static List<Line> selected = new ArrayList<>();
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = 0;
        for (int iter=0; iter<n; iter++) {
            int[] inputLine = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
            inputLines.add(new Line(inputLine[0], inputLine[1]));
        }
        Collections.sort(inputLines);

        // for (Line cur : inputLines) {
        //     System.out.println(cur.start + " " + cur.end);
        // }
        
        // rec(0)로 시작해서 입력된 선분 개수만큼 재귀를 돌도록 구현
        // rec(point)은 point 번째 선분을 채택할 수 있는지 여부를 판단하고 추가가 가능하다면 추가하는 기능 수행
        for (int idx=0; idx<inputLines.size(); idx++) {
            select(idx);
        }
        
        System.out.println(answer);
        
    }

    private static void select(int point) {
        // System.out.println("point: " + point);
        if (point == inputLines.size()) {
            answer = Math.max(answer, selected.size());
            return;
        }

        // point 번째 선분의 시작점이 가장 최근에 seleceted된 선분의 end 보다 크면 selected에 넣는다.
        if (selected.size() == 0 || selected.get(selected.size() - 1).end < inputLines.get(point).start) {
            selected.add(inputLines.get(point));
            
            // 그 다음 선분 계산
            select(point + 1);

            // 넣은 선분 제거
            selected.remove(selected.size() - 1);
        } 

        // 그 다음 선분 계산
        select(point + 1);
    }
}

class Line implements Comparable<Line> {
    int start;
    int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Line other) {
        return this.start - other.start;
    }
}
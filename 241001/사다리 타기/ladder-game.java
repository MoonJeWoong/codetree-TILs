import java.util.*;
import java.io.*;

public class Main {
    private static List<LadderStep> ladder = new ArrayList<>();
    private static List<LadderStep> selected = new ArrayList<>();
    private static int[] positions;
    private static int[] result;
    private static int n;
    private static int m;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputFirst = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        n = inputFirst[0];
        m = inputFirst[1];

        answer = m;
        positions = new int[n];
        initializePositions(positions);

        // 2차원 배열에 입력된 사다리 정보 저장
        for (int iter=0; iter<m; iter++) {
            int[] stepInput = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ladder.add(new LadderStep(stepInput[1], stepInput[0]));
        }
        Collections.sort(ladder);

        // 해당 사다리를 탔을 때 초기 결과 계산 및 저장
        for (LadderStep step : ladder) {
            swapPosition(positions, step.col);
        }
        result = Arrays.copyOf(positions, positions.length);

        // 그 다음 백트래킹 타면서 모든 사다리 경우의 수 확인하면서 최소 가로줄 개수 갱신
        
        recur(0);

        System.out.println(answer);
    }

    private static void initializePositions(int[] positions) {
        for (int iter=0; iter<n; iter++) {
            positions[iter] = iter + 1;
        }
    }

    private static void swapPosition(int[] positions, int col) {
        int tmp = positions[col];
        positions[col] = positions[col-1];
        positions[col-1] = tmp;
    }

    private static void recur(int idx) {
        // idx 번째 사다리 스텝을 포함할 때와 포함하지 않을 때를 처리
        if (idx == ladder.size()) {
            initializePositions(positions);
            for (LadderStep step : selected) {
                swapPosition(positions, step.col);
            }

            if (Arrays.equals(positions, result)) {
                answer = Math.min(answer, selected.size());
            }
            return;
        }

        selected.add(ladder.get(idx));
        recur(idx + 1);
        selected.remove(selected.size() - 1);

        recur(idx + 1);
    }
}

class LadderStep implements Comparable<LadderStep> {
    int row;
    int col;

    public LadderStep(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(LadderStep other) {
        return this.row - other.row;
    }
}
import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] inputMap;
    private static List<int[]> bombLocations = new ArrayList<>();
    private static List<List<int[]>> bombCases = new ArrayList<>();
    private static int answer = 0;

    static{
        List<int[]> case1 = new ArrayList<>();
        List<int[]> case2 = new ArrayList<>();
        List<int[]> case3 = new ArrayList<>();

        case1.add(new int[] {0,0});
        case1.add(new int[] {1,0});
        case1.add(new int[] {2,0});
        case1.add(new int[] {-1,0});
        case1.add(new int[] {-2,0});

        case2.add(new int[] {0,0});
        case2.add(new int[] {1,0});
        case2.add(new int[] {0,1});
        case2.add(new int[] {-1,0});
        case2.add(new int[] {0,-1});

        case3.add(new int[] {0,0});
        case3.add(new int[] {1,1});
        case3.add(new int[] {1,-1});
        case3.add(new int[] {-1,1});
        case3.add(new int[] {-1,-1});

        bombCases.add(case1);
        bombCases.add(case2);
        bombCases.add(case3);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        inputMap = new int[n][n];
        for (int row=0; row<n; row++) {
            int[] inputRow = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            inputMap[row] = inputRow;
            for (int col=0; col<n; col++) {
                if (inputRow[col] == 1) {
                    bombLocations.add(new int[] {row, col});
                }
            }
        }
        
        recur(0);
        System.out.println(answer);
    }

    private static void recur(int count) {
        if (count == bombLocations.size()) {
            int tmp = 0;
            for (int row=0; row<n; row++) {
                for (int col=0; col<n; col++) {
                    if (inputMap[row][col] >= 1) {
                        tmp++;
                    }
                }
            }
            answer = Math.max(answer, tmp);
            return;
        }

        int[] bomb = bombLocations.get(count);
        for (List<int[]> bombCase : bombCases) {
                for (int[] pos : bombCase) {
                    int explosionPosRow = bomb[0] + pos[0];
                    int explosionPosCol = bomb[1] + pos[1];
                    if (explosionPosRow >= 0 && explosionPosRow < n && explosionPosCol >=0 && explosionPosCol < n) {
                        inputMap[explosionPosRow][explosionPosCol] += 1;
                    }
                }

                recur(count + 1);

                for (int[] pos : bombCase) {
                    int explosionPosRow = bomb[0] + pos[0];
                    int explosionPosCol = bomb[1] + pos[1];
                    if (explosionPosRow >= 0 && explosionPosRow < n && explosionPosCol >=0 && explosionPosCol < n) {
                        inputMap[explosionPosRow][explosionPosCol] -= 1;
                    }
                }
            }
    }
}
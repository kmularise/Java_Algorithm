import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * 문제 출처 :
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 * 시간 복잡도 : n = 9, 시간 복잡도는 n^n 보다 작다.
 * 다만 백트래킹으로 중간에 후보가 안되는 경우에는 더 이상 dfs를 하지 않고, n이 9로 작기 때문에 시간복잡도는 크게 신경을 쓰지 않아도 통과할 수 있을 거 같다.
 */

class Result {
    private static int[][] graph = new int[3][3];
    private static boolean[] visited = new boolean[10];
    private static int minValue = Integer.MAX_VALUE;

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    public static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int getAnswer(List<List<Integer>> s) {
        int answer = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                answer += Math.abs(graph[y][x] - s.get(y).get(x));
            }
        }
        return answer;
    }
     
    public static void dfs(int cy, int cx, List<List<Integer>> s) {
        if (cy == 3 && cx == 0) {
            minValue = Math.min(getAnswer(s), minValue);
            return ;
        }
        for (int i = 1; i <= 9; i ++) {
            if (visited[i]) {
                continue;
            }
            if (cx == 2 && graph[cy][0] + graph[cy][1] + i != 15) {
                continue;
            }
            if (cy == 2 && graph[0][cx] + graph[1][cx] + i != 15) {
                continue;
            }
            if (cy == 2 && cx == 0 && i + graph[1][1] + graph[0][2] != 15) {
                continue;
            }
            if (cy == 2 && cx == 2 && graph[0][0] + graph[1][1] + i != 15) {
                continue;
            }
            
            int nx = (cx + 1) % 3;
            int ny = cy + (cx + 1) / 3;
            visited[i] = true;
            graph[cy][cx] = i;
            dfs(ny, nx, s);
            visited[i] = false;
        }
    } 

    public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
        dfs(0, 0, s);
        return minValue;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);
        System.out.println(result);
        bufferedReader.close();
    }
}

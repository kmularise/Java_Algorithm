import java.util.*;
import java.io.*;

//DP , 시간 복잡도 n , 어떤 상태를 저장할지 판별하는것이 중요했다.
//List를 쓸려했는데, .get(idx) 이런 함수가 코드를 길게 만들어서 그냥 배열로 했다.
public class Main {
    private static int[][] graph2 = new int[16][16];
    private static int[][][] dp = new int[16][16][3];
    public static void check(int y, int x) {
        if (graph2[y][x] == 1) {
            return ;
        }
        if (graph2[y][x - 1] == 0) {
            dp[y][x][0] += dp[y][x - 1][0];
            dp[y][x][0] += dp[y][x - 1][2];
        }
        if (y > 0 && graph2[y - 1][x] == 0) {
            dp[y][x][1] += dp[y - 1][x][1];
            dp[y][x][1] += dp[y - 1][x][2];
        }
        if (y > 0 && graph2[y - 1][x] == 0 && graph2[y][x - 1] == 0 && graph2[y - 1][x - 1] == 0) {
            dp[y][x][2] += dp[y - 1][x - 1][2];
            dp[y][x][2] += dp[y - 1][x - 1][1];
            dp[y][x][2] += dp[y - 1][x - 1][0];
        }
    }
    public static void main(String[] args) throws Exception {
        //기본 틀
        //2:13
        //n * n
        // r : y , c : x
        // (0, 0) -> (N - 1, N - 1)
        // 파이프의 시작은 결국 이전 파이프의 끝 (1, 2) 부터 시작
        // 가로, 세로, 대각선 0  1 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            String[] template = br.readLine().split(" ");
            for (int j = 0 ; j < n ; j++) {
                graph2[i][j] = Integer.parseInt(template[j]);
            }
        }
        dp[0][1][0] = 1;
        for (int y = 0 ; y < n ; y++) {
            for (int x = 2; x < n; x++) {
                check(y, x);
            }
        }
        int answer = dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2];
        System.out.println(answer);
    }
}
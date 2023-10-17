import java.util.*;

public class Main {
    private static int n;
    private static int[][] graph = new int[10][10];
    private static boolean[][] visited = new boolean[10][10];
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static int minValue = Integer.MAX_VALUE;

    public static int getCost(int y, int x) {
        int cost = graph[y][x];
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            cost += graph[y +dy[i]][x + dx[i]];
            visited[y + dy[i]][x + dx[i]] = true;
        }
        return cost;
    }
    public static boolean isVisited(int y, int x) {
        if (visited[y][x]) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (visited[y + dy[i]][x + dx[i]]) return true;
        }
        return false;
    }
    public static void cancel(int y, int x) {
        visited[y][x] = false;
        for (int i = 0; i < 4; i++) {
            visited[y + dy[i]][x + dx[i]] = false;
        }
    }
    public static void dfs(int count, int cost) {
        if (count == 3) {
            minValue = Math.min(minValue, cost);
            return ;
        }
        for (int y = 1 ; y < n - 1; y++) {
            for (int x = 1; x < n - 1; x++) {
                if (isVisited(y, x)) continue;
                int temp = getCost(y, x);
                dfs(count + 1, cost + temp);
                cancel(y,x);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int y = 0 ; y < n; y++) {
            for (int x = 0; x < n; x++) {
                graph[y][x] = sc.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(minValue);
    }
}
# Islands and Treasure
- 시간복잡도 : O(n * m)  
- 풀이 : BFS

```java
class Solution {
    int INF = 2147483647;
    int n;
    int m;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    public void findTreasures(int[][] grid, Queue<int[]> queue) {
        for (int y = 0 ; y < n ; y++) {
            for (int x = 0 ; x < m ; x++) {
                if (grid[y][x] == 0) {
                    queue.add(new int[] {y, x});
                }
            }
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        findTreasures(grid, queue);
        while (!queue.isEmpty()) {
            int[] prev = queue.poll();
            int currentDist = grid[prev[0]][prev[1]];
            for (int i = 0 ; i < 4; i++) {
                int ny = prev[0] + dy[i];
                int nx = prev[1] + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (grid[ny][nx] == -1) continue;
                if (grid[ny][nx] <= currentDist + 1) continue;
                grid[ny][nx] = currentDist + 1;
                queue.add(new int[]{ny, nx});
            }
        }
    }
}

```

# 994. Rotting Oranges
* bfs 변형
* 시간복잡도는 가로 길이 n, 세로 길이 m이면 O(n*m) 정도 될거 같다.
* visited 배열을 자꾸 까먹는다.
* queue를 여기서는 두개를 썼지만 하나만 쓰는 풀이도 있다.
```java
class Solution {
    public int orangesRotting(int[][] grid) {
        int totalCount = 0;
        int rottenCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};
        Queue<int[]> rottenQueue = new ArrayDeque<>();
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                int point = grid[i][j];
                if (point == 2) {
                    rottenCount++;
                    totalCount++;
                    rottenQueue.add(new int[]{i, j});
                }
                if (point == 1) {
                    totalCount++;
                }
            }
        }
        if (totalCount == rottenCount) {
            return 0;
        }
        int day = -1;
        while(!rottenQueue.isEmpty()) {
            Queue<int[]> newRottens = new ArrayDeque<>();
            while (!rottenQueue.isEmpty()) {
                int[] target = rottenQueue.poll();
                for (int i = 0 ; i < 4; i++) {
                    int ny = target[0] + dy[i];
                    int nx = target[1] + dx[i];
                    if (ny >= grid.length || ny < 0 || nx < 0 || nx >= grid[0].length) {
                        continue;
                    }

                    if (grid[ny][nx] == 1 && !visited[ny][nx]) {
                        newRottens.add(new int[]{ny, nx});
                        visited[ny][nx] = true;
                        rottenCount++;
                    }
                }
            }
            rottenQueue = newRottens;
            day++;
        }
        if (rottenCount == totalCount) {
            return day;
        }
        return -1;
    }
}
```

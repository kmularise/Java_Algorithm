# 79. Word Search
* 문제 : https://leetcode.com/problems/word-search/submissions/1349653951/
* 스택 자료구조 써서 풀려다가 방문처리가 애매해져서 원래 풀던대로 재귀함수를 이용해서 풀었다.
* 일반적인 dfs문제인데, 최적화를 하면 dp가 가능할수도 있겟다.
```java
class Solution {
    String word;
    int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    int n, m;
    boolean[][] visited;
    boolean answer = false;
    char[][] board;
    public boolean dfs(int y, int x, int idx) {
        if (idx == word.length() - 1) {
            answer = true;
            return true;
        }
        visited[y][x] = true;
        for (int i = 0 ; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (visited[ny][nx]) continue;
            if (word.charAt(idx + 1) != board[ny][nx]) continue;
            dfs(ny, nx, idx + 1);
        }
        visited[y][x] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        for (int y = 0 ; y < n ; y++) {
            for (int x = 0 ; x < m ; x++) {
                if (board[y][x] == word.charAt(0)) {
                    if (dfs(y, x, 0)) {
                        return true;
                    }
                    for (int i = 0 ; i < n ; i++) {
                        Arrays.fill(visited[i], false);
                    }
                }
            }
        }
        return answer;
    }
}
```

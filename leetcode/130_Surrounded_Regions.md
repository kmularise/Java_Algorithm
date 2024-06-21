# 130. Surrounded Regions
[문제](https://leetcode.com/problems/surrounded-regions/description/)
일반적인 dfs 문제

```java
class Solution {
    boolean[][] visited;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    public void makeVisited(int cy, int cx, char[][] board) {
        if (cy < 0 || cy >= board.length || cx < 0 || cx >= board[0].length) {
            return ;
        }
        if (board[cy][cx]!= 'O' || visited[cy][cx]) {
            return ;
        }
        visited[cy][cx] = true;
        for (int i = 0 ; i < 4; i++) {
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            makeVisited(ny, nx, board);
        }
    }

    public void flip(char[][] board){
        for (int y = 0 ; y < board.length ; y++) {
            for (int x = 0 ; x < board[0].length ; x++) {
                if (board[y][x] == 'O' && !visited[y][x]) {
                    board[y][x] = 'X';
                }
            }
        }
    }

    public void solve(char[][] board) {
        //경계에 있는 O와 인접한 경우
        visited = new boolean[board.length][board[0].length];
        for (int y = 0 ; y < board.length ; y++) {
            makeVisited(y, 0, board);
            makeVisited(y, board[0].length - 1, board);
        }
        for (int x = 0; x < board[0].length ; x++) {
            makeVisited(0, x, board);
            makeVisited(board.length -1, x, board);
        }
        flip(board);
    }
}
```

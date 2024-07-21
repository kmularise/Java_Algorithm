# 329. Longest Increasing Path in a Matrix
* DP
* DP를 이용한다고 풀이를 전개해봤지만, 다른 풀이에 비해 월등히 느린 느낌이어서 풀이를 다시 검토해봐야 할거 같다.
```java
class Solution {
    int[][] dp;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int longestIncreasingPath(int[][] matrix) {
        int minVal = Integer.MAX_VALUE;
        Queue<List<Integer>> minimums = new ArrayDeque<>();
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[matrix.length][matrix[0].length];
        for (int y = 0 ; y < matrix.length ; y++) {
            for (int x = 0 ; x < matrix[0].length ; x++) {
                boolean isValid = true;
                for (int i = 0 ; i < 4 ; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (matrix[ny][nx] < matrix[y][x]) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    minimums.add(List.of(y, x));
                }
            }
        }
        for (List<Integer> val : minimums) {
            dp[val.get(0)][val.get(1)] = 1;
        }
        while (!minimums.isEmpty()) {
            while (!minimums.isEmpty()) {
                List<Integer> target = minimums.poll();
                for (int i = 0 ; i < 4; i++) {
                    int ny = dy[i] + target.get(0);
                    int nx = dx[i] + target.get(1);
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m ) {
                        continue;
                    }
                    if (matrix[ny][nx] > matrix[target.get(0)][target.get(1)] && dp[ny][nx] < dp[target.get(0)][target.get(1)] + 1) {
                        dp[ny][nx] = dp[target.get(0)][target.get(1)] + 1;
                        minimums.add(List.of(ny, nx));
                    }
                }
            }
        }
        int answer = 0;
        for (int y = 0 ; y < n ; y++) {
            for (int x = 0 ; x < m ; x++) {
                answer = Math.max(answer, dp[y][x]);
            }
        }
        return answer;
    }
}
```

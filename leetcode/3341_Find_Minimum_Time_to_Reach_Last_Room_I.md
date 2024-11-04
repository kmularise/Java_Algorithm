# 3341. Find Minimum Time to Reach Last Room I
* 풀이 : 다익스트라(최단거리)
* 문제 : https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/
* n이 작기 때문에 다익스트라가 고려 가능한 풀이었다.
```java
class Node {
    int y;
    int x;
    int dist;
    public Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}
class Solution {
    int[] dy = {1,0, -1, 0};
    int[] dx = {0, 1, 0, -1};
    public int minTimeToReach(int[][] moveTime) {
        //dp로 하기에는 뒤로 후퇴할 수도 있어서 그 부분을 주의해야 한다.
        //최단거리 알고리즘 - 다익스트라
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0 ; i < n ; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        Queue<Node> queue = new PriorityQueue<>((x, y) -> Integer.compare(x.dist, y.dist));
        queue.add(new Node(0, 0, 0));
        dp[0][0] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.y == n - 1 && node.x == m - 1) {
                return node.dist;
            }
            for (int i = 0 ; i < 4 ; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                int dist = Math.max(dp[node.y][node.x] + 1, moveTime[ny][nx] + 1);
                if (dp[ny][nx] > dist) {
                    dp[ny][nx] = dist;
                    queue.add(new Node(ny, nx, dist));
                }
            }
        }
        return -1;
    }
}
```

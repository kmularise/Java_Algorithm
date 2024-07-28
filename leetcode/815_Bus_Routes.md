# 815. Bus Routes
* BFS
* 문제 : https://leetcode.com/problems/bus-routes/description/?envType=list&envId=rabvlt31
* 시간 복잡도 문제로 시간초과가 났었는데, 역 뿐만 아니라, route도 방문 여부를 확인해야 했다.

```java
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> stopToRoute = new HashMap<>();
        int maxStop = -1;
        for (int i = 0 ; i < routes.length ; i++) {
            int[] route = routes[i];
            for (int stop : route) {
                List<Integer> routeIdxs =stopToRoute.getOrDefault(stop, new ArrayList<>());
                routeIdxs.add(i);
                stopToRoute.put(stop, routeIdxs);
                maxStop = Math.max(maxStop, stop);
            }

        }
        if (source == target) {
            return 0;
        }
        if (maxStop < source) {
            return -1;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dp = new int[maxStop + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[source] = 0;
        boolean[] routeVisited = new boolean[routes.length];
        queue.add(source);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == target) {
                return dp[curr];
            }
            List<Integer> currRoutes = stopToRoute.get(curr);
            for (int idx : currRoutes) {
                if (routeVisited[idx]) {
                    continue;
                }
                routeVisited[idx] = true;
                for (int nextStop : routes[idx]) {
                    if (dp[nextStop] > dp[curr] + 1) {
                        dp[nextStop] = dp[curr] + 1;
                        queue.add(nextStop);
                    }
                }
            }
        }
        return -1;
    }
}
```

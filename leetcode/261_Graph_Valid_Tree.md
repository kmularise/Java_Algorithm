# 261. Graph Valid Tree

[문제](https://neetcode.io/problems/valid-tree)

* 양방향 간선
* 시간 복잡도 Math.max(V, E) V: vertex, E; edge

```java
class Solution {
    Map<Integer, List<Integer>> adjacency = new HashMap<>();
    boolean[] visited;

    public void makeGraph(int[][] edges) {
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 =edge[1];
            List<Integer> node1List = adjacency.getOrDefault(node1, new ArrayList<>());
            List<Integer> node2List = adjacency.getOrDefault(node2, new ArrayList<>());
            node1List.add(node2);
            node2List.add(node1);
            adjacency.put(node1, node1List);
            adjacency.put(node2, node2List);
        }
    }

    public boolean dfs(int curr, int prev, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }
        visited[curr] = true;
        for (int next : adjacency.get(curr)) {
            if (next == prev) continue;
            if (!dfs(next, curr, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        if (n == 0 || edges.length == 0) {
            return true;
        }
        //graph 만들기
        makeGraph(edges);
        visited = new boolean[n];
        //tree check
        //간선 간 방향이 없음 아무 node나 지정해도 됨
        boolean isValid =  dfs(edges[0][1], -1, visited);
        if (!isValid) return false;
        int count = 0;
        for (boolean visit : visited) {
            if (visit) count++;
        }
        return count == n;
    }
}
```

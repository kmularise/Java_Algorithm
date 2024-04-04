# 684. Redundant Connection
* 시간복잡도는 O(n)일 것
* union find를 떠올리기 힘들었다.
* 이런 유형의 문제에서 union find를 떠올리는게 이득일지는 좀 더 풀어봐야 알거 같다.
* dfs 를 edge하나 추가할때마다 돌려서 하는 방식도 있다. 다만 union find보다는 속도가 떨어질 것.
```java
import java.util.*;
class Solution {
    private int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> nextNode = new ArrayList<>();
        int n = edges.length;
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        boolean[] visited = new boolean[n + 1];
        for (int[] edge : edges) {
            int one = find(edge[0]);
            int another = find(edge[1]);
            if (one == another) {
                return edge;
            }
            parents[one] = another;
            
        }
        return null;
    }

    public int find(int node) {
        if (node != parents[node]) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }
}
```

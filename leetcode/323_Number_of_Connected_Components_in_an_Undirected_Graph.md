# 323. Number of Connected Components in an Undirected Graph
* union find
```java
class Solution {
    private int[] root;
    public int getRoot(int target) {
        if (target == root[target]) {
            return target;
        }
        root[target] = getRoot(root[target]);
        return root[target];
    }

    public void union(int x, int y) {
        int rx = getRoot(x);
        int ry = getRoot(y);
        if (rx != ry) {
            root[rx] = ry;
        }
    }

    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        for (int i = 0 ; i < n ; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        int count = 0;
        for (int i = 0 ; i < n ; i++) {
            if (root[i] == i) {
                count++;
            }
        }
        return count;
    }
}

```

# 207. Course Schedule
* 그래프 문제는 어렵다..
* visited 배열을 이용해서 방문 정보를 저장하는게 좋을 거 같다.
* 다른 풀이에 비해 속도가 너무 안좋은데 개선 방법을 찾아봐야할듯 하다.
* union find는 간선의 방향이 있는 경우에는 사용하지 않는 것이 좋을 것 같다.
```java
class Solution {
    int[] parents;
    Map<Integer,List<Integer>> graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int child = prerequisite[0];
            int parent = prerequisite[1];
            if (isParent(child, parent)) {
                return false;
            }
            List<Integer> nodes = graph.getOrDefault(parent, new ArrayList<>());
            nodes.add(child);
            graph.put(parent, nodes);
        }
        return true;
    }

    public boolean isParent(int target, int compared) {
        if (target == compared) {
            return true;
        }
        List<Integer> nodes = graph.get(target);
        if (nodes == null) {
            return false;
        }
        Queue<Integer> queue = new ArrayDeque();
        queue.add(target);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (graph.get(curr) == null) {
                continue;
            }
            for (int next : graph.get(curr)) {
                if (next == compared) {
                    return true;
                }
                queue.add(next);
            }
        }
        return false;
    }
}
```

# 210. Course Schedule II
* [문제링크](https://leetcode.com/problems/course-schedule-ii/)
* 위상정렬 : 시간복잡도 O(V + E)

```java
class Solution {
    private int[] grade;
    List<List<Integer>> nexts = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        grade = new int[numCourses];
        for (int i = 0 ; i < numCourses ; i++) {
            List<Integer> temp = new ArrayList<>();
            nexts.add(temp);
        }
        for (int[] prerequisite : prerequisites) {
            int prev = prerequisite[1];
            int next = prerequisite[0];
            nexts.get(prev).add(next);
            grade[next]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < grade.length ; i++) {
            if (grade[i] == 0) {
                queue.add(i); 
            }
        }
        int[] answer = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            answer[idx] = curr;
            idx++;

            List<Integer> nextNodes = nexts.get(curr);
            for (int node : nextNodes) {
                grade[node]--;
                if (grade[node] == 0) {
                    queue.add(node);
                }
            }
        }
        if (idx < numCourses) {
            return new int[0];
        }
        return answer;
    }
}
```

# 973. K Closest Points to Origin
* 문제 : https://leetcode.com/problems/k-closest-points-to-origin/description/
* 우선순위 큐(최소 힙)
```java
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((x, y)-> Integer.compare(x[0] * x[0] + x[1] * x[1], y[0] * y[0] + y[1] * y[1]));
        int[][] answers = new int[k][2];
        for (int[] point : points) {
            queue.add(point);
        }
        for (int i = 0 ; i < k ; i++) {

            int[] point = queue.poll();
            answers[i][0] = point[0];
            answers[i][1] = point[1];
        }
        return answers;
    }
}
```

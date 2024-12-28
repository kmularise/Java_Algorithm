# 84. Largest Rectangle in Histogram
- 문제 : https://leetcode.com/problems/largest-rectangle-in-histogram/description/
- 풀이 : 스택
- 시간복잡도 : O(n), 공간복잡도 : O(n)
- 스택에 원소를 넣기 전, 스택보다 높이가 큰 원소는 빼야 한다. 그래서 최종적으로 스택에서 요소가 빠져나올 때 그 스택보다 높이가 가장 작은 인접한 요소를 빠르게 찾을 수 있기 때문이다.
  
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0 ; i <= heights.length ; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peekLast()]) {
                int height = heights[stack.peekLast()];
                stack.pollLast();
                int width = stack.isEmpty() ? i : i - 1 - stack.peekLast();
                answer = Math.max(answer, height * width);
            }
            stack.addLast(i);
        }
        return answer;
    }
}
```

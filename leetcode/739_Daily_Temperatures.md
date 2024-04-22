# 739. Daily Temperatures
* 스택 자료구조 활용하는 문제였다.
* 시간 복잡도는 O(n)
* 스택이라는 자료구조를 활용해야하는 힌트가 있었음에도 어려웠던 거 같다.
* 그 이유는 보통 앞에서 이전 거를 탐색하는 식으로 생각하는 구조가 잡혀있었던 거 같은데 이번에는 뒤에서부터 살펴봐야 했다.
* 10만 개정도의 데이터가 들어올 때, 보통 DP나 그리디를 생각했던 거 같은데, 자료구조를 활용하는 것도 잊지 말아야 겠다.
* 보통 스택을 사용하는 경우 중에 하나가, 괄호 문제같은 경우도 있을 수 있고, 아니면 이전 거에서 조건을 만족하는 가장 인접한 인덱스를 저장하고 싶을 때 사용하는 거 같다.
```java
import java.util.*;
class Solution {
    private int[] answer;
    public int[] dailyTemperatures(int[] temperatures) {
        answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque();
     //이건 풀이 보기전까지는 아이디어 안떠올랐을 듯
     //stack에서 무효한 원소는 다 빼낸다
     //역으로 뒤집기
     //stack top 혹은 비어있다면 0
     for (int i = temperatures.length -1 ; i >= 0 ; i--) {
        while (!stack.isEmpty()) {
            int j = stack.peekLast();
            if (temperatures[j] <= temperatures[i]) {
                stack.pollLast();
            } else {
                break ;
            }
        }
        if (stack.isEmpty()) {
            answer[i] = 0;
        } else {
            answer[i] = stack.peekLast() - i;
        }
        stack.addLast(i);
     }
     return answer;
    }
}
```

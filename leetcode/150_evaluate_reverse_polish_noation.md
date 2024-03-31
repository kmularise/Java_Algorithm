# 150. Evaluate Reverse Polish Notation
* 전형적인 스택 문제
* 시간복잡도는 O(n)
* array deque vs linked list vs stack
  * stack은 성능이 떨어지고 캡슐화가 잘 안되어 있어서 개발자가 의도하지 않은 메소드를 쓸 수 있다.
  * 양 쪽의 원소를 삽입 삭제할 때, ArrayDeque는 O(1), LinkedList O(1)이다. LinkedList는 양방향 연결리스트로 구현되어 있고, ArrayDeque는 양쪽 끝 인덱스를 저장해두고 바로 random access를 하기 때문이다.
  `"This class is likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue."`
* ArrayDeque는 LinkedList에 비해 cache-locality가 있어 연산 속도가 더 빠르다. 
```java
class Solution {

    private boolean isNumber(String token) {
        if (token.equals("+")) {
            return false;
        }
        if (token.equals("-")) {
            return false;
        }
        if (token.equals("/")) {
            return false;
        }
        if (token.equals("*")) {
            return false;
        }
        return true;
    }

    private int calculate(String operator, int num1, int num2) {
        if (operator.equals("+")) {
            return num1 + num2;
        }
        if (operator.equals("*")) {
            return num1 * num2;
        }
        if (operator.equals("-")) {
            return num1 - num2;
        }
        if (operator.equals("/")) {
            return num1 / num2;
        }
        throw new RuntimeException();
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                deque.addLast(Integer.parseInt(token));
            } else {
                int one = deque.pollLast();
                int another = deque.pollLast();
                int result = calculate(token, another, one);
                deque.addLast(result);
            }
        }
        return deque.pollLast();
    }
}
```

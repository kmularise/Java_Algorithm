# 155. Min Stack
- 문제 : https://leetcode.com/problems/min-stack/description/
- 풀이 : 스택
- 스택 아래 있는 최소 값을 찾는 집합이 스택 위에 있는 최솟값을 찾는 집합에 포함되기 대문에 단일 min 값으로 최솟값을 저장해도 된다.

```java
class Node {
    int val;
    int min;
    
    Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class MinStack {
    Deque<Node> stack = new ArrayDeque<>();
    public MinStack() {
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.addLast(new Node(val, val));
        } else {
            Node top = stack.peekLast();
            stack.addLast(new Node(val, Math.min(val, top.min)));
        }
    }
    
    public void pop() {
        stack.pollLast();
    }
    
    public int top() {
        return stack.peekLast().val;
    }
    
    public int getMin() {
        return stack.peekLast().min;
    }
}
```

# 678. Valid Parenthesis String
* 그리디, 스택 자료구조 이용
* 시간복잡도 : O(n)
* 문제 : https://leetcode.com/problems/valid-parenthesis-string/
* 두가지의 풀이가 있었다. 틀렸던 이유는 남아 있는 '('의 개수가 음수가 될 수 없기 때문에 이 경우에는 0으로 조정을 해주거나, 남아있는 '('과 '*'의 위치를 비교해주어야 했는데, 그 부분을 고려하지 못해서 틀리게 되었다.
```java
class Solution {
    public boolean checkValidString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] array= s.toCharArray();
        int leftMin = 0;
        int leftMax = 0;
        for (char target : array) {
            if (target == '(') {
                leftMin++;
                leftMax++;
            } else if (target == ')') {
                leftMin--;
                leftMax--; 
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin <= 0;
    }
}
```
```java
class Solution {
    public boolean checkValidString(String s) {
        char[] array = s.toCharArray();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (int i = 0 ; i < array.length ; i++) {
            char target = array[i];
            if (target == '(') {
                stack.addLast(i);
            }
            else if (target == '*') {
                stack2.addLast(i);
            }
            else {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                } else {
                    if (!stack2.isEmpty()) {
                        stack2.pollLast();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty() && !stack2.isEmpty()) {
                if (stack.peekLast() < stack2.peekLast()) {
                    stack.pollLast();
                    stack2.pollLast();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
```

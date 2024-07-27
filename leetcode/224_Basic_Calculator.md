# 224. Basic Calculator
* 중위연산, 괄호 포함
* stack
* 시간복잡도 : O(s의 길이)
* 두자릿수가 계산에 들어오는 걸 고려하지 못했고, -30과 같이 음수가 들어오는 걸 고려하지 못했다. 그래서 그에 맞춰 다시 수정했다.
```java
class Solution {
    private static final long PREV = Long.MAX_VALUE;
    private static final long PLUS = Long.MAX_VALUE - 1;
    private static final long MINUS = Long.MAX_VALUE - 2;
    public int calculate(String s) {
        Deque<Long> stack = new ArrayDeque<>();
        long number = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if ((s.charAt(i) - '0')>= 0 && (s.charAt(i) - '0') <= 9) {
                number = number * 10 + (s.charAt(i) - '0');
                continue;
            }
            if (number != 0) {
                stack.addLast(number);
                number = 0;
            }
            if (s.charAt(i) == '(') {
                stack.addLast(PREV);
                continue;
            }
            if (s.charAt(i) == '+') {
                stack.addLast(PLUS);
                continue;
            }
            if (s.charAt(i) == '-') {
                stack.addLast(MINUS);
                continue;
            }
            if (s.charAt(i) == ')') {
                long answer = 0;
                long prev = 0;
                while (true) {
                    long target = stack.pollLast();
                    if (target == PREV) {
                        answer += prev;
                        stack.addLast(answer);
                        break;
                    }
                    if (target == PLUS) {
                        answer += prev;
                        prev = 0;
                        continue;
                    }
                    if (target == MINUS) {
                        answer -= prev;
                        prev = 0;
                        continue;
                    }
                    prev = target;
                }
            }
        }
        stack.addLast(number);
        long answer1 = 0;
        long prev1 = 0;
        while (true) {
            if (stack.isEmpty()) {
                answer1 += prev1;
                stack.addLast(answer1);
                break;
            }
            long target = stack.pollLast();
            if (target == PLUS) {
                answer1 += prev1;
                prev1 = 0;
                continue;
            }
            if (target == MINUS) {
                answer1 -= prev1;
                prev1 = 0;
                continue;
            }
            prev1 = target;
        }
        //0~9 
        //(가 나오면 stack push
        //숫자가 나오면 stack push
        //+가 나오면 stack pop 은 숫자 다음게 괄호일수도 있고 숫자일 수도 있음
        //숫자면 그대로 연산
        //괄호면 () 끝날 때까지 인덱스를 옮긴 후 연산
        return (int) answer1;
    }
}
```

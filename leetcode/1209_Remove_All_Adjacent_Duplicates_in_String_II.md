# 1209. Remove All Adjacent Duplicates in String II
* 링크 : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
* 관련 개념 : stack
* 시간 복잡도 : O(n)
* 스택으로 푸는 건지는 대략적으로 감을 잡았으나, 동일한 알파벳 개수를 저장하는 용도로 스택을 쓰는 것은 생각하지 못했다. 이런 아이디어를 기억해둔다면 나중에 비슷한 문제가 나오면 괜찮게 풀 수 있을 거 같다.

## 성공한 풀이
```java
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<Character> charStack = new ArrayDeque<>();
        Deque<Integer>  countStack = new ArrayDeque<>();

        for (char target : s.toCharArray()) {
            if (charStack.isEmpty()) {
                charStack.addLast(target);
                countStack.addLast(1);
                continue;
            } else {
                if (charStack.peekLast() == target){
                    charStack.addLast(target);
                    countStack.addLast(countStack.peekLast() + 1);
                } else {
                    charStack.addLast(target);
                    countStack.addLast(1);
                }
            }
            if (countStack.peekLast() == k) {
                for (int j = 0 ; j < k ; j++) {
                    countStack.pollLast();
                    charStack.pollLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()) {
            sb.append(charStack.poll());
        }
        return sb.toString();
    }
}
```

## 실패한 풀이
* 시간복잡도 O(s.length * k) 인데, 여기서 k가 10^4까지여서 10억 정도여서 실패한 거 같다.
* 그리고 배열에서 k개 삭제하는데 최대 10000개까지 삭제하게 되서 그 부분도 비효율적인 거 같다.
```java
class Solution {
    private boolean isValid(int k, List<Character> list, char target) {
        for (int i = list.size() - 1 ; i >= list.size() - k + 1 ; i--) {
            if (target != list.get(i)) {
                return false;
            }
        }
        return true;
    }
    public String removeDuplicates(String s, int k) {
        List<Character> list = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i++) {
            if (list.size() < k - 1 || !isValid(k, list, s.charAt(i))) {
                list.add(s.charAt(i));
            } else {
                for (int j = 0 ; j < k - 1 ; j++) {
                    list.remove(list.size() - 1);
                } 
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}
```

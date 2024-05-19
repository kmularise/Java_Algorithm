# 208. Implement Trie (Prefix Tree)
[문제링크](https://leetcode.com/problems/implement-trie-prefix-tree/description/)
* 문자열 탐색 : 트라이
* 트라이 생성 시간 복잡도 : 문자열 개수 M * 최대 문자열 길이 L
* 트라이 탐색 시간 복잡도 : 최대 문자열 길이 L

nextNodes를 배열로 하면 조금 더 실행시간이 빨라진다. 해시 충돌이 발생해서 그런가 했지만 알파벳이면 아스키코드 값을 해시코드로 사용하기 때문에 해시 충돌이 발생할 일은 없어보인다. hashCode 함수를 추가적으로 호출하는 과정에서 더 느려지나 싶기도 하다.
Node 관련 코드를 좀 더 객체지향적으로 짤 수 있도록 개선할 수 있을 거 같다.

```java
import java.util.*;
class Node {
    Map<Character, Node> nextNodes = new HashMap<>();
    boolean isEnd = false;
    public Node() {

    }

    public Node getNext(char target) {
        return nextNodes.get(target);
    }
}

class Trie {
    private Node rootNode;
    public Trie() {
        rootNode = new Node();
    }
    
    public void insert(String word) {
        insertRecursively(rootNode, word, 0);
    }
    
    public boolean search(String word) {
        int[] info = getSearchInfo(word, 0, rootNode);
        if (info[0] == 1 && info[1] == 1) {
            return true;
        }
        return false;
    }

    public void insertRecursively(Node curr, String word, int i) {
        if (i == word.length()) {
            curr.isEnd = true;
            return ;
        }
        char target = word.charAt(i);
        Node next = curr.getNext(target);
        if (next == null) {
            next = new Node();
            curr.nextNodes.put(target, next);
            insertRecursively(next, word, i + 1);
        } else {
            insertRecursively(next, word, i + 1);
        }
    }
    
    public boolean startsWith(String prefix) {
        int[] info = getSearchInfo(prefix, 0, rootNode);
        if (info[0] == 1) {
            return true;
        }
        return false;
    }

    public int[] getSearchInfo(String word, int i, Node curr) {
        if (i == word.length()) {
            return new int[]{1 , curr.isEnd ? 1: 0};
        }
        char target = word.charAt(i);
        Node next = curr.getNext(target);
        if (next == null) {
            return new int[]{0, 0};
        }
        return getSearchInfo(word, i + 1, next);
    }
}
```

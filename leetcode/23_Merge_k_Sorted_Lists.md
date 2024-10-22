# 23. Merge k Sorted Lists
* 링크 : https://leetcode.com/problems/merge-k-sorted-lists/description/
* 풀이 : 우선순위 큐
* 시간 복잡도 : n log k, n : 전체 데이터 개수, k : list 개수
* 주어진 연결리스트를 이용해서 구현하는 것이 힘들었다. 알고리즘 같은 경우에는 이전에 떠올린 풀이와 비슷해서 아이디어는 쉽게 생각해낼 수 있었다. 여기서 핵심은 lists의 요소들이 정렬되어 있다는 것이 핵심이다. 

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>((x, y) -> Integer.compare(x.val, y.val));
        for (int i = 0 ; i < k ; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        if (queue.isEmpty()) return null;
        ListNode root = queue.poll();
        ListNode prev = root;
        ListNode curr = null;
        if (prev.next != null) {
            queue.add(prev.next);
        }
        while (true) {
            if (queue.isEmpty()) break;
            curr = queue.poll();
            if (curr.next != null) {
                queue.add(curr.next);
            }
            prev.next = curr;
            prev = curr;
        }
        return root;
    }
}
```

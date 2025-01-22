# 2. Add Two Numbers
- 연결리스트 연습 문제
- 시간복잡도 : O(n + m), 공간복잡도 : O(max(n, m))

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int getNumber(ListNode l1) {
        int number = 0;
        int w = 1;
        while (l1 != null) {
            number += (l1.val * w);
            l1 = l1.next;
            w = w * 10;
        }
        return number;
    }
    public ListNode getListNode(int number) {
        String digits = String.valueOf(number);
        ListNode next = null;
        for (int i = 0 ; i < digits.length() ; i++) {
            int digit = digits.charAt(i) - '0';
            ListNode curr = new ListNode(digit, next);
            next = curr;
        }
        return next;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number = 0;
        int n1 = getNumber(l1);
        int n2 = getNumber(l2);
        return getListNode(n1 + n2);
    }
}

```

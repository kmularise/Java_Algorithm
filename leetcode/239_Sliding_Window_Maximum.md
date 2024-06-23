239. Sliding Window Maximum
* 문제 : https://leetcode.com/problems/sliding-window-maximum/description/
* 고정 길이의 슬라이딩 윈도우, 데크(deque) 활용
* 시간복잡도 : O(n)
```java
import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] answer = new int[n - k + 1];
        for (int r = 0 ; r < n ; r++) {
            int l = r - k + 1;
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }
            dq.add(r);
            if (l > dq.peekFirst()) dq.pollFirst();
            if (r >= k - 1) {
                answer[l] = nums[dq.peekFirst()];
            }
        }
        return answer;
    }
}
```

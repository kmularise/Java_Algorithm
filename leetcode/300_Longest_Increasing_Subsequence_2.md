# 300. Longest Increasing Subsequence
- LIS는 유명한 알고리즘으로 크게 세가지 방법이 있다.
- DP(시간복잡도 O(n^2), 이분탐색 (시간복잡도 n log n), 세그먼트 트리(시간복잡도 n log n) 가 있다.
- 여기서는 DP와 이분 탐색을 이용할 풀이만 기재한다.

## DP 
- 시간복잡도 : O(n^2)
```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 시간복잡도 n^2
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1 ; i < nums.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int answer = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
```


## 이분탐색
- 시간복잡도 : O(n log n)
```java
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        int count = 1;
        for (int i = 1 ; i < nums.length ; i++) {
            if (dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);//현재 list의 끝요소보다 크면 count 1 증가하고 정렬된 리스트에 넣기
                count++;
                continue;
            }
            int idx = Collections.binarySearch(dp, nums[i]);
            // 현재 List의 끝요소보다 작으면 이분탐색, 0보다 작으면 원래 리스트 수들 중 사이에 넣을 수 있다는 의미
            // 이 부분은 조건에 맞게 직접 이분 탐색을 구현할 수도 있음
            if (idx < 0) {
                idx = -idx - 1;
                dp.set(idx, nums[i]);
            }
        }
        return count;
    }
}
```

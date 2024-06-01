# 152. Maximum Product Subarray
* DP (O(n))
* 각 i번째의 배열까지 최소 최대값을 저장하는 것, 그리고 곱하는 대상의 숫자의 부호에 따라 다르게 처리하는 것의 유의해야 했다.
```java
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        int dpMin = nums[0];
        int dpMax= nums[0];
        for (int i = 1; i < n ; i++) {
            int num = nums[i];
            int prevMin = dpMin;
            int prevMax = dpMax;
            if (num < 0) {
                dpMin = Math.min(prevMax * num, num);
                dpMax = Math.max(prevMin * num, num);
            } else {
                dpMin = Math.min(prevMin * num, num);
                dpMax = Math.max(prevMax * num, num);
            }
            ans = Math.max(ans, dpMax);
        }
        return ans;
    }
}
```

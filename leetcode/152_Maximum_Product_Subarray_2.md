# 152. Maximum Product Subarray
- 문제 : 152. Maximum Product Subarray
- 풀이 : DP
- 시간복잡도 : O(n), 공간복잡도 O(1)
```java
class Solution {
    public int maxProduct(int[] nums) {
        int answer = 1;
        //n^2 
        //start end 
        int res = nums[0];
        int prevMax = 1;
        int prevMin = 1;
        for (int num : nums) {
            int tempMin = prevMin * num;
            int tempMax = prevMax * num;
            prevMax = Math.max(Math.max(tempMin, tempMax), num);
            prevMin = Math.min(Math.min(tempMin, tempMax), num);
            res = Math.max(res, prevMax);
        }
        return res;
    }
}
```

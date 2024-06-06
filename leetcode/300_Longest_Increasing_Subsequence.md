# 300. Longest Increasing Subsequence
* https://leetcode.com/problems/longest-increasing-subsequence/description/
* 시간복잡도 n log n

```java
class Solution {
    int[] list;
    int binarySearch(int left, int right, int target) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        list = new int[n];
        list[0] = nums[0];
        int i = 1;
        int j = 0;
        while (i < n) {
            if (list[j] < nums[i]) {
                list[j + 1] = nums[i];
                j++;
            } else {
                int pos = binarySearch(0, j, nums[i]);
                list[pos] = nums[i];
            }
            i++;
        }
        return j + 1;
    }
}
```

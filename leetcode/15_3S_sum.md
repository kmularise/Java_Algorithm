# 15. 3Sum
* 문제 : https://leetcode.com/problems/3sum/description/
* 투포인터
```java
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();
        for (int start = 0 ; start < nums.length - 2 ; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            int mid = start + 1;
            int end = nums.length - 1;
            while (mid < end) {
                int target = nums[start] + nums[mid] + nums[end];
                if (target < 0) {
                    mid++;
                }
                else if (target > 0) {
                    end--;
                }
                else {
                    answers.add(List.of(nums[start], nums[mid], nums[end]));
                    while (mid < end && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    while (mid < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    mid++;
                    end--;
                }
            }
        } 
        return answers;
    }
}
```

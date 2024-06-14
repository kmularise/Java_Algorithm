# 128. Longest Consecutive Sequence
* Hash
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ml = 0;
        for (int target : nums) {
            int cl = 1;
            int left = target -1;
            while (set.contains(left)) {
                set.remove(left);
                left--;
                cl++;
            }
            int right = target + 1;
            while (set.contains(right)) {
                set.remove(right);
                right++;
                cl++;
            }
            ml = Math.max(ml, cl);
        }
        return ml;
    }
}
```

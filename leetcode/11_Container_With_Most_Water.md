# 11. Container With Most Water
문제 : https://leetcode.com/problems/container-with-most-water/submissions/
```java
class Solution {
    public int maxArea(int[] height) {
        //각각의 지점 i에서 체크하지 않고 넘어가는 것도 있을 것 
        // 범위를 좁혀가면서 높이가 높은 것만 체크한다.
        //first second
        int start = 0;
        int end = height.length - 1;
        int maxVal = 0;
        int maxH = 0;
        while (true) {
            int h = Math.min(height[start], height[end]);
            int l = end - start;
            if (h > maxH && h * l > maxVal) {
                maxVal = h * l;
                maxH = h;
            }
            if (height[start] == height[end]) {
                start++;
                end--;
            } else if (height[start] > height[end]) {
                end--;
            } else {
                start++;
            }
            if (end == start || start == end + 1) {
                break ;
            }
        }
        return maxVal;
    }
}
```

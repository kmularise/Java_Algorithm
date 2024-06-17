# 42. Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/description/
* 시간 복잡도 O(n) 이지만 투포인터에 비해 공간복잡도는 더 클 거 같다.

```java
class Solution {
    int[] rightH;
    int[] leftH;
    public int trap(int[] height) {
        rightH = new int[height.length];
        leftH = new int[height.length];
        int left = 0;
        int right = 0;
        int n = height.length;
        for (int i = 0 ; i < n ; i++) {
            if (height[i] > left) {
                left = height[i]; 
            }
            leftH[i] = left;
        }
        for (int i = n - 1 ; i >= 0 ; i--) {
            if (height[i] > right) {
                right = height[i];
            }
            rightH[i] = right;
        }
        int answer = 0;
        for (int i = 0 ; i < n ;i++) {
            int dh = Math.max(0, Math.min(rightH[i] - height[i], leftH[i] - height[i]));
            answer += dh;
        }
        return answer;
    }
}
```
* 투포인터 풀이
  * 인접한 인덱스에 영향을 받는다는 점, 왼쪽과 오른쪽을 고려해야 한다는 점으로 투포인터를 고려해볼 수 있을 거 같다.
```java
class Solution {
    public int trap(int[] height) {
        int r = height.length - 1;
        int l = 0;
        int answer = 0;
        int rMax = height[height.length - 1];
        int lMax = height[0];
        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                answer += (lMax - height[l]);
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                answer += (rMax - height[r]);
            }
        }
        return answer;
    }
}
```

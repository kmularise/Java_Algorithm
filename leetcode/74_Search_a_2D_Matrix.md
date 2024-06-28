# 74. Search a 2D Matrix
* 문제 : https://leetcode.com/problems/search-a-2d-matrix/
* 이진탐색
* end랑 start 설정할때 mid로 해서 그걸로 따로 처리할게 많아서 좀 더 깔끔하게 수정했다.
```java
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length * (matrix[0].length) - 1;
        boolean exists = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            int y = mid / matrix[0].length;
            int x = mid % matrix[0].length;
            if (matrix[y][x] > target) {
                end = mid - 1;
            } else if (matrix[y][x] < target) {
                start = mid + 1;
            } else {
                exists = true;
                break;
            }
        }
        return exists;
    }
}
```

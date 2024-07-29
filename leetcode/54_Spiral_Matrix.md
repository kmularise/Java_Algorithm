# 54. Spiral Matrix
* 기하, 구현
* 한줄 케이스에 대해서 오류가 나서 수정하느라 시간이 걸렸다.
```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        List<Integer> answer = new ArrayList<>();
        int i = 0;
        while (i < n * m ) {
            int y = l;
            int x = l;
            if (l == n / 2) {
                while (x < m - l) {
                    answer.add(matrix[y][x]);
                    x++;
                    i++;
                }
                break;
            }
            if (l == m / 2) {
                while (y < n - l) {
                    answer.add(matrix[y][x]);
                    y++;
                    i++;
                }
                break;
            }
            while (x < m - l - 1) {
                answer.add(matrix[y][x]);
                x++;
                i++;
            }
            while (y < n - l - 1) {
                answer.add(matrix[y][x]);
                y++;
                i++;
            }
            while (x > l) {
                answer.add(matrix[y][x]);
                x--;
                i++;
            }
            while (y > l) {
                answer.add(matrix[y][x]);
                y--;
                i++;
            }
            l++;
        }
        return answer; 
    }
}
```

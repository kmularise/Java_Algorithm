# 66. Plus One
* 문제 : https://leetcode.com/problems/plus-one/description/
* 2^64 -1 보다 더큰 수가 들어올 수 있음을 고려해야 한다.

```java
class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int temp = 1;
        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            
            int origin = digits[i];
            digits[i] = (origin + temp) % 10;
            temp = (origin + temp) / 10;
            if (i == 0 && temp == 1) {

                flag = true;
            }
        }
        if (!flag) {
            return digits;
        }
        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        for (int i = 0 ; i < digits.length ; i++) {
            answer[i + 1] = digits[i];
        }
        return answer;
    }
}
```

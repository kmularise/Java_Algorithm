# 3233. Find the Count of Numbers Which Are Not Special
* 풀이 : 수학
* 문제 : https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/description/

```java
class Solution {
    boolean[] primes;
    public int nonSpecialCount(int l, int r) {
        int start = (int) Math.sqrt(l - 1) + 1;
        int end = (int) Math.sqrt(r) + 1;
        primes = new boolean[end + 1];
        Arrays.fill(primes, true);
        int count = 0;
        primes[1] = false;
        for (int i = 2 ; i < end ;i++) {
            if (primes[i]) {
                for (int j = 2 * i ; j < end ; j+= i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = start ; i < end ; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return r - l + 1 - count;
    }
}
```

# 1835. Find XOR Sum of All Pairs Bitwise AND

- 링크 : https://leetcode.com/problems/find-xor-sum-of-all-pairs-bitwise-and/
- 풀이 : 비트연산
- 비트 연산의 분배법칙이 성립함을 이용하여 시간복잡도 n^2에서 시간복잡도 n으로 줄일 수 있는 문제였다.
- 보통의 코딩테스트 유형에서는 잘 나오지 않는 유형이었다.

```java
class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xorBit1 = 0;
        for (int num1 : arr1) {
            xorBit1 = (xorBit1 ^ num1);
        }
        int xorBit2 = 0;
        for (int num2 : arr2) {
            xorBit2 = (xorBit2 ^ num2);
        }
        return (xorBit1 & xorBit2);
    }
}
```

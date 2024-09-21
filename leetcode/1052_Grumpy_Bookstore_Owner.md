# 1052. Grumpy Bookstore Owner
* 문제 : https://leetcode.com/problems/grumpy-bookstore-owner/description/?envType=daily-question&envId=2024-08-01
* 랜덤 디팬스
* 슬라이딩 윈도우
* 시간 복잡도 O(n)
* 풀이시간: 약 20분
* 소감 : 어떻게 풀지 미리 생각하고 문제 풀이에 들어가니 조금 더 깔끔하게 풀리는 거 같다. 하지만 문제 자체에서 너무 슬라이딩 윈도우로 풀라고 보여서 조금 더 변형문제는 많이 풀어봐야겠다는 생각이 든다.

```java
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //n minutes
        // i minute customer number
        //grumpy 1
        //grumpy - not satisfied
        //minutes not grumpy
        //고정길이의 슬라이딩 윈도우 - minutes 고정이니까
        //2 10^4 정도면 log(n)n log(n) 정도가 좋을 거 같다.
        //처음에 customers에서 bit 1 인걸 구하고 더하기
        //그다음에 슬라이딩 윈도우로 처리하기 - 그래서 maxVal 구하기
        int n = customers.length;
        int baseScore = 0;
        for (int i = 0 ; i < n ; i++) {
            if (grumpy[i] == 0) {
                baseScore += customers[i];
            }
        }
        int currentBonus = 0;
        int maxBonus = 0;
        for (int i = 0 ; i < minutes ; i++) {
            if (grumpy[i] == 1) {
                currentBonus += customers[i];
            }
        }
        maxBonus = currentBonus;
        for (int i = minutes ; i < n ; i++) {
            int addValue = 0;
            int minusValue = 0;
            if (grumpy[i] == 1) {
                addValue = customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                minusValue = customers[i - minutes];
            }
            currentBonus = currentBonus + addValue - minusValue;
            maxBonus = Math.max(maxBonus, currentBonus);
        }
        return baseScore + maxBonus;
    }
}
```

# 518. Coin Change II
* DP
* 떠올리기 힘든 아이디어였던 거 같다. 
* 시간 복잡도 : O(amount * coins.length), 문제 조건에 의해 최대 150만번 반복
* 다시 풀어보면 좋을 거 같다.
```java
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins.length - 1; i>= 0 ; i--) {
            int[] ndp = new int[amount + 1];
            ndp[0] = 1;
            //중복되지 않게끔 하려는 장치 1 1 1 1 1과 같이 똑같은 코인을 중복되게 하지 않게 하려는 장치
            for (int j = 1 ; j <= amount ; j++) {
                ndp[j] = dp[j];
                if (j - coins[i] >= 0) {
                    ndp[j] += ndp[j - coins[i]];
                }
            }
            dp = ndp;
        }
        return dp[amount];
    }
}

```

# 494. Target Sum
* 문제 : https://leetcode.com/problems/target-sum/description/
* DP로 풀었다. 이전과 다르게 시도한 방법은 이차원 배열 대신 map을 사용했다. 그 이유는 중간에 값이 음수가 될 수도 있기 때문이다.
* 저장해야할 두가지 변수로는 몇번째 수 까지 연산을 진행했는지를 나타내는 값(level)과 연산된 값(value)을 저장했다. 사실 알고리즘을 풀 때에만 해도 이게 될까 싶었다. 하지만 다시 자세히 살펴보니, sum(nums[i])가 0에서 1000사이라는 조건이 있었고, value의 범위는 -1000 ~ 1000이 되게 된다. 따라서 시간 복잡도는 level의 수 (최대 21) * value의 후보 개수 (2001) 이다. 최대 약 40000번의 연산이 일어나기 때문에 이 풀이는 적합하다. value의 범위가 -1000~ 1000인 점이 DP 풀이로 풀 수 있는 중요한 조건이었다. 실제로 다른 사람의 풀이에서도 나처럼 Map을 사용했고, 나와 유사하게 변수를 둠을 확인할 수 있었다.

```java
class Solution {
    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        // level value
        dp.put(0, new HashMap<>());
        dp.get(0).put(0, 1);
        for (int i = 0 ; i < nums.length ; i++) {
            int level = i + 1;
            int value = nums[i];
            Map<Integer, Integer> values = dp.get(level - 1);
            dp.put(level, new HashMap<>());
            for (int key : values.keySet()) {
                int newValue = values.get(key);
                int prev1 = dp.get(level).getOrDefault(key + value, 0);
                dp.get(level).put(key + value, prev1 + newValue);
                int prev2 = dp.get(level).getOrDefault(key - value, 0);
                dp.get(level).put(key - value, prev2 + newValue);
            }

        }
        return dp.get(nums.length).getOrDefault(target, 0);
    }
}
```

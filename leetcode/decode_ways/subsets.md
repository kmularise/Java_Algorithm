# 78. Subsets : 백트래킹
https://leetcode.com/problems/subsets/description/

* 시간복잡도 (2 ** n) * n이다.
* 백트래킹이긴 하지만, 이 풀이가 먼저 떠올라서 이렇게 풀었다. dfs로도 풀릴거 같다.
* 그렇지만 n이 10이하이기 때문에 최대 10240 단위 작업을 반복할 것이므로 시간 초과는 나지 않을 거 같다.

## 코드
* 집합 연산은 n이 작을 때에는 비트마스크가 확실히 익혀두면 편하다.

```java
import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int count = nums.length;
        int totalBit = (1 << count) - 1;
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0 ; i <= totalBit ; i++) {
            List<Integer> element = new ArrayList<>();
            for (int j = 0 ; j < count ; j++) {
                int targetBit = (1 << j);
                if ((targetBit & i) != 0) {
                    element.add(nums[j]);
                }
            }
            answer.add(element);
        }
        return answer;
    }
}
```

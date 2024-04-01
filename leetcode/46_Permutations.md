# 46. Permutations
https://leetcode.com/problems/permutations/
- 전형적인 dfs 문제
- 이중배열을 반환해야했고, List가 reference라서 deep copy를 해야했다.
- n ^ n의 시간 복잡도이나, n이 작기 때문에 괜찮을 거 같다.

```java
import java.util.*;
class Solution {
    int length;
    int[] nums;
    List<List<Integer>> answers = new ArrayList<>();
    public void dfs(int index, List<Integer> numbers, boolean[] visited) {
        if (index == length) {
            List<Integer> answer = new ArrayList<>();
            answer.addAll(numbers);
            answers.add(answer);
            return ;
        }
        for (int i = 0 ; i < length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                numbers.add(nums[i]);
                dfs(index + 1, numbers, visited);
                visited[i] = false;
                numbers.removeLast();
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        this.nums = nums;
        boolean[] visited = new boolean[length];
        dfs(0, new ArrayList<>(), visited);
        return answers;
    }
}
```

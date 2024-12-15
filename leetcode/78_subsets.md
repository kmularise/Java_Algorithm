# 78. Subsets
- 백트래킹
- array list remove(index) 시 마지막 요소를 제거하는 건 시간복잡도 O(1)이다. ArrayList와 LinkedList일 경우 모두 시간복잡도 O(1)이다.
```java
class Solution {
    List<List<Integer>> answers;
    public void dfs(int idx, int[] nums, List<Integer> origin) {
        if (idx == nums.length) {
            answers.add(new ArrayList<>(origin));
            return;
        }
        dfs(idx + 1, nums, origin);
        origin.add(nums[idx]);
        dfs(idx + 1, nums, origin);
        origin.remove(origin.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        answers = new ArrayList<>();
        dfs(0, nums, new ArrayList<>());
        return answers;
    }
}

```

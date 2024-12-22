# Combination Sum
* 문제 : https://leetcode.com/problems/combination-sum/submissions/
* 풀이 : DFS
* 백트래킹 시 마지막에서 꼭 되돌리는 과정이 있어야 재귀함수를 호출한 곳에서 정상적으로 동작할 수 있다.
```java
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public void dfs(int idx, int sum, int target, int[] counts, int[] nums) {
        if (idx == nums.length) {
            if (sum != target) return;
            List<Integer> answer = new ArrayList<>();
            for (int i = 0 ; i < counts.length ; i++) {
                for (int j = 0 ; j < counts[i] ; j++) {
                    answer.add(nums[i]);
                }
            }
            list.add(answer);
            return;
        }
        int num = nums[idx];
        dfs(idx + 1, sum, target, counts, nums);
        while (sum < target) {
            counts[idx]++;
            dfs(idx + 1, sum + num, target, counts, nums);
            sum += num;
        }
        counts[idx] =0; // counts[idx] 되돌리는 과정 필요
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int[] counts = new int[nums.length];
        dfs(0, 0, target, counts, nums);
        return list;
    }
}
```

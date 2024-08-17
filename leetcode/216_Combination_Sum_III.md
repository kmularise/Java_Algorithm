# 216. Combination Sum III
* 문제 : https://leetcode.com/problems/combination-sum-iii/description/
* DFS
```java
class Solution {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    List<List<Integer>> answers = new ArrayList<>();
    public void dfs(int idx, List<Integer> target, int k, int n) {
        if (target.size() == k) {
            int sum = 0;
            for (int number : target) {
                sum += number;
            }
            if (sum == n) {
                System.out.println(target);
                answers.addLast(new ArrayList<>(target));
            }
            return;
        }
        for (int i = idx + 1 ; i < numbers.length ; i++) {
            target.addLast(numbers[i]);
            dfs(i, target, k, n);
            target.removeLast();
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> target = new LinkedList<>();
        dfs(-1, target, k , n);
        return answers;
    }
}
```

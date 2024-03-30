# 39. Combination Sum : back tracking
* 백트래킹 문제 
* 답인 경우에만 새로운 List에 deep copy를 해주어야 했다.
* List 객체를 생성하는 비용이 은근 많이 듬을 깨달았다.
* 시간 복잡도 2 ** n이지만 n이 작아서 이 정도 시간 복잡도는 괜찮을 거 같다.
```java
class Solution {
    private int[] candidates;
    private int target;
    List<List<Integer>> answers = new ArrayList<>();

    public void dfs(int index, int sum, List<Integer> prev) {
        if (sum == target) {
            List<Integer> another = new ArrayList<>();
            another.addAll(prev);
            answers.add(another);
            return ;
        } else if (sum > target) {
            return ;
        } else if (index == candidates.length) {
            return ;
        }
        prev.add(candidates[index]);
        dfs(index, sum + candidates[index], prev);
        prev.removeLast();
        dfs(index + 1, sum, prev);    
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        dfs(0, 0, new ArrayList<>());
        return answers;
    }
}

```

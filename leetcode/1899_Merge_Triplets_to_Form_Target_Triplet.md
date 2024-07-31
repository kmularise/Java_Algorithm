# 1899. Merge Triplets to Form Target Triplet
* https://github.com/kmularise/Java_Algorithm/new/main/leetcode
* 그리디
* 처음의 풀이는 이랬다. 하지만 굳이 정렬을 이용할 필요가 있었을까?
* 후보군을 정할 때, 모든 값이 target 보다 작은 경우를 구해야 한다.
* 그리고 각가의 인덱스에 대해서 해당 값이 있는지 확인해야 한다.
```java
class Solution {
    public int compare(int[] x, int[] y) {
        if (x[0] == y[0]) {
            if (x[1] == y[1]) {
                return Integer.compare(x[2], y[2]);
            }
            return Integer.compare(x[1], y[1]);
        }
        return Integer.compare(x[0], y[0]);
    }
    public boolean equals(int[] triplet, int[] target) {
        if (triplet[0] == target[0] && triplet[1] == target[1] && triplet[2] == target[2]) {
            return true;
        }
        return false;
    }
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> candidates = new ArrayList<>();
        System.out.println(Arrays.deepToString(triplets));
        for (int[] triplet : triplets) {
            boolean isValid = true;
            for (int j = 0 ; j < 3 ; j++) {
                if (triplet[j] > target[j]) {
                    isValid =false;
                    break;
                }
            }
            if (isValid)
                candidates.add(triplet);
        }
        if (candidates.size() ==0) {
            return false;
        }
        candidates.sort((x, y) -> compare(x, y));
        if (equals(candidates.get(0), target)) {
            return true;
        }
        for (int i = 1; i < candidates.size() ;i++) {
            for (int j = 0 ; j < 3; j++) {
                (candidates.get(i))[j] = Math.max((candidates.get(i))[j], (candidates.get(i - 1))[j]);
            }
            if (equals(candidates.get(i), target)) {
                return true;
            }
        }
        return false;
    }
}
```

* 다음은 개선된 풀이이다. 모든 요소의 값이 target보다 작은지 확인 후 해당 triplet에서 target의 요소를 갖고 있는지 확인했다.

```java
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] visited = new boolean[3];
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            for (int i = 0 ; i < triplet.length ; i++) {
                if (target[i] == triplet[i]) {
                    visited[i] = true;
                }
            }
        }
        for (boolean idx : visited) {
            if (!idx) { 
                return false;
            }
        }
        return true;
    }
}
```

```

# 230. Kth Smallest Element in a BST
- 문제 : https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
- 풀이 : DFS
- 시간복잡도 : O(n)
- 이진트리는 가장 왼쪽에 있는 숫자가 가장 작다. 따라서 왼쪽 노드부터 순회를 해주어야 한다.
- 그래서 왼쪽과 오른쪽 노드 사이에 순회할 때 총 지나친 노드의 수를 카운트해주는 로직이 필요하다.

```java
class Solution {
    int count = 0;
    int answer = -1;
    public void dfs(int k, TreeNode current) {
        if (current.left != null) {
            dfs(k, current.left);
        }
        count++;
        if (count == k) {
            answer = current.val;
            return;
        }
        if (current.right != null) {
            dfs(k, current.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(k, root);
        return answer;
    }
}
```

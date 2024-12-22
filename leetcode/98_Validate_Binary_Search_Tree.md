# 98. Validate Binary Search Tree

- 문제 : https://leetcode.com/problems/validate-binary-search-tree/description/
- 풀이 : binary search
- 재귀함수에 비교값을 제대로 넣어줘야 했다.
```java
class Solution {
    public boolean searchTree(TreeNode current, int ll, int rl) {
        if (current.left != null) {
            if (!(ll < current.left.val && current.left.val < current.val)) {
                return false;
            }
            boolean lr = searchTree(current.left, ll, current.val);
            if (!lr) {
                return false;
            }
        }
        if (current.right != null) {
            if (!(current.val < current.right.val && current.right.val < rl)) {
                return false;
            }
            boolean rr = searchTree(current.right, current.val, rl);
            if (!rr) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean result = searchTree(root, -10001, 10001);
        return result;
    }
}
```

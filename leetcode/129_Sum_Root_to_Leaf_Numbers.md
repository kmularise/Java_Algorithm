# 129. Sum Root to Leaf Numbers
* 문제 : https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
* 간단한 DFS 문제, binary tree
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int answer = 0;
    public void dfs(TreeNode prev, int number) {
        if (prev.left == null && prev.right == null) {
            answer += (10 * number + prev.val);
            return ;
        }
        if (prev.left != null) {
            dfs(prev.left, 10 * number + prev.val);
        }
        if (prev.right != null) {
            dfs(prev.right, 10 * number + prev.val);
        }
    }
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return answer;
    }
}
```

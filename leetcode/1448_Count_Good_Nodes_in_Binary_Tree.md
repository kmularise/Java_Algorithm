# 1448. Count Good Nodes in Binary Tree
- 문제 : https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
- 풀이 : BFS
- 시간 복잡도 : O(n)
- 공간 복잡도 : O(n) 
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

class Info {
    TreeNode node;
    int maxVal;
    
    Info(TreeNode node, int maxVal) {
        this.node = node;
        this.maxVal = maxVal;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Queue<Info> queue = new ArrayDeque<>();
        queue.add(new Info(root, root.val));
        while (!queue.isEmpty()) {
            Info info = queue.poll();
            if (info.maxVal == info.node.val) {
                count++;
            }
            if (info.node.left != null) {
                queue.add(new Info(info.node.left, Math.max(info.maxVal, info.node.left.val)));
            }
            if (info.node.right != null) {
                queue.add(new Info(info.node.right, Math.max(info.maxVal, info.node.right.val)));
            }
        }
        return count;
    }
}
```

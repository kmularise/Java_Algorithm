# 199. Binary Tree Right Side View
트리 문제. BFS 변형 풀이인 느낌이다. 시간 복잡도는 O(n)일 거 같다.
https://leetcode.com/problems/binary-tree-right-side-view/description/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightNodes = new ArrayList<>();
        if (root == null) {
            return rightNodes;
        }
        TreeNode current = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> temp = new ArrayDeque<>();
        queue.add(root);
        while (true) {
            int count = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (count == 0) {
                    rightNodes.add(node.val);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
                if (node.left != null) {
                    temp.add(node.left);
                }
                count++;
            }
            if (temp.isEmpty()) {
                break ;
            }
            while (!temp.isEmpty()) {
                queue.add(temp.poll());
            }
        }
        return rightNodes;
    }
}
```


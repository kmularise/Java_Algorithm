# 235. Lowest Common Ancestor of a Binary Search Tree
* 문제 : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
* BST 
* BST의 특징을 이용해서 다시 풀이해보는 것도 좋을 거 같다.
```java
class Solution {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Map<TreeNode, Integer> level = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            level.put(curr, height);
            if (p.val == curr.val) {
                p = curr;
            }
            else if (q.val == curr.val) {
                q = curr;
            }
            if (curr.left != null) {
                parent.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                queue.add(curr.right);
            }
            height++;
        }
        int i = 0;
        TreeNode answer = root;
        while (true) {
            if (q == root || parent.get(p) == q) {
                answer = q;
                break;
            }
            if (p == root || parent.get(q) == p) {
                answer = p;
                break;
            }
            if (level.get(p) > level.get(q)) {
                p = parent.get(p);
            } else {
                q = parent.get(q);
            }
        }
        return answer;
    }
}
```

# 662. Maximum Width of Binary Tree
* 문제 : https://leetcode.com/problems/maximum-width-of-binary-tree/description/
* 이진트리
* 기존의 풀이는 아래와 같다.
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
    
    public int widthOfBinaryTree(TreeNode root) {
        long answer = 0;
        Queue<List<Long>> queue = new ArrayDeque<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        Map<Long, Long> maxMap = new HashMap<>();
        Map<Long, Long> minMap = new HashMap<>();
        nodes.add(root);
        queue.add(List.of(0L , 0L));
        while (!queue.isEmpty()) {
            TreeNode curr = nodes.poll();
            List<Long> infos = queue.poll();
            long compared = maxMap.getOrDefault(infos.get(0), 0L);
            long minCompared = minMap.getOrDefault(infos.get(0), Long.MAX_VALUE);
            maxMap.put(infos.get(0), Math.max(compared, infos.get(1)));
            minMap.put(infos.get(0), Math.min(minCompared, infos.get(1)));
            if (curr.left != null) {
                queue.add(List.of(infos.get(0) + 1L, 2 * infos.get(1)));
                nodes.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(List.of(infos.get(0) + 1L, 2 * infos.get(1) + 1L));
                nodes.add(curr.right);
            }
            
        }
        for (long height : maxMap.keySet()) {
            answer = Math.max(maxMap.get(height) - minMap.get(height) + 1L, answer);
        }
        return (int) answer;
    }
}
```
* 고친 풀이는 다음과 같다. 기존의 풀이대로 overflow 문제가 있어서 그 부분을 막지 못한다. 아래의 풀이처럼 하면 노드가 순서대로 오기 때문에 overflow 문제가 생겨도 길이가 보장이 된다.
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
    public int widthOfBinaryTree(TreeNode root) {
        int answer = 0;
        Queue<TreeNode> nodes = new ArrayDeque<>();
        Queue<List<Integer>> infos = new ArrayDeque<>();
        nodes.add(root);
        infos.add(List.of(0, 0));
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int start =0;
            int end = 0;
            for (int i = 0 ; i < size ; i++) {
                TreeNode curr = nodes.poll();
                List<Integer> info = infos.poll();
                if (i == 0) {
                    start = info.get(1);
                }
                if (i == size - 1) {
                    end = info.get(1);
                }
                if (curr.left != null) {
                    nodes.add(curr.left);
                    infos.add(List.of(info.get(0), 2 * info.get(1)));
                }
                if (curr.right != null) {
                    nodes.add(curr.right);
                    infos.add(List.of(info.get(0), 2 * info.get(1) + 1));
                }
            }
            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }
}
```

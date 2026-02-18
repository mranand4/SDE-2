# Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

https://leetcode.com/problems/binary-tree-paths/description/

# Topics

- String
- Backtracking
- Tree
- Depth-First Search
- Binary Tree

# My naive answer

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

import java.util.List;
import java.util.LinkedList;

class Solution {

    private List<String> backtrack(TreeNode root, List<Integer> curr, List<String> ans) {
        if(root == null) { 
            return ans;
        } 
        
        curr.add(root.val);
        if(root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for(Integer i : curr) {
                sb.append(i);
                sb.append("->");
            }
            sb.setLength(sb.length() - 2);
            ans.add(sb.toString());  
        } else {
            backtrack(root.left, curr, ans);
            backtrack(root.right, curr, ans);
        }
        curr.removeLast();
        return ans;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> curr = new LinkedList<>();
        List<String> ans = new LinkedList<>();
        return backtrack(root, curr, ans);
    }
}

# DFS + Stack

private List<String> dfsWithStack(TreeNode root) {
    List<String> ans = new LinkedList<>();
    Stack<Map.Entry<TreeNode, String>> st = new Stack<>();

    if(root == null) return ans;
    st.push(Map.entry(root, ""));

    while(!st.isEmpty()) {
        Map.Entry<TreeNode, String> entry = st.pop();
        TreeNode node = entry.getKey();
        String val = entry.getValue();

        if(node.left == null && node.right == null) {
            ans.add(val + node.val);
        }

        if(node.left != null) {
            st.push(Map.entry(node.left, val + node.val + "->"));
        }

        if(node.right != null) {
            st.push(Map.entry(node.right, val + + node.val + "->"));
        }
    }

    return ans;
}

# BFS + Queue

private List<String> bfsWithQueue(TreeNode root) {
    List<String> ans = new LinkedList<>();
    Queue<Map.Entry<TreeNode, String>> queue = new LinkedList<>();

    if(root == null) return ans;
    queue.offer(Map.entry(root, ""));

    while(!queue.isEmpty()) {
        Map.Entry<TreeNode, String> entry = queue.poll();
        TreeNode node = entry.getKey();
        String val = entry.getValue();

        if(node.left == null && node.right == null) {
            ans.add(val + node.val);
        }

        if(node.left != null) {
            queue.offer(Map.entry(node.left, val + node.val + "->"));
        }

        if(node.right != null) {
            queue.offer(Map.entry(node.right, val + node.val + "->"));
        }
    }

    return ans;
}

# Notes

Reference link for stack and queue based solutions - https://leetcode.com/problems/binary-tree-paths/solutions/68272/python-solutions-dfsstack-bfsqueue-dfs-r-k9fg/

I implemented these in java myself.
/*
104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth. 
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. 
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
      if(root == null ) return 0;
	  int rightMaxDepth=1;
      int leftMaxDepth=1;
      if(root.right != null){
        rightMaxDepth += maxDepth(root.right);
      }
      if(root.left != null){
        leftMaxDepth += maxDepth(root.left);
      }
      return rightMaxDepth>leftMaxDepth?rightMaxDepth:leftMaxDepth;
    }
}

class Solution {public int maxDepth(TreeNode root) {
        return root==null? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
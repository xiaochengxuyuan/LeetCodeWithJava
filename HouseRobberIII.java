import java.util.HashMap;
import java.util.Map;

/*
337. House Robber III
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/
public class Solution {

    public static class TreeNode {
        int val;
        Test.TreeNode left;
        Test.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * 我的解法
     */
    public static Map<Test.TreeNode,Integer> resultMap = new HashMap<>();
    public static int rob(Test.TreeNode root) {
        if (root ==  null) return 0;
        if (resultMap.containsKey(root)){
            return resultMap.get(root);
        }
        int rootValue = 0;
        int leftAndRightValue = 0;
        rootValue += root.val;
        if (root.left != null) {
            rootValue += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            rootValue += rob(root.right.left) + rob(root.right.right);
        }
        leftAndRightValue = rob(root.right) + rob(root.left);
        int result = rootValue > leftAndRightValue ? rootValue : leftAndRightValue;
        resultMap.put(root,result);
        return result;
    }

    /*
     * 网上大神的解法，很巧妙
     */
    public int rob(Test.TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }
    public int[] robSub(Test.TreeNode root){
        if(root == null)
            return new int[2];

        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // do not choose current node
        res[1] = root.val + left[0] + right[0]; // choose current node

        return res;
    }
}
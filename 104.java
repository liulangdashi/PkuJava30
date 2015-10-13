/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        else if(root.left == null && root.right == null)
            return 1;
        else if(root.left == null && root.right != null)
            return maxDepth(root.right)+1;
         else if(root.right == null && root.left != null)
            return maxDepth(root.left)+1;
        else
        {
            int l = maxDepth(root.left);
            int r = maxDepth(root.right);
            return (l+1)>(r+1)?(l+1):(r+1);
        }
    }
}
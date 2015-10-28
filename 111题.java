public class Solution {
    public int minDepth(TreeNode root) {
     if (root == null)
            return 0;
        if (root.left == null && root.right == null)
             return 1;
        int leftDepth = minDepth(root.left);
         int rightDepth = minDepth(root.right);
        
         if (leftDepth == 0)
             return rightDepth + 1;
        else if (rightDepth == 0)
             return leftDepth + 1;
        else
             return leftDepth<rightDepth?leftDepth+1:rightDepth+1;   
    }
}
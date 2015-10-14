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
    //利用的递归的方法
    public int maxDepth(TreeNode root) {
        int count=1,left=0,right=0;
        if(root==null) return 0;
        left=maxDepth(root.left);//left统计左子数路径长度
        right=maxDepth(root.right);//right统计右子数路径长度
        return left>right?left+1:right+1;
        
        
    }
}
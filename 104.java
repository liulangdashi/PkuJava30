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
    //���õĵݹ�ķ���
    public int maxDepth(TreeNode root) {
        int count=1,left=0,right=0;
        if(root==null) return 0;
        left=maxDepth(root.left);//leftͳ��������·������
        right=maxDepth(root.right);//rightͳ��������·������
        return left>right?left+1:right+1;
        
        
    }
}
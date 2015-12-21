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
    // ArrayList<Integer> ss=new ArrayList<Integer>();
    public boolean isSymmetric(TreeNode root) {
    //     if(root == null) return true;
        
    //     func(root,ss);
    //     for(int i=0,j=ss.size()-1;i<j;i++,j--){
    //         if(ss.get(i)!=ss.get(j))
    //             return false;
    //     }
    //     return true;
        if(root==null) 
            return true;
        if(root.left==null && root.right==null ) 
            return true;
        return func(root.left,root.right);
    }
    //用递归法判断左右节点是否相等
    public boolean  func(TreeNode r1, TreeNode r2){
        if(r1 == null && r2==null) 
            return true;
        if(r1 != null && r2==null) 
            return false;
        if(r1 == null && r2!=null) 
            return false;
        if(r1.val!=r2.val) return false;
        return func(r1.left,r2.right)&&func(r1.right,r2.left);
    }
}
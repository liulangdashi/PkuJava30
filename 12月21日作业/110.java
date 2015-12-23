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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        int x = 0;
        x = getHeight(root.left) - getHeight(root.right);
        if(x < -1 || x > 1){
        	return false;
        }
        else{
        	boolean boolLeft =  isBalanced(root.left);
        	boolean boolRight = isBalanced(root.right);
        	if(boolLeft && boolRight){
        		return true;
        	}
        	else{
        		return false;
        	}
        }
    }
    public int getHeight(TreeNode root){
    	int height = 0;
    	if(root == null)
    		return 0;
//    	else if(root.left == null && root.right ==null){
//    		return 1;
//   	}
    	else{
    		int heightLeft = getHeight(root.left);
    		int heightRight = getHeight(root.right);
//    		height =  heightLeft > heightLeft ? heightLeft : heightRight;
    		height =  heightLeft > heightRight ? heightLeft : heightRight;
    		return height + 1;
    	}
    }
}
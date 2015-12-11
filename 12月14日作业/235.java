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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
/*        TreeNode result = null;
        if(hasNode(p, q)){
        	result = p;
        }else if(hasNode(q, p)){
        	result = q;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()){
        	TreeNode head = list.remove(0);
        	TreeNode left = head.left;
        	TreeNode right = head.right;
        	if(!hasNode(left, q) && hasNode(right, q) && !hasNode(right, p) && hasNode(left, p)){
        		result = head;
        		break;
        	}
        	else{
        		if(left != null){
        			list.add(left);
        		}
        		if(right != null){
        			list.add(right);
        		}
        	}
        }
        return result;
    }
    boolean hasNode(TreeNode node1, TreeNode node2){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(node1 == null)
        	return false;
        list.add(node1);
        while(!list.isEmpty()){
        	TreeNode headNode = list.remove(0);
        	if(headNode.equals(node2)){
        		return true;
        	}
        	else{
        		if(headNode.left != null)
        			list.add(headNode.left);
        		if(headNode.right != null)
        			list.add(headNode.right);
        	}
        }
        return false;
    }
*/
        TreeNode result = null;
        if(root == null || p == null || q == null){
        	return null;
        }
        if(root.val < p.val && root.val < q.val){
        	result = lowestCommonAncestor(root.right, p, q);
        }
        else if(root.val > p.val && root.val > q.val){
        	result = lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val == p.val || root.val == q.val 
        		|| (root.val > p.val && root.val < q.val)
        		|| (root.val < p.val && root.val > q.val)){
        	result =  root;
        }
        return result;
    }
}
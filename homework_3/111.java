public class Solution {
    public int minDepth(TreeNode root) {
        //对二叉树进行层次遍历，由于是按层遍历的，因此如果在某一层发现了一个叶子节点，那么就找到了最小深度，此时返回当前深度即可
         if(root==null)
             return 0;
         int level=0;
         List<TreeNode> pre=new ArrayList<TreeNode>();
        pre.add(root);
        
        while(pre.size()!=0){
            level++;
            List<TreeNode> p=new ArrayList<TreeNode>();
            for(int i=0;i<pre.size();i++){
                if(pre.get(i).left!=null)
                    p.add(pre.get(i).left);
                
                if(pre.get(i).right!=null)
                    p.add(pre.get(i).right);
                if(pre.get(i).left==null&&pre.get(i).right==null)
                    return level;
            }
            if(p.size()==0)
                break;
            else 
                pre=p;
        }
        return level;
    }
}
public class Solution {
    //利用的递归的方法
    public int maxDepth(TreeNode root) {
        // int count=1,left=0,right=0;
        // if(root==null) return 0;
        // left=maxDepth(root.left);//left统计左子数路径长度
        // right=maxDepth(root.right);//right统计右子数路径长度
        // return left>right?left+1:right+1;
         if(root==null)//利用层次遍历，遍历到最后一层，然后将最后一层的深度返回
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
            }
            if(p.size()==0)
                break;
            else 
                pre=p;
        }
        return level;
        
        // if(root==null) 
        //     return 0;
        // int high=0;
        // List<TreeNode> onelevel=new ArrayList<TreeNode>();
        // onelevel.add(root);
        // while(onelevel.size()!=0){
        //     high++;
        //     List<TreeNode> nextlevel=new ArrayList<TreeNode>();
        //     for(int i=0;i<onelevel.size();i++){
        //         TreeNode current=onelevel.get(i);
        //         if(current.left!=null)
        //             nextlevel.add(current.left);
        //         if(current.right!=null)
        //             nextlevel.add(current.right);
        //     }
        //     if(nextlevel.size()==0)
        //         break;
        //     else 
        //         onelevel=nextlevel;
        // }
        // return high;
    }
}
public class Solution {
    //���õĵݹ�ķ���
    public int maxDepth(TreeNode root) {
        // int count=1,left=0,right=0;
        // if(root==null) return 0;
        // left=maxDepth(root.left);//leftͳ��������·������
        // right=maxDepth(root.right);//rightͳ��������·������
        // return left>right?left+1:right+1;
         if(root==null)//���ò�α��������������һ�㣬Ȼ�����һ�����ȷ���
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
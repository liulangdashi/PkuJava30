public class Solution {
    public int minDepth(TreeNode root) {
        //�Զ��������в�α����������ǰ�������ģ���������ĳһ�㷢����һ��Ҷ�ӽڵ㣬��ô���ҵ�����С��ȣ���ʱ���ص�ǰ��ȼ���
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
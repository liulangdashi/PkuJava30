public class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // Arrays.sort(nums);
        // int i=0,j=1;
        // while(i<nums.length-1&&j<nums.length){
        //     if(nums[i]==nums[j])
        //         return false;
        // }
        // return true;
        
//�ù�ϣset����ÿ�μ���Ԫ�������жϹ�ϣ������û����ͬ��Ԫ�أ��оͷ���true��������������ϣ��û�еĻ����ͷ���false
        if(nums.length==0||nums.length==1) 
            return false;
        Set<Integer> uniqSet=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(uniqSet.contains(nums[i]))
                return true;
            else 
                uniqSet.add(nums[i]);
        }
        return false;
        
        // if(nums.length==0||nums.length==1) 
        //     return false;
        
        
    }
}
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // Arrays.sort(nums);
        // int i=0,j=1;
        // while(i<nums.length-1&&j<nums.length){
        //     if(nums[i]==nums[j])
        //         return false;
        // }
        // return true;
        
//用哈希set做，每次加入元素是先判断哈希表中有没有相同的元素，有就返回true。遍历玩整个哈希表都没有的话，就返回false
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
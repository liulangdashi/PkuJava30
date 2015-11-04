public class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
         Arrays.sort(nums);
        int prev=nums[0];
        int count=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == prev){
                count++;
                if(count > nums.length/2) return nums[i];
            }else{
                count=1;
                prev = nums[i];
            }
        }
         return 0;
    }
}